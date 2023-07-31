-- Dummy data for Event table
INSERT INTO event (title, description, date, location) VALUES
                                                           ('Alumni Reunion', 'Join us for our alumni reunion.', '2023-08-15', 'University Campus'),
                                                           ('Networking Workshop', 'Learn valuable networking tips.', '2023-09-10', 'Conference Center'),
                                                           ('Career Fair', 'Connect with potential employers.', '2023-10-20', 'Exhibition Hall'),
                                                           ('Industry Conference', 'Stay updated on the latest trends.', '2023-11-05', 'Convention Center'),
                                                           ('Leadership Summit', 'Enhance your leadership skills.', '2023-12-01', 'Grand Hotel');

-- Dummy data for JobExperience table
INSERT INTO job_experience (company_name, position, start_date, end_date, description) VALUES
                                                                                        ('ABC Company', 'Software Engineer', '2010-05-15', '2015-08-30', 'Developed web applications.'),
                                                                                        ('XYZ Corporation', 'Marketing Manager', '2015-09-01', '2020-12-31', 'Managed marketing campaigns.'),
                                                                                        ('DEF Solutions', 'Data Analyst', '2018-02-20', '2022-06-30', 'Analyzed and visualized data.'),
                                                                                        ('GHI Tech', 'Product Manager', '2020-10-10', '2023-03-15', 'Led product development efforts.'),
                                                                                        ('JKL Innovations', 'Software Developer', '2022-01-05', '2023-06-30', 'Worked on mobile app development.');

-- Dummy data for News table
INSERT INTO news (title, description, publish_date) VALUES
                                                       ('University Achievements', 'Our university ranked top in the country.', '2023-07-20'),
                                                       ('Alumni Spotlight', 'Jane Smith recognized for her achievements.', '2023-07-25'),
                                                       ('New Scholarship Program', 'Introducing a scholarship for exceptional students.', '2023-08-01'),
                                                       ('Upcoming Campus Expansion', 'We are expanding our campus infrastructure.', '2023-08-10'),
                                                       ('Faculty Research Award', 'Dr. John Doe receives research award.', '2023-08-18');

