package com.waa.project.repository.specifications;

import com.waa.project.entity.JobAdvertisement;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class JobAdvertisementSpecification implements Specification<JobAdvertisement> {

    private String state;
    private String city;
    private String companyName;

    public JobAdvertisementSpecification(String state, String city, String companyName) {
        this.state = state;
        this.city = city;
        this.companyName = companyName;
    }

    public static Specification<JobAdvertisement> byState(String state) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("state"), state);
    }

    public static Specification<JobAdvertisement> byCity(String city) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("city"), city);
    }

    public static Specification<JobAdvertisement> byCompanyName(String companyName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("companyName"), companyName);
    }

    @Override
    public Predicate toPredicate(Root<JobAdvertisement> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (state != null)
            predicates.add(criteriaBuilder.equal(root.get("state"), state));
        if (city != null)
            predicates.add(criteriaBuilder.equal(root.get("city"), city));
        if (companyName != null)
            predicates.add(criteriaBuilder.equal(root.get("companyName"), companyName));


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
