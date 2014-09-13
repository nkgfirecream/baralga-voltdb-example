
CREATE TABLE project (
  id           INTEGER,
  title        VARCHAR(255),
  description  VARCHAR(4000),
  active       INTEGER,
  CONSTRAINT PK_project PRIMARY KEY (
    id
  )
);

CREATE TABLE activity (
  id           INTEGER,
  description  VARCHAR(4000),
  act_start    TIMESTAMP,
  act_end      TIMESTAMP,
  project_id   INTEGER,
  CONSTRAINT activity PRIMARY KEY (
    id
  )
);

CREATE PROCEDURE lastXactivities AS
SELECT TOP ? * FROM ACTIVITY ORDER BY act_end ASC;
