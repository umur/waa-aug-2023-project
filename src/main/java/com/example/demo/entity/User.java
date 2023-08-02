package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isDeleted = false;

    @OneToMany
    @JoinColumn(name="user_id")
    @Cascade(CascadeType.ALL)
    private List<Survey> surveys;

    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<SurveyAnswer> surveyAnswerList;

    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<SurveyQuestion> surveyQuestionList;

    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    @OneToOne(mappedBy = "user")
    private Profile profile;

    @JsonManagedReference
    @OneToMany(mappedBy = "organizer")
    @Cascade(CascadeType.ALL)
    private List<Event> events;

    @JsonManagedReference
    @OneToMany(mappedBy = "publisher")
    @Cascade(CascadeType.ALL)
    private List<News> news;

    @JsonManagedReference
    @OneToMany(mappedBy = "postedBy")
    private List<Job> postedJobs;

    @JsonIgnore
    @OneToMany(mappedBy = "applicant")
    private List<JobApplication> jobApplications;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isDeleted;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
