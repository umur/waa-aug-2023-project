package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.SurveyAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SurveyAnswerRepo extends JpaRepository<SurveyAnswer, Integer> {
    SurveyAnswer findSurveyAnswerBySurveyQuestionIdAndResponderId(int questionId, int responderId);
}
