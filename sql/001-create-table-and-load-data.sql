DROP TABLE IF EXISTS tasklists;

CREATE TABLE tasklists (
  id VARCHAR(8) NOT NULL,
  task VARCHAR(256) NOT NULL,
  deadline VARCHAR(10) NOT NULL,
  done BOOLEAN,
  PRIMARY KEY(id)
);

INSERT INTO tasklists(id,task,deadline,done) VALUES('0023','Javaの本を読む','2025-05-24',FALSE);

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(500) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users(username,password,email) VALUES('tom','$2a$10$AeZM5iFFA9kcsJhSxpw4c.4MYjVGoeGOzczXLdjLg/PKJY4/f5cnq','111@yahoo.co.jp');

