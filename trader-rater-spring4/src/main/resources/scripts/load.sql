INSERT INTO solution_type(solution_type_id, description, title) VALUES (1, 'Builder', 'Builder');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (2, 'Bricklayer', 'Bricklayer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (3, 'Carpet Fitter', 'Carpet Fitter');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (4, 'Caterer', 'Caterer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (5, 'Chimney Sweep', 'Chimney Sweep');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (6, 'Cleaner',  'Cleaner');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (7, 'Electrician',  'Electrician');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (8, 'Gardener',  'Gardener');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (9, 'Glazier',  'Glazier');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (10, 'Joiner',  'Joiner');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (11, 'Kitchen Fitter', 'Kitchen Fitter');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (12, 'Landscape Gardener', 'Landscape Gardener');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (13, 'Locksmith',  'Locksmith');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (14, 'Painter and Decorator',  'Painter and Decorator');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (15, 'Plasterer',  'Plasterer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (16, 'Plumber',  'Plumber');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (17, 'Printer',  'Printer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (18, 'Roofer',  'Roofer');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (19, 'Tiler',  'Tiler');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (20, 'Tree Surgeon', 'Tree Surgeon');
INSERT INTO solution_type(solution_type_id, description, title) VALUES (21, 'Window Cleaner', 'Window Cleaner');

-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (22, 'Baker',  'Baker');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (23, 'Hairstylist',  'Hairstylist');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (24, 'Bartender',  'Bartender');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (25, 'Blacksmith',  'Blacksmith');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (26, 'Pastry chef', 'Pastry chef');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (27, 'Piano tuner', 'Piano tuner');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (28, 'Steeplejack',  'Steeplejack');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (29, 'Stonemason',  'Stonemason');
-- INSERT INTO solution_type(solution_type_id, description, title) VALUES (30, 'Welder',  'Welder');

/* solution_task_type */

INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (50, 'Extension', 'Extension', 1);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (51, 'Garage Conversion', 'Garage Conversion', 1);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (52, 'Plastering', 'Plastering', 1);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (53, 'Kitchen Fitting', 'Kitchen Fitting', 1);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (54, 'Bathroom Fitting', 'Bathroom Fitting', 1);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (55, 'Other', 'Other', 1);

INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (60, 'Garden Wall', 'Garden Wall', 2);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (61, 'Repair Wall', 'Repair Wall', 2);
INSERT INTO solution_task_type(solution_task_type_id, description, title, solution_type_id) VALUES (62, 'Other', 'Other', 2);

/* solution_task_job_type */

INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (60, 'Test', 'Test', 50);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (61, 'Test', 'Test', 50);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (62, 'Test', 'Test', 50);

INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (70, 'Test', 'Test', 60);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (71, 'Test', 'Test', 60);
INSERT INTO solution_task_job_type(solution_task_job_type_id, description, title, solution_task_type_id) VALUES (72, 'Test', 'Test', 60);


