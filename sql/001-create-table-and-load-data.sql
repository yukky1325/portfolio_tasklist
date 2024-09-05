DROP TABLE IF EXISTS active_tasklists;

CREATE TABLE active_tasklists (
  task_id VARCHAR(8) NOT NULL,
  client VARCHAR(50) NOT NULL,
  contractor VARCHAR(50) NOT NULL,
  task VARCHAR(256) NOT NULL,
  deadline VARCHAR(10) NOT NULL,
  done BOOLEAN,
  PRIMARY KEY(task_id)
);

INSERT INTO active_tasklists(task_id,client,contractor,task,deadline,done) VALUES('0001','tom','tom','Javaの本を読む','2025-05-24',FALSE);

DROP TABLE IF EXISTS completed_tasklists;

CREATE TABLE completed_tasklists (
  task_id VARCHAR(8) NOT NULL,
  client VARCHAR(50) NOT NULL,
  contractor VARCHAR(50) NOT NULL,
  task VARCHAR(256) NOT NULL,
  deadline VARCHAR(10) NOT NULL,
  completed_date TIMESTAMP,
  PRIMARY KEY(task_id)
);

INSERT INTO completed_tasklists(task_id,client,contractor,task,deadline,completed_date) VALUES('0002','tom','tom','Javaの本を読む','2025-05-24','2024-07-14 14:00:00');

DROP TABLE IF EXISTS record_tasklists;

CREATE TABLE record_tasklists (
  task_id VARCHAR(8) NOT NULL,
  client VARCHAR(50) NOT NULL,
  contractor VARCHAR(50) NOT NULL,
  task VARCHAR(256) NOT NULL,
  deadline VARCHAR(10) NOT NULL,
  completed_date TIMESTAMP,
  PRIMARY KEY(task_id)
);

INSERT INTO record_tasklists(task_id,client,contractor,task,deadline,completed_date) VALUES('0003','tom','tom','Javaの本を読む','2025-05-24','2024-07-14 14:00:00');

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(500) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY(user_id)
);

INSERT INTO users(username,password,email) VALUES('tom','$2a$10$AeZM5iFFA9kcsJhSxpw4c.4MYjVGoeGOzczXLdjLg/PKJY4/f5cnq','111@yahoo.co.jp');
INSERT INTO users(username,password,email) VALUES('bob','$2a$10$TrfOdI3cXSzuFAdWHYlGoOpMfQZHedq7urrc/8zuyWGyTpnoEjZ9.','123@yahoo.co.jp');
