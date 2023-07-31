
INSERT INTO user ( email, password, first_name, last_name, role)
VALUES
    ('user1@example.com', 'password123', 'John', 'Doe', 'ALUMNI'),
    ( 'user2@example.com', 'securepass', 'Alice', 'Smith', 'ADMIN'),
    ( 'user3@example.com', 'password456', 'Bob', 'Johnson', 'ALUMNI');


INSERT INTO job ( title, description, state, city, company_name)
VALUES
    ( 'Software Engineer', 'Develop and maintain software applications', 'California', 'San Francisco', 'ABC Corp'),
    ( 'Data Analyst', 'Analyze and interpret data for business insights', 'New York', 'New York City', 'XYZ Inc'),
    ( 'Product Manager', 'Manage product development and strategy', 'Texas', 'Austin', 'Acme Corp');


INSERT INTO profile ( state, city, graduation_year, phone, email, profile_picture)
VALUES
    ( 'California', 'San Francisco', 2022, '123-456-7890', 'john@example.com', 'profile_pic_1.jpg'),
    ( 'New York', 'New York City', 2021, '987-654-3210', 'jane@example.com', 'profile_pic_2.jpg'),
    ('Texas', 'Austin', 2023, '555-555-5555', 'bob@example.com', 'profile_pic_3.jpg');
