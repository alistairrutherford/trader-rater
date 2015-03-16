INSERT INTO solution_type(solution_type_id, description, title) VALUES (0, 'Builder', 'Builder');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (1, 'Bricklayer', 'Bricklayer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (2, 'Carpet Fitter', 'Carpet Fitter');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (3, 'Caterer', 'Caterer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (4, 'Chimney Sweep', 'Chimney Sweep');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (5, 'Cleaner',  'Cleaner');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (6, 'Electrician',  'Electrician');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (7, 'Gardener',  'Gardener');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (8, 'Glazier',  'Glazier');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (9, 'Joiner',  'Joiner');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (10, 'Kitchen Fitter', 'Kitchen Fitter');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (11, 'Landscape Gardener', 'Landscape Gardener');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (12, 'Locksmith',  'Locksmith');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (13, 'Painter and Decorator',  'Painter and Decorator');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (14, 'Plasterer',  'Plasterer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (15, 'Plumber',  'Plumber');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (16, 'Printer',  'Printer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (17, 'Roofer',  'Roofer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (18, 'Tiler',  'Tiler');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (19, 'Tree Surgeon', 'Tree Surgeon');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (20, 'Window Cleaner', 'Window Cleaner');

-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (21, 'Baker',  'Baker');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (22, 'Hairstylist',  'Hairstylist');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (23, 'Bartender',  'Bartender');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (24, 'Blacksmith',  'Blacksmith');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (25, 'Pastry chef', 'Pastry chef');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (26, 'Piano tuner', 'Piano tuner');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (27, 'Steeplejack',  'Steeplejack');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (28, 'Stonemason',  'Stonemason');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (29, 'Welder',  'Welder');

/* solution_task_type */

INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (50, 'Test', 'Task Type #1', 0);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (51, 'Test', 'Task Type #2', 0);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (52, 'Test', 'Task Type #3', 0);

INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (60, 'Test', 'Test Task Type #1', 1);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (61, 'Test', 'Test Task Type #2', 1);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (62, 'Test', 'Test Task Type #3', 1);

/* solution_task_job_type */

INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (60, 'Test', 'Test', 50);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (61, 'Test', 'Test', 50);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (62, 'Test', 'Test', 50);

INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (70, 'Test', 'Test', 60);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (71, 'Test', 'Test', 60);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (72, 'Test', 'Test', 60);


