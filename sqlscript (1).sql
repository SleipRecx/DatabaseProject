CREATE TABLE trainingSession (
  session_id int unsigned AUTO_INCREMENT NOT NULL,
  date date,
  duration int,
  PRIMARY KEY (session_id)
);

/* weak */
CREATE TABLE Notes (
  note_id int unsigned NOT NULL PRIMARY KEY
  REFERENCES trainingSession(session_id) ON DELETE CASCADE ON UPDATE CASCADE,
  personal_shape int(1),
  preformance int(1),
  exercisePurpose varchar(255),
  tips varchar(255)
);

CREATE TABLE Category (
  category_id int unsigned AUTO_INCREMENT NOT NULL,
  type varchar(50),
  PRIMARY KEY(category_id)
);

CREATE TABLE Exercise (
  exercise_id int unsigned NOT NULL AUTO_INCREMENT,
  category_id_fk int unsigned,
  name varchar(50),
  description varchar(255),
  PRIMARY KEY (exercise_id),
  FOREIGN KEY (category_id_fk) REFERENCES Category(category_id)
  ON UPDATE CASCADE
  ON DELETE SET NULL
);

CREATE TABLE Goals (
  goal_id int unsigned AUTO_INCREMENT NOT NULL,
  exercise_id_fk int unsigned,
  within_date date,
  PRIMARY KEY(goal_id)
);

CREATE TABLE Result (
  result_id int unsigned AUTO_INCREMENT NOT NULL,
  exercise_id_fk int unsigned NOT NULL,
  trainingSession_id_fk int unsigned NOT NULL,
  PRIMARY KEY(result_id),
  FOREIGN KEY(exercise_id_fk) REFERENCES Exercise(exercise_id),
  FOREIGN KEY(trainingSession_id_fk) REFERENCES trainingSession(session_id)
);

CREATE TABLE Templates (
  template_id int unsigned AUTO_INCREMENT NOT NULL,
  name varchar(50),
  exercise_id_fk int unsigned,
  template_active smallint,
  PRIMARY KEY(template_id),
  FOREIGN KEY(exercise_id_fk) REFERENCES Exercise(exercise_id) ON UPDATE CASCADE
);

/* -------------- SPLEISETABELLER -------------- */
CREATE TABLE can_replace_exercise (
  exercise_id_fk int unsigned NOT NULL,
  can_replace_id_fk int unsigned NOT NULL,
  FOREIGN KEY(exercise_id_fk) REFERENCES Exercise(exercise_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(can_replace_id_fk) REFERENCES Exercise(exercise_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE category_belongs (
  parentCatergory_id_fk int unsigned NOT NULL,
  category_id_fk int unsigned NOT NULL,
  FOREIGN KEY(parentCategory_id_fk) REFERENCES Category(Category_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(category_id_fk) REFERENCES Category(category_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE exercise_in_template (
  template_id_fk int unsigned,
  exercise_id_fk int unsigned,
  FOREIGN KEY(template_id_fk) REFERENCES Templates(template_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(exercise_id_fk) REFERENCES Exercise(exercise_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Exercise_in_trainingSession(
  session_id_fk int unsigned NOT NULL,
  exercise_id_fk int unsigned NOT NULL,
  FOREIGN KEY(session_id_fk) REFERENCES trainingSession(session_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(exercise_id_fk) REFERENCES Exercise(exercise_id) ON UPDATE CASCADE ON DELETE CASCADE
);

/* -------------- ARVETABELLER -------------- */
CREATE TABLE outdoor_training (
  session_id_fk int unsigned,
  weather_condtition varchar(255),
  temp decimal(3,1),
  FOREIGN KEY (session_id_fk) REFERENCES trainingSession(session_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE indoor_training (
  session_id_fk int unsigned,
  ventilation varchar(255),
  spectators int,
  FOREIGN KEY(session_id_fk) REFERENCES trainingSession(session_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE strength_conditon_to_result (
  result_id_fk int unsigned,
  weight int,
  reps int,
  sets int,
  FOREIGN KEY(result_id_fk) REFERENCES Result(result_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE endurance_to_result (
  result_id_fk int unsigned,
  km decimal(10,2),
  time int,
  FOREIGN KEY(result_id_fk) REFERENCES Result(result_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE strength_condition_to_goals (
  goal_id_fk int unsigned,
  weight int,
  reps int,
  FOREIGN KEY(goal_id_fk) REFERENCES Goals(goal_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE endurance_to_goals (
  goal_id_fk int unsigned,
  km decimal(10,2),
  time int,
  FOREIGN KEY(goal_id_fk) REFERENCES Goals(goal_id) ON DELETE CASCADE ON UPDATE CASCADE
);