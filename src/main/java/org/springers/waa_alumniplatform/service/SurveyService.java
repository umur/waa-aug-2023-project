package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.survey.SurveyTitle;
import org.springers.waa_alumniplatform.entity.Survey;

import java.util.List;

public interface SurveyService {
    Survey persist(Survey survey);

    Survey updateOne(Survey survey, int surveyId);
    Survey getById(int survey_Id);

    List<SurveyTitle> getAll();

    Survey getOneSpecificToAlumni(int surveyId, int alumniId);

    Survey saveSurveyResponses(Survey survey, int surveyId, int alumniId);
}
