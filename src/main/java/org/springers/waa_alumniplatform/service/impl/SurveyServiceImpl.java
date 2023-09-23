package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springers.waa_alumniplatform.dto.survey.SurveyTitle;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.Survey;
import org.springers.waa_alumniplatform.entity.SurveyAnswer;
import org.springers.waa_alumniplatform.entity.SurveyQuestion;
import org.springers.waa_alumniplatform.exception.EntityNotFound;
import org.springers.waa_alumniplatform.repository.SurveyRepo;
import org.springers.waa_alumniplatform.service.AlumniService;
import org.springers.waa_alumniplatform.service.SurveyAnswerService;
import org.springers.waa_alumniplatform.service.SurveyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepo surveyRepo;
    private final ModelMapper modelMapper;
    private final SurveyAnswerService surveyAnswerService;
    private final AlumniService alumniService;
    @Override
    public Survey persist(Survey survey) {
        return surveyRepo.save(survey);
    }

    @Override
    public Survey updateOne(Survey survey, int surveyId) {
        Survey surveyInDB = getById(surveyId);
        surveyInDB.setTitle(survey.getTitle());
        surveyInDB.setQuestions(survey.getQuestions());
        return persist(surveyInDB);
    }

    @Override
    public Survey getById(int survey_Id){
        Survey survey = surveyRepo.findById(survey_Id)
                .orElseThrow(() -> new EntityNotFound("Survey not found"));
        return survey;
    }

    @Override
    public List<SurveyTitle> getAll() {
        List<Survey> surveys = surveyRepo.findAll();
        List<SurveyTitle> surveyTitles = new ArrayList<>();
        surveys.forEach(survey -> {
            surveyTitles.add(modelMapper.map(survey, SurveyTitle.class));
        });
        return surveyTitles;
    }

    @Override
    public Survey getOneSpecificToAlumni(int surveyId, int alumniId) {
        Survey wholeSurvey = getById(surveyId);
        Survey deepCopiedSurvey = getNewSurveyObjAndRemoveAnsFromEveryQuestion(wholeSurvey);
        setAlumniAnswerForEveryQuestion(deepCopiedSurvey, alumniId);
        return deepCopiedSurvey;
    }

    @Override
    public Survey saveSurveyResponses(Survey survey, int surveyId, int alumniId) {
        Survey surveyInDB = getById(surveyId);
        Alumni alumni = alumniService.getAlumniById(alumniId);
        //TODO make sure @RequestBody survey questions has id
        addNewAnswersToDB(surveyInDB, survey, alumni);
        surveyRepo.save(surveyInDB);
        return survey;
    }

    private void addNewAnswersToDB(Survey surveyInDB, Survey survey, Alumni responder){
        surveyInDB.getQuestions().forEach(surveyQuestionInDB -> {
            survey.getQuestions().forEach(surveyQuestion -> {
                if(surveyQuestion.getId() == surveyQuestionInDB.getId()){
                    surveyQuestion.getSurveyAnswerList().forEach(surveyAnswer -> {
                        surveyAnswer.setResponder(responder);
                        surveyAnswer.setSurveyQuestion(surveyQuestionInDB);
                        surveyQuestionInDB.getSurveyAnswerList().add(surveyAnswer);
                    });
                }
            });
        });
    }

    private void setAlumniAnswerForEveryQuestion(Survey surveyWithoutAnswers, int alumniId){
        surveyWithoutAnswers.getQuestions().forEach(surveyQuestion -> {
            surveyQuestion.setSurveyAnswerList(new ArrayList<>());
            SurveyAnswer surveyAnswer = surveyAnswerService
                    .findSurveyAnswerByResponderIdAndQuestionId(surveyQuestion.getId(), alumniId);
            if(surveyAnswer != null) surveyQuestion.getSurveyAnswerList().add(surveyAnswer);
        });
    }

    private Survey getNewSurveyObjAndRemoveAnsFromEveryQuestion(Survey wholeSurvey){
        Survey surveyWithOutAnswer = Survey.builder()
                .title(wholeSurvey.getTitle())
                .questions(new ArrayList<>())
                .build();
        List<SurveyQuestion> surveyWithAlumniAnswersOnlyQues = surveyWithOutAnswer.getQuestions();
        wholeSurvey.getQuestions().forEach(wholeSurveyQuestion -> {
            surveyWithAlumniAnswersOnlyQues.add(
                    SurveyQuestion.builder()
                            .question(wholeSurveyQuestion.getQuestion())
                            .id(wholeSurveyQuestion.getId())
                            .build()
            );
        });
        return surveyWithOutAnswer;
    }
}
