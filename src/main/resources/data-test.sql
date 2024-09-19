
-- Tabla User
INSERT INTO User (id, dni, names, last_names, email, password, type_User) VALUES
                                                                              (1, '123456789', 'James', 'Pérez', 'james.perez@example.com', 'password123', 'ADMIN'),
                                                                              (2, '987654321', 'Lucía', 'Gómez', 'lucia.gomez@example.com', 'password123', 'DEVELOPER'),
                                                                              (3, '456789123', 'Carlos', 'Mendoza', 'carlos.mendoza@example.com', 'password123', 'CUSTOMER');
    ON CONFLICT DO NOTHING;
-- Tabla Customer
INSERT INTO Customer (id_customer, dni, company_name, ruc, phone) VALUES
    (1, '456789123', 'Mendoza Tech', '20345678901', '987654321');

-- Tabla Developer
INSERT INTO Developer (id_developer, dni, portfolio, hours_worked, payment_rate, work_experience, years_experience) VALUES
    (1, '987654321', 'https://portfolio.com/lucia', 150, 25, 'Backend Development', 3);

-- Tabla Project
INSERT INTO Project (id_project, name, description, milestones, presentation, revision, status, category, qualification, createdAt, updatedAt) VALUES
                                                                                                                                                   (1, 'Web Platform Development', 'Develop a freelance platform', 'Milestone 1', 'Online Presentation', 'Reviewed', 'ACTIVE', 'Web Development', 4.5, NOW(), NOW()),
                                                                                                                                                   (2, 'Mobile App for E-commerce', 'Build an e-commerce mobile app', 'Milestone 2', 'Initial Presentation', 'Pending', 'PENDING', 'Mobile Development', 0, NOW(), NOW());

-- Tabla Skill
INSERT INTO skill (id_skill, name, description) VALUES
                                                    (1, 'Java', 'Experience in Java programming language'),
                                                    (2, 'Spring Boot', 'Experience in Spring Boot framework'),
                                                    (3, 'MySQL', 'Experience in MySQL database management');

-- Tabla skills_project (relación entre proyecto y habilidades)
INSERT INTO skills_project (id_skills_project, id_project, id_skill) VALUES
                                                                         (1, 1, 1),  -- Java for Project 1
                                                                         (2, 1, 2),  -- Spring Boot for Project 1
                                                                         (3, 2, 3);  -- MySQL for Project 2

-- Tabla job_offer (Ofertas de trabajo)
INSERT INTO job_offer (id_offer, id_customer, id_project, description, budget, duration, publication_date) VALUES
                                                                                                               (1, 1, 1, 'Looking for a backend developer for a web platform', 2000, '3 months', NOW()),
                                                                                                               (2, 1, 2, 'Mobile app developer needed for e-commerce', 3000, '4 months', NOW());

-- Tabla postulations (Postulaciones de los desarrolladores a ofertas)
INSERT INTO postulations (id_postulations, id_developer, id_offer, postulation_date, status) VALUES
                                                                                                 (1, 1, 1, NOW(), 'PENDING'),
                                                                                                 (2, 1, 2, NOW(), 'PENDING');

-- Tabla Payment (Pagos realizados)
INSERT INTO Payment (id, transaction_date, total, total_date, payment_method, facturation, createdAt, updatedAt) VALUES
    (1, NOW(), 5000, NOW(), 'Credit Card', 'Paid in full', NOW(), NOW());
