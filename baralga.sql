
CREATE TABLE project (
  id           INTEGER,
  title        VARCHAR(255),
  description  VARCHAR(4000),
  active       TINYINT, 
  CONSTRAINT PK_project PRIMARY KEY (
    id
  )
);

CREATE TABLE activity (
  id           INTEGER,
  description  VARCHAR(4000),
  act_start    TIMESTAMP,
  act_end      TIMESTAMP,
  project_id   TINYINT,
  CONSTRAINT activity PRIMARY KEY (
    id
  )
);
