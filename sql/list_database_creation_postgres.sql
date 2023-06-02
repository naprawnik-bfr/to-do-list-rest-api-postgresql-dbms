DROP TABLE lists;

CREATE TABLE lists (
	list_id SERIAL PRIMARY KEY,
	list_name TEXT UNIQUE
);

INSERT INTO lists
(list_name)
VALUES 	
('Shopping list'),
('Gym exercises'),
('Films to watch');

SELECT * FROM lists;

DROP TABLE tasks;

CREATE TABLE tasks (
	task_id SERIAL PRIMARY KEY,
	list_id INT REFERENCES lists(list_id),
	task_description TEXT UNIQUE,
	is_completed BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO tasks
(list_id, task_description)
VALUES 	
(1, 'cheese'),
(1, 'onion'),
(1, 'chewing gum'),
(1, 'butter'),
(1, 'milk'),
(1, 'tea'),
(1, 'coffee'),
(1, 'bread'),
(2, 'squats'),
(2, 'push-ups'),
(2, 'running'),
(2, 'pull-ups'),
(3, 'One flew over the cuckoos nest'),
(3, 'Rocky III'),
(3, 'Once Upon a Time in America');

SELECT * FROM lists
NATURAL LEFT JOIN tasks 
ORDER BY list_id;

