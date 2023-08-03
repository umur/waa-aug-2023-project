package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.entity.SurveyAnswer;
import org.springers.waa_alumniplatform.repository.SurveyAnswerRepo;
import org.springers.waa_alumniplatform.service.SurveyAnswerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyAnswerServiceImpl implements SurveyAnswerService {
    private final SurveyAnswerRepo surveyAnswerRepo;

    @Override
    public SurveyAnswer findSurveyAnswerByResponderIdAndQuestionId(int questionId, int alumniId) {
        return surveyAnswerRepo.findSurveyAnswerBySurveyQuestionIdAndResponderId(questionId, alumniId);
    }
}
