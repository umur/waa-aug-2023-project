package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Integer> {
}
