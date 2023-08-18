-- Admin Table
INSERT INTO Admin (id) VALUES (1);
INSERT INTO Admin (id) VALUES (2);
-- News Table
INSERT INTO News (id, title, content, date_published, admin_id) VALUES (1, 'News 1', 'This is news content 1.', '2023-08-01', 1);
INSERT INTO News (id, title, content, date_published, admin_id) VALUES (2, 'News 2', 'This is news content 2.', '2023-08-02', 2);
-- Alumni Table
INSERT INTO Alumni (id, contact_information, location, university_name, degree, graduation_year, gpa, job_title, award) VALUES (1, 1890, 'New York', 'University A', 'BSc Computer Science', 2021, 3.5, 'Software Engineer', 'Best Alumni Award');
INSERT INTO Alumni (id, contact_information, location, university_name, degree, graduation_year, gpa, job_title, award) VALUES (2, 9210, 'California', 'University B', 'BEng Electrical Engineering', 2020, 3.8, 'Electrical Engineer', 'Excellence in Research');

-- Event Table
INSERT INTO Event (id ,title, description, location, event_date, alumni_id) VALUES (1, 'WAA Orientation by Prof. Tacettin Umur Inan', 'Discuss what the course will cover', 'Fairfield', '2023-08-04 09:00:00.987654', 1);
INSERT INTO Event (id, title, description, location, event_date, alumni_id) VALUES (2, 'Java Orientation MIU', 'How to get into development', 'Fairfield', '2023-10-20 09:00:00.987654', 2);


-- JobPortal Table
INSERT INTO job_portal (id, job_title, company, job_description, dead_line, city, state, alumni_id) VALUES (1, 'Software Engineer', 'Tech Company A', 'Job description for Software Engineer position.', '2023-08-30', 'New York', 'NY', 1);
INSERT INTO job_portal (id, job_title, company, job_description, dead_line, city, state, alumni_id) VALUES (2, 'Electrical Engineer', 'Tech Company B', 'Job description for Electrical Engineer position.', '2023-08-25', 'California', 'CA', 2);
-- Survey Table
INSERT INTO Survey (id, title, description, survey_date, feed_back, alumni_id) VALUES (1, 'Survey 1', 'This is survey 1 description.', '2023-08-05', 'Good', 1);
INSERT INTO Survey (id, title, description, survey_date, feed_back, alumni_id) VALUES (2, 'Survey 2', 'This is survey 2 description.', '2023-08-12', 'Excellent', 2);
-- User Table
INSERT INTO User (id, name, username, password, role, alumni_id) VALUES (1, 'John Doe', 'john.doe', 'password123', 'ROLE_USER', 1);
INSERT INTO User (id, name, username, password, role, alumni_id) VALUES (2, 'Jane Smith', 'jane.smith', 'pass123word', 'ROLE_USER', 2);
-- Insert data into the event_attendent_list table (join table)
INSERT INTO event_attendent_list (events_id, attendent_list_id) VALUES (1, 1); -- Event with id 1 has alumni with id 1 attending
INSERT INTO event_attendent_list (events_id, attendent_list_id) VALUES (1, 2); -- Event with id 1 has alumni with id 2 attending
INSERT INTO event_attendent_list (events_id, attendent_list_id) VALUES (2, 2); -- Event with id 2 has alumni with id 2 attending

/*-- Insert data into the admin table
INSERT INTO admin (id) VALUES (1);*/

/*-- Insert data into the alumni table
INSERT INTO alumni (id, contact_information, location, university_name, degree, graduation_year, gpa, job_title, award)
VALUES (1, 123450, 'New York', 'ABC University', 'Computer Science', 2020, 3.8, 'Software Engineer', 'Best Employee Award');
*/
/*-- Insert data into the event table
INSERT INTO event (id, title, description, location, event_date, alumni_id)
VALUES (1, 'Tech Conference', 'A conference on technology trends', 'California', '2023-08-15 09:00:00', 1);
*/
/*-- Insert data into the job_portal table
INSERT INTO job_portal (id, job_title, company, job_description, dead_line, city, state, alumni_id)
VALUES (1, 'Software Developer', 'XYZ Corp', 'Job description for software developer', '2023-08-31', 'San Francisco', 'CA', 1);
*/
/*-- Insert data into the news table
INSERT INTO news (id, title, content, date_published, admin_id)
VALUES (1, 'New Product Launch', 'We are launching a new product next week', '2023-08-01', 1);*/

/*-- Insert data into the survey table
INSERT INTO survey (id, title, description, survey_date, feed_back, alumni_id)
VALUES (1, 'Alumni Satisfaction Survey', 'Please provide feedback on our alumni services', '2023-08-10', 'Great event!', 1);
*/
-- Insert data into the user table
/*INSERT INTO user (id, name, username, password, role, alumni_id)
VALUES (1, 'John Doe', 'johndoe', 'password123', 'ROLE_USER', 1);*/

-- Insert data into the event_attendent_list table
/*INSERT INTO event_attendent_list (events_id, attendent_list_id) VALUES (1, 1);
*/
