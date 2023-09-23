package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepo extends JpaRepository<Survey, Integer> {
}
