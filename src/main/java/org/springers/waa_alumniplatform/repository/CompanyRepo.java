package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
}
