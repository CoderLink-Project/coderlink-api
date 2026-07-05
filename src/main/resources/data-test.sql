
-- Tabla Admin
INSERT INTO customer (first_name, dni, last_name, name_company, ruc, phone, user_id) VALUES
                                                                                        ('Carlos', '12345678', 'Mendoza', 'TechCorp', '123456789', '987654321', 1);

-- Tabla User
INSERT INTO user (id, username, email, pass, created_at, updated_at, role) VALUES
                                                                               (1, 'jdoe', 'jdoe@example.com', 'password123', '2024-01-01', '2024-01-05', 'CUSTOMER'),
                                                                               (2, 'asmith', 'asmith@example.com', 'password456', '2024-02-01', '2024-02-03', 'DEVELOPER');


-- Tabla Customer
INSERT INTO customer (first_name, dni, last_name, name_company, ruc, phone, user_id) VALUES
    ('Carlos', '12345678', 'Mendoza', 'TechCorp', '123456789', '987654321', 1);

-- Tabla Developer
INSERT INTO developer (dni, first_name, last_name, portfolio, skills, hours_worked, payment_rate, work_experience, years_experience, project_id, user_id) VALUES
                                                                                                                                                              ('87654321', 'Lucía', 'Gómez', 'https://portfolio.example.com', 'Java, Spring Boot, React', 120, 45.50, '5 años de experiencia en desarrollo full-stack', 5, 1, 2);

-- Tabla joboffer
INSERT INTO joboffer (description, budget, duration, createdAt, updatedAt, customer_id, project_id) VALUES
                                                                                                        ('Desarrollo de una plataforma de e-commerce', 5000.00, 30, '2024-09-01', '2024-09-10', 1, 1);
-- Tabla Project
INSERT INTO project (name, description, milestones, presentation, revisions, status, category_project, qualification, createdAt, updatedAt, customer_id, developer_id) VALUES
                                                                                                                                                                           ('Proyecto Freelance', 'Proyecto para el desarrollo de una plataforma', 'Milestone 1', 'Presentación inicial', 3, 'En progreso', 'Desarrollo Web', 4.5, '2024-09-20 12:00:00', '2024-09-20 12:30:00', 1, 2);


-- Tabla Skill
INSERT INTO skill (name, description) VALUES
                                          ('Java', 'Lenguaje de programación orientado a objetos'),
                                          ('Spring Boot', 'Framework para el desarrollo de aplicaciones web en Java');

-- Tabla skills_project (relación entre proyecto y habilidades)
INSERT INTO skills_project (skill_id, project_id) VALUES
                                                      (1, 1),  -- Relaciona una habilidad con un proyecto
                                                      (2, 1);  -- Otra relación de habilidad con el mismo proyecto


-- Tabla postulations (Postulaciones de los desarrolladores a ofertas)
INSERT INTO postulations (status, postulation_date, description, developer_id) VALUES
                                                                                   ('Pending', '2024-09-20 14:30:00', 'Postulación para nuevo proyecto', 1);

-- Tabla payment
INSERT INTO payment (transactionDate, total, totalDate, paymentMethod, facturation, createdAt, updatedAt, project_id, customer_id) VALUES
                                                                                                                                       ('2024-09-01 10:00:00', 1500.00, '2024-09-01 10:00:00', 'Credit Card', 'Invoice #001', '2024-09-01 10:00:00', '2024-09-10 15:00:00', 1, 1);

