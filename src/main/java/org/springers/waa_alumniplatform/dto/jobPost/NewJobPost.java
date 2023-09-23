package org.springers.waa_alumniplatform.dto.jobPost;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.Company;
import org.springers.waa_alumniplatform.entity.Industry;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class NewJobPost {
    private String position;
    private String skills;
    private String otherReq;
    private Industry industry;
    private Company company;
    private LocalDateTime postedAt;
}
