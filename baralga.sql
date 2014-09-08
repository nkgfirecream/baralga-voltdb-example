
CREATE TABLE project (
     id           INTEGER,
     title        VARCHAR(255),
     description  VARCHAR(4000),
     active       TINYINT
);

CREATE TABLE activity (
     id           INTEGER,
     description  VARCHAR(4000),
     act_start        TIMESTAMP,
     act_end          TIMESTAMP,
     project_id   TINYINT
);
