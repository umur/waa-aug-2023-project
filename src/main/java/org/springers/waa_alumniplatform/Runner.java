package org.springers.waa_alumniplatform;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springers.waa_alumniplatform.entity.*;
import org.springers.waa_alumniplatform.enums.AccountStatus;
import org.springers.waa_alumniplatform.enums.Role;
import org.springers.waa_alumniplatform.repository.AlumniRepo;
import org.springers.waa_alumniplatform.repository.CompanyRepo;
import org.springers.waa_alumniplatform.repository.JobPostRepo;
import org.springers.waa_alumniplatform.repository.LocationRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class Runner  {
    private final AlumniRepo alumniRepo;
    private final JobPostRepo jobPostRepo;
    private final LocationRepo locationRepo;
    private final CompanyRepo companyRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    //    private final EntityManager em;
//        @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>> Runner Started >>>>>>>>>>>");


        Industry industry1 = Industry.builder().name("Information Technology").build();
        Industry industry2 = Industry.builder().name("Design and Creative").build();
        Industry industry3 = Industry.builder().name("Marketing").build();
        Industry industry4 = Industry.builder().name("Finance").build();
        Industry industry5 = Industry.builder().name("Healthcare").build();


        Location location1 = Location.builder().state("CA").city("San Francisco").street("1369 Mission Street").zipcode(94103).build();
        // Location 2
        Location location2 = Location.builder().state("NY").city("New York").street("123 Broadway").zipcode(10001).build();
        // Location 3
        Location location3 = Location.builder().state("TX").city("Austin").street("456 Congress Ave").zipcode(78701).build();
        // Location 4
        Location location4 = Location.builder().state("IL").city("Chicago").street("789 Michigan Ave").zipcode(60601).build();
        // Location 5
        Location location5 = Location.builder().state("WA").city("Seattle").street("987 Pine Street").zipcode(98101).build();


        Company company1 = Company.builder().name("Google").location(location1).build();
        // Company 2
        Company company2 = Company.builder().name("Apple").location(location2).build();
        // Company 3
        Company company3 = Company.builder().name("Microsoft").location(location3).build();
        // Company 4
        Company company4 = Company.builder().name("Amazon").location(location4).build();
        // Company 5
        Company company5 = Company.builder().name("Facebook").location(location5).build();


        Alumni alumni1 = Alumni.builder().firstName("John").lastName("Smith").email("1alumni@demo.com").password(passwordEncoder.encode("123")).isAccountNonLocked(true).industry(industry1).location(location1).role(Role.ALUMNI).accountStatus(AccountStatus.ACTIVE).build();
        // Alumni 2
        Alumni alumni2 = Alumni.builder().firstName("Jane").lastName("Doe").email("2alumni@demo.com").password(passwordEncoder.encode("123")).isAccountNonLocked(true).industry(industry2).location(location2).role(Role.ALUMNI).accountStatus(AccountStatus.ACTIVE).build();
        // Alumni 3
        Alumni alumni3 = Alumni.builder().firstName("Michael").lastName("Johnson").email("3alumni@demo.com").password(passwordEncoder.encode("123")).isAccountNonLocked(true).industry(industry3).location(location3).role(Role.ALUMNI).accountStatus(AccountStatus.ACTIVE).build();
        // Alumni 4
        Alumni alumni4 = Alumni.builder().firstName("Emily").lastName("Williams").email("4alumni@demo.com").password(passwordEncoder.encode("123")).isAccountNonLocked(true).industry(industry4).location(location4).role(Role.ALUMNI).accountStatus(AccountStatus.ACTIVE).build();
        // Alumni 5
        Alumni alumni5 = Alumni.builder().firstName("David").lastName("Brown").email("5alumni@demo.com").password(passwordEncoder.encode("123")).isAccountNonLocked(true).industry(industry5).location(location5).role(Role.ALUMNI).accountStatus(AccountStatus.ACTIVE).build();

        alumniRepo.save(alumni1);
        alumniRepo.save(alumni2);
        alumniRepo.save(alumni3);
        alumniRepo.save(alumni4);
        alumniRepo.save(alumni5);

        JobPost jobPost1 = JobPost.builder()
                .poster(alumni1)
                .industry(industry1)
                .company(company1)
                .applicants(List.of(alumni2, alumni3, alumni4, alumni5))
                .position("Software Engineer")
                .skills("Bachelor’s Degree in Computer Science or related discipline required\n" +
                        "5+ years of Java experience\n" +
                        "5+ years of SQL and SQL tuning experience\n" +
                        "Extensive enterprise-level JEE application development experience\n" +
                        "Data modelling skills (i.e. conceptual, logical and physical model design)\n" +
                        "Experience in handling very large DBs (Oracle and MS-SQL), and large data volumes")
                .otherReq("\"Working knowledge of code Version Control using SVN or Git or Maven, Gradle, and Jira\\n\" +\n" +
                        "                \"In depth knowledge and understanding of database structures, theories, principals, practices and demonstrated performance tuning skills\\n\" +\n" +
                        "                \"Strong experience with Full JEE stack (Core Java, JDBC, JSP/Servlets), Oracle PL/SQL, MS-SQL Stored Procedure, Configuring Spring Framework, Javascript, jQuery, HTML5, variety of software development experience\\n\" +\n" +
                        "                \"Strong oral and written communications skills with ability to create software design and engineering documents\");\n")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 06, 24), LocalTime.of(04, 30)))
                .build();

        // Job Post 2
        JobPost jobPost2 = JobPost.builder()
                .poster(alumni2)
                .industry(industry2)
                .company(company2)
                .applicants(List.of(alumni1, alumni4, alumni3))
                .position("Data Analyst")
                .skills("Bachelor’s Degree in Statistics, Mathematics, or related field\n" +
                        "Proficiency in data analysis tools such as Python, R, or similar\n" +
                        "Experience with data visualization and reporting tools\n" +
                        "Strong problem-solving skills and attention to detail\n" +
                        "Ability to work with large datasets and perform complex queries")
                .otherReq("Experience in designing and implementing data models\n" +
                        "Familiarity with machine learning concepts is a plus\n" +
                        "Excellent communication skills to present findings to non-technical stakeholders\n" +
                        "Ability to work independently and as part of a team")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 06, 25), LocalTime.of(10, 15)))
                .build();

// Job Post 3
        JobPost jobPost3 = JobPost.builder()
                .poster(alumni5)
                .industry(industry5)
                .company(company5)
                .applicants(List.of(alumni4, alumni2))
                .position("Marketing Manager")
                .skills("Bachelor’s Degree in Marketing or related field\n" +
                        "Proven experience in developing and executing marketing strategies\n" +
                        "Strong understanding of digital marketing channels\n" +
                        "Excellent communication and leadership skills\n" +
                        "Analytical mindset with the ability to interpret market trends")
                .otherReq("Experience with marketing automation tools\n" +
                        "Ability to manage a team and collaborate cross-functionally\n" +
                        "Creative thinking and problem-solving abilities\n" +
                        "Track record of successful campaign management")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 06, 26), LocalTime.of(14, 45)))
                .build();

// Job Post 4
        JobPost jobPost4 = JobPost.builder()
                .poster(alumni1)
                .industry(industry1)
                .company(company1)
                .applicants(List.of(alumni2, alumni3, alumni4, alumni5))
                .position("Graphic Designer")
                .skills("Bachelor’s Degree in Graphic Design or related field\n" +
                        "Proficiency in Adobe Creative Suite (Photoshop, Illustrator, InDesign)\n" +
                        "Strong portfolio showcasing creative design work\n" +
                        "Understanding of design principles and trends\n" +
                        "Ability to work collaboratively and meet deadlines")
                .otherReq("Experience in both print and digital design\n" +
                        "Attention to detail and a keen eye for aesthetics\n" +
                        "Ability to take constructive feedback and iterate on designs\n" +
                        "Knowledge of UI/UX design is a plus")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 06, 27), LocalTime.of(9, 30)))
                .build();

// Job Post 5
        JobPost jobPost5 = JobPost.builder()
                .poster(alumni2)
                .industry(industry2)
                .company(company2)
                .applicants(List.of(alumni1, alumni4, alumni3))
                .position("Sales Representative")
                .skills("Bachelor’s Degree in Business or related field\n" +
                        "Proven track record in sales and achieving targets\n" +
                        "Excellent communication and negotiation skills\n" +
                        "Customer-focused approach and ability to build relationships\n" +
                        "Strong organizational and time management abilities")
                .otherReq("Experience in B2B sales is a plus\n" +
                        "Familiarity with CRM software\n" +
                        "Willingness to travel for client meetings\n" +
                        "Positive and resilient attitude")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 06, 28), LocalTime.of(11, 00)))
                .build();

        // Job Post 6
        JobPost jobPost6 = JobPost.builder()
                .poster(alumni5)
                .industry(industry5)
                .company(company5)
                .applicants(List.of(alumni4, alumni2))
                .position("Product Manager")
                .skills("Bachelor’s Degree in Business, Marketing, or related field\n" +
                        "Proven experience in product management\n" +
                        "Strong analytical and problem-solving skills\n" +
                        "Ability to prioritize features and manage product roadmap\n" +
                        "Excellent communication and collaboration skills")
                .otherReq("Experience with Agile methodologies\n" +
                        "Ability to gather and analyze customer feedback\n" +
                        "Familiarity with UX/UI principles\n" +
                        "Leadership and team management capabilities")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 06, 29), LocalTime.of(13, 15)))
                .build();

// Job Post 7
        JobPost jobPost7 = JobPost.builder()
                .poster(alumni1)
                .industry(industry1)
                .company(company1)
                .applicants(List.of(alumni2, alumni3, alumni4, alumni5))
                .position("Financial Analyst")
                .skills("Bachelor’s Degree in Finance, Accounting, or related field\n" +
                        "Proficiency in financial modeling and analysis\n" +
                        "Strong knowledge of Excel and financial software\n" +
                        "Attention to detail and accuracy\n" +
                        "Ability to interpret financial data and trends")
                .otherReq("Experience in budgeting and forecasting\n" +
                        "Excellent written and verbal communication skills\n" +
                        "Understanding of market and industry trends\n" +
                        "Certifications such as CFA or CPA are a plus")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 06, 30), LocalTime.of(15, 30)))
                .build();

// Job Post 8
        JobPost jobPost8 = JobPost.builder()
                .poster(alumni2)
                .industry(industry2)
                .company(company2)
                .applicants(List.of(alumni1, alumni4, alumni3))
                .position("Human Resources Specialist")
                .skills("Bachelor’s Degree in Human Resources or related field\n" +
                        "Experience in HR processes and regulations\n" +
                        "Strong interpersonal and communication skills\n" +
                        "Attention to detail and confidentiality\n" +
                        "Ability to handle employee relations and conflict")
                .otherReq("Knowledge of labor laws and compliance\n" +
                        "Experience in recruitment and onboarding\n" +
                        "Problem-solving and decision-making abilities\n" +
                        "HR certification is a plus")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 01), LocalTime.of(10, 00)))
                .build();

// Job Post 9
        JobPost jobPost9 = JobPost.builder()
                .poster(alumni5)
                .industry(industry5)
                .company(company5)
                .applicants(List.of(alumni4, alumni2))
                .position("Quality Assurance Engineer")
                .skills("Bachelor’s Degree in Computer Science or related field\n" +
                        "Experience in manual and automated testing\n" +
                        "Knowledge of testing methodologies and tools\n" +
                        "Strong problem-solving skills\n" +
                        "Attention to detail and thoroughness")
                .otherReq("Familiarity with Agile/Scrum processes\n" +
                        "Ability to write test cases and perform regression testing\n" +
                        "Understanding of software development lifecycle\n" +
                        "Experience with continuous integration tools")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 02), LocalTime.of(11, 45)))
                .build();

// Job Post 10
        JobPost jobPost10 = JobPost.builder()
                .poster(alumni1)
                .industry(industry1)
                .company(company1)
                .applicants(List.of(alumni2, alumni3, alumni4, alumni5))
                .position("Content Writer")
                .skills("Bachelor’s Degree in English, Journalism, or related field\n" +
                        "Proven writing experience in a professional setting\n" +
                        "Strong command of grammar and style\n" +
                        "Ability to research and write about various topics\n" +
                        "Creativity and adaptability in writing style")
                .otherReq("Experience in SEO writing is a plus\n" +
                        "Strong editing and proofreading skills\n" +
                        "Ability to meet deadlines and work independently\n" +
                        "Portfolio of published writing samples")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 03), LocalTime.of(14, 30)))
                .build();
// Job Post 11
        JobPost jobPost11 = JobPost.builder()
                .poster(alumni2)
                .industry(industry2)
                .company(company2)
                .applicants(List.of(alumni1, alumni4, alumni3))
                .position("IT Support Specialist")
                .skills("Bachelor’s Degree in Information Technology or related field\n" +
                        "Experience in technical support and troubleshooting\n" +
                        "Knowledge of operating systems and hardware\n" +
                        "Strong communication and customer service skills\n" +
                        "Ability to diagnose and resolve technical issues")
                .otherReq("Familiarity with helpdesk ticketing systems\n" +
                        "Experience in remote support and desktop management\n" +
                        "Basic understanding of networking concepts\n" +
                        "Certifications such as CompTIA A+ or Microsoft Certified: Modern Desktop Administrator is a plus")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 04), LocalTime.of(9, 15)))
                .build();

// Job Post 12
        JobPost jobPost12 = JobPost.builder()
                .poster(alumni5)
                .industry(industry5)
                .company(company5)
                .applicants(List.of(alumni4, alumni2))
                .position("Project Manager")
                .skills("Bachelor’s Degree in Business, Project Management, or related field\n" +
                        "Proven experience in project management\n" +
                        "Strong organizational and leadership skills\n" +
                        "Ability to manage cross-functional teams\n" +
                        "Excellent communication and negotiation abilities")
                .otherReq("Experience with project management tools\n" +
                        "Understanding of Agile and Waterfall methodologies\n" +
                        "Risk management and problem-solving capabilities\n" +
                        "PMP certification is a plus")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 05), LocalTime.of(12, 30)))
                .build();

// Job Post 13
        JobPost jobPost13 = JobPost.builder()
                .poster(alumni1)
                .industry(industry1)
                .company(company1)
                .applicants(List.of(alumni2, alumni3, alumni4, alumni5))
                .position("UX/UI Designer")
                .skills("Bachelor’s Degree in Design, HCI, or related field\n" +
                        "Proficiency in UI/UX design tools (e.g., Sketch, Adobe XD)\n" +
                        "Strong portfolio demonstrating user-centered design\n" +
                        "Understanding of user research and usability principles\n" +
                        "Creativity and innovation in design solutions")
                .otherReq("Experience in designing for web and mobile\n" +
                        "Collaboration with development teams and stakeholders\n" +
                        "Knowledge of design systems and responsive design\n" +
                        "Ability to iterate on designs based on feedback")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 06), LocalTime.of(15, 00)))
                .build();

// Job Post 14
        JobPost jobPost14 = JobPost.builder()
                .poster(alumni2)
                .industry(industry2)
                .company(company2)
                .applicants(List.of(alumni1, alumni4, alumni3))
                .position("Social Media Manager")
                .skills("Bachelor’s Degree in Marketing, Communications, or related field\n" +
                        "Proven experience in social media management\n" +
                        "Strong understanding of various social platforms\n" +
                        "Excellent written and visual communication skills\n" +
                        "Ability to analyze and interpret social media metrics")
                .otherReq("Experience in content creation and copywriting\n" +
                        "Familiarity with social media scheduling tools\n" +
                        "Creativity in developing engaging social campaigns\n" +
                        "Ability to stay up-to-date with social media trends")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 07), LocalTime.of(10, 45)))
                .build();

// Job Post 15
        JobPost jobPost15 = JobPost.builder()
                .poster(alumni5)
                .industry(industry5)
                .company(company5)
                .applicants(List.of(alumni4, alumni2))
                .position("Mechanical Engineer")
                .skills("Bachelor’s Degree in Mechanical Engineering or related field\n" +
                        "Experience in mechanical design and analysis\n" +
                        "Proficiency in CAD software (e.g., SolidWorks, AutoCAD)\n" +
                        "Strong understanding of materials and manufacturing processes\n" +
                        "Problem-solving skills for complex mechanical challenges")
                .otherReq("Ability to work collaboratively in cross-functional teams\n" +
                        "Knowledge of engineering standards and regulations\n" +
                        "Experience in prototyping and testing\n" +
                        "Strong communication skills to convey technical concepts")
                .postedAt(LocalDateTime.of(LocalDate.of(2023, 07, 8), LocalTime.of(11, 30)))
                .build();


        jobPostRepo.save(jobPost1);
        jobPostRepo.save(jobPost2);
        jobPostRepo.save(jobPost3);
        jobPostRepo.save(jobPost4);
        jobPostRepo.save(jobPost5);
        jobPostRepo.save(jobPost6);
        jobPostRepo.save(jobPost7);
        jobPostRepo.save(jobPost8);
        jobPostRepo.save(jobPost9);
        jobPostRepo.save(jobPost10);
        jobPostRepo.save(jobPost11);
        jobPostRepo.save(jobPost12);
        jobPostRepo.save(jobPost13);
        jobPostRepo.save(jobPost14);
        jobPostRepo.save(jobPost15);
        System.out.println("***************** 15 Job Posts inserted **************");
    }
}
