
CREATE TABLE project (
  id           VARCHAR(36) UNIQUE NOT NULL,
  title        VARCHAR(255),
  description  VARCHAR(4000),
  active       INTEGER,
<<<<<<< HEAD
  PRIMARY KEY ( id )
=======
  CONSTRAINT PK_project PRIMARY KEY (
    id
  )
>>>>>>> 6e584ac83a8dae56de2a18636ccfcfedcc7277c7
);

CREATE TABLE activity (
  id           VARCHAR(36) UNIQUE NOT NULL,
  description  VARCHAR(4000),
  act_start    TIMESTAMP,
  act_end      TIMESTAMP,
<<<<<<< HEAD
  project_id   INTEGER NOT NULL,
  PRIMARY KEY ( id )
=======
  project_id   INTEGER,
  CONSTRAINT activity PRIMARY KEY (
    id
  )
>>>>>>> 6e584ac83a8dae56de2a18636ccfcfedcc7277c7
);

CREATE PROCEDURE lastXactivities AS
SELECT TOP ? * FROM ACTIVITY ORDER BY act_end ASC;
