-- Tabla User
--INSERT INTO users (id, username, email, pass, created_at, updated_at, role_id, dtype, description,dni) VALUES
                                                                             -- (1, 'jdoe', 'jdoe@example.com', 'password123', '2024-01-01', '2024-01-05', 2,1, 'desc','dni'),
                                                                            --(2, 'asmith', 'asmith@example.com', 'password456', '2024-02-01', '2024-02-03', 1,1,'desc','dni');

-- Tabla Customer
--INSERT INTO customer (first_name, dni, last_name, name_company, phone, user_id, cust_id) VALUES
   --('Carlos', '12345678', 'Mendoza', 'TechCorp', '987654321', 1,1);

-- Tabla Admin
--INSERT INTO admin (first_name, dni, last_name, name_company, phone, user_id) VALUES
--('Carlos', '12345678', 'Mendoza', 'TechCorp', '987654321', 1);

-- Tabla Developer
--INSERT INTO developer (dni, first_name, last_name, portfolio, skills, hours_worked, payment_rate, work_experience, years_experience, project_id, user_id, id) VALUES
    --('87654321', 'LucÃ­a', 'GÃ³mez', 'https://portfolio.example.com', 'Java, Spring Boot, React', 120, 45.50, '5 aÃ±os de experiencia en desarrollo full-stack', 5, null, 2, 2);

-- Tabla Project
--INSERT INTO project (name, description, milestones, presentation, revision, status, category_project, qualification, created_At, updated_At, customer_id, developer_id) VALUES
--('Proyecto Freelance', 'Proyecto para el desarrollo de una plataforma', 'Milestone 1', 'PresentaciÃ³n inicial', 3, 'En progreso', 'Desarrollo Web', 4.5, '2024-09-20 12:00:00', '2024-09-20 12:30:00', 1, 2);

-- Tabla joboffer
--INSERT INTO joboffer (description, budget, duration, created_At, updated_At, customer_id, project_id) VALUES
--('Desarrollo de una plataforma de e-commerce', 5000.00, 30, '2024-09-01', '2024-09-10', 1, 6);

-- Tabla Skill
--INSERT INTO skill (name, description) VALUES
                                         -- ('Java', 'Lenguaje de programaciÃ³n orientado a objetos'),
                                         -- ('Spring Boot', 'Framework para el desarrollo de aplicaciones web en Java');

-- Tabla skills_project (relaciÃ³n entre proyecto y habilidades)
--INSERT INTO skills_project (skill_id, project_id) VALUES
                                                   --   (1, 6),  -- Relaciona una habilidad con un proyecto
                                                   --   (2, 6);  -- Otra relaciÃ³n de habilidad con el mismo proyecto


-- Tabla postulations (Postulaciones de los desarrolladores a ofertas)
--INSERT INTO postulations (status, postulation_date, description, developer_id) VALUES
 --'Pending', '2024-09-20 14:30:00', 'PostulaciÃ³n para nuevo proyecto', 2);

-- Tabla payment
--INSERT INTO payment (transaction_date, total, total_date, payment_method, facturation, created_at, updated_at, project_id, customer_id) VALUES
--('2024-09-01 10:00:00', 1500.00, '2024-09-01 10:00:00', 'Credit Card', 'Invoice #001', '2024-09-01 10:00:00', '2024-09-10 15:00:00', 6, 1);
