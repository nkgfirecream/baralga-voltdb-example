
CREATE TABLE project (
  id           VARCHAR(36) UNIQUE NOT NULL,
  title        VARCHAR(255),
  description  VARCHAR(4000),
  active       INTEGER,
  PRIMARY KEY ( id )
);

CREATE TABLE activity (
  id           VARCHAR(36) UNIQUE NOT NULL,
  description  VARCHAR(4000),
  act_start    TIMESTAMP,
  act_end      TIMESTAMP,
  project_id   INTEGER NOT NULL,
  PRIMARY KEY ( id )
);

CREATE PROCEDURE lastXactivities AS
SELECT TOP ? * FROM ACTIVITY ORDER BY act_end ASC;

CREATE PROCEDURE FROM CLASS com.remast.baralga.LastXActivitiesJava;