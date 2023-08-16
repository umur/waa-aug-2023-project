-- Dummy data for User table
INSERT INTO user ( email, password, first_name, last_name, role, is_deleted)
VALUES
    ( 'user1@example.com', 'password123', 'John', 'Doe', 'ADMIN', false),
    ( 'user2@example.com', 'securepass', 'Alice', 'Smith', 'ADMIN', false),
    ( 'user3@example.com', 'password456', 'Bob', 'Johnson', 'ADMIN', false),
    ( 'user4@example.com', 'securepass', 'Alicee', 'Smith', 'ADMIN', false),
    ( 'user5@example.com', 'password456', 'Bobs', 'Johnson', 'ADMIN', false);

-- Dummy data for Job table
INSERT INTO job ( title, description, state, city, company_name, is_deleted, user_id)
VALUES
    ( 'Software Engineer', 'Develop and maintain software applications', 'California', 'San Francisco', 'ABC Corp', false, 1),
    ( 'Data Analyst', 'Analyze and interpret data for business insights', 'New York', 'New York City', 'XYZ Inc', false, 2),
    ( 'Product Manager', 'Manage product development and strategy', 'Texas', 'Austin', 'Acme Corp', false, 3);

-- Dummy data for Job application
INSERT INTO job_application (job_id, user_id, application_date, is_deleted)
VALUES (1, 2, '2023-08-01', false),
       (2, 1, '2023-08-02', false);


-- Dummy data for Profile table
INSERT INTO profile ( state, city, graduation_year, phone, email, profile_picture, user_id, is_deleted)
VALUES
    ( 'California', 'San Francisco', 2022, '123-456-7890', 'john@example.com', 'profile_pic_1.jpg', 1, false),
    ( 'New York', 'New York City', 2021, '987-654-3210', 'jane@example.com', 'profile_pic_2.jpg', 2, false),
    ('Texas', 'Austin', 2023, '555-555-5555', 'bob@example.com', 'profile_pic_3.jpg', 3, false),
    ( 'California', 'San Francisco', 2022, '123-456-7890', 'john@example.com', 'profile_pic_1.jpg', 4, false),
    ( 'New York', 'New York City', 2021, '987-654-3210', 'jane@example.com', 'profile_pic_2.jpg', 5, false);

-- Dummy data for Course table
INSERT INTO Course (name, profile_id) VALUES
                                          ('Math 101', 1),
                                          ('English 101', 1),
                                          ('Science 101', 2),
                                          ('History 101', 2);

-- Dummy data for Event table
INSERT INTO Event (title, description, date, location, is_deleted, organizer_id)
VALUES
    ('Sample Event 1', 'This is a sample event description 1.', '2023-08-10', 'Sample Location 1', false, 1),
    ('Sample Event 2', 'This is a sample event description 2.', '2023-08-15', 'Sample Location 2', false, 2),
    ('Sample Event 3', 'This is a sample event description 3.', '2023-08-20', 'Sample Location 3', false, 3),
    ('Sample Event 4', 'This is a sample event description 4.', '2023-08-25', 'Sample Location 4', false, 4),
    ('Sample Event 5', 'This is a sample event description 5.', '2023-08-30', 'Sample Location 5', false, 5);

-- Dummy data for JobExperience table
INSERT INTO Job_experience (company_name, position, start_date, end_date, description, is_deleted, profile_id)
VALUES
    ('Sample Company 1', 'Sample Position 1', '2020-01-01', '2021-12-31', 'This is a sample job experience description 1.', false, 1),
    ('Sample Company 2', 'Sample Position 2', '2018-06-15', '2022-03-31', 'This is a sample job experience description 2.', false, 2),
    ('Sample Company 3', 'Sample Position 3', '2019-03-01', '2023-07-31', 'This is a sample job experience description 3.', false, 3),
    ('Sample Company 4', 'Sample Position 4', '2022-02-10', '2023-08-01', 'This is a sample job experience description 4.', false, 4),
    ('Sample Company 5', 'Sample Position 5', '2017-09-05', '2023-08-31', 'This is a sample job experience description 5.', false, 5);


-- Insert dummy New 
INSERT INTO News (title, description, publish_date, is_deleted, publisher_id)
VALUES
    ('Sample News 1', 'This is a sample news description 1.', '2023-08-05', false, 1),
    ('Sample News 2', 'This is a sample news description 2.', '2023-08-12', false, 2),
    ('Sample News 3', 'This is a sample news description 3.', '2023-08-18', false, 3),
    ('Sample News 4', 'This is a sample news description 4.', '2023-08-22', false, 4),
    ('Sample News 5', 'This is a sample news description 5.', '2023-08-28', false, 5);

-- Dummy Users
INSERT INTO user (email, password, first_name, last_name, role, is_deleted) VALUES
                                                                                ('john.doe@example.com', 'password123', 'John', 'Doe', 'STUDENT', false),
                                                                                ('jane.smith@example.com', '12345', 'Jane', 'Smith', 'ADMIN', false),
                                                                                ('michael.johnson@example.com', 'hello123', 'Michael', 'Johnson', 'FACULTY', false);



-- Dummy Surveys
INSERT INTO survey (title, description, start_date, end_date, is_active, created_at, update_at, is_deleted, user_id) VALUES
                                                                                                                         ('Survey 1', 'This is survey 1 description', '2023-08-02 12:00:00', '2023-08-10 12:00:00', true, '2023-08-02 08:00:00', '2023-08-02 08:00:00', false, 1),
                                                                                                                         ('Survey 2', 'Survey 2 description goes here', '2023-08-03 10:00:00', '2023-08-15 10:00:00', true, '2023-08-03 08:00:00', '2023-08-03 08:00:00', false, 2);

-- Dummy SurveyQuestions
INSERT INTO survey_question (question, question_type, is_required, is_deleted, created_at, update_at, survey_id) VALUES
                                                                                                                     ('What is your name?', 'TEXT_FIELD', true, false, '2023-08-02 10:00:00', '2023-08-02 10:00:00', 1),
                                                                                                                     ('Which programming language do you prefer?', 'RADIO_BUTTON', true, false, '2023-08-02 10:00:00', '2023-08-02 10:00:00', 1),
                                                                                                                     ('Select your favorite colors.', 'CHECK_BOX', true, false, '2023-08-02 10:00:00', '2023-08-02 10:00:00', 2);

-- Dummy SurveyAnswers
INSERT INTO survey_answer (answer, created_at, is_deleted, survey_question_id, user_id) VALUES
                                                                                            ('John Doe', '2023-08-02 11:00:00', false, 1, 1),
                                                                                            ('Java', '2023-08-02 11:00:00', false, 2, 1),
                                                                                            ('Choice A, Choice C', '2023-08-02 11:00:00', false, 3, 1),
                                                                                            ('Jane Smith', '2023-08-02 11:00:00', false, 1, 2),
                                                                                            ('Python', '2023-08-02 11:00:00', false, 2, 2),
                                                                                            ('Choice B', '2023-08-02 11:00:00', false, 3, 2),
                                                                                            ('Michael Johnson', '2023-08-02 11:00:00', false, 1, 3),
                                                                                            ('JavaScript', '2023-08-02 11:00:00', false, 2, 3),
                                                                                            ('Choice A, Choice B', '2023-08-02 11:00:00', false, 3, 3);

-- Dummy Choices
INSERT INTO choice (content, survey_question_id) VALUES
                                                     ('Choice A', 1),
                                                     ('Choice B', 1),
                                                     ('Choice C', 1),
                                                     ('Choice X', 2),
                                                     ('Choice Y', 2),
                                                     ('Choice Z', 2),
                                                     ('Choice Red', 3),
                                                     ('Choice Blue', 3),
                                                     ('Choice Green', 3);