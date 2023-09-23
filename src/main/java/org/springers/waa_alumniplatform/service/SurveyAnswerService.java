package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.entity.SurveyAnswer;

public interface SurveyAnswerService {
    SurveyAnswer findSurveyAnswerByResponderIdAndQuestionId(int id, int alumniId);
}
