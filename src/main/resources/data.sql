
INSERT INTO user (id, email, password, first_name, last_name, role)
VALUES (1, 'user1@example.com', 'password123', 'John', 'Doe', 'ALUMNI');
INSERT INTO user (id, email, password, first_name, last_name, role)
VALUES (2, 'user2@example.com', 'securepass', 'Alice', 'Smith', 'ADMIN');
INSERT INTO user (id, email, password, first_name, last_name, role)
VALUES (3, 'user3@example.com', 'password456', 'Bob', 'Johnson', 'ALUMNI');


INSERT INTO job (id, title, description, state, city, company_name)
VALUES (1, 'Software Engineer', 'Develop and maintain software applications', 'California', 'San Francisco', 'ABC Corp');
INSERT INTO job (id, title, description, state, city, company_name)
VALUES (2, 'Data Analyst', 'Analyze and interpret data for business insights', 'New York', 'New York City', 'XYZ Inc');
INSERT INTO job (id, title, description, state, city, company_name)
VALUES (3, 'Product Manager', 'Manage product development and strategy', 'Texas', 'Austin', 'Acme Corp');


INSERT INTO profile (id, state, city, graduation_year, phone, email, profile_picture)
VALUES
    (1, 'California', 'San Francisco', 2022, '123-456-7890', 'john@example.com', 'profile_pic_1.jpg'),
    (2, 'New York', 'New York City', 2021, '987-654-3210', 'jane@example.com', 'profile_pic_2.jpg'),
    (3, 'Texas', 'Austin', 2023, '555-555-5555', 'bob@example.com', 'profile_pic_3.jpg');
