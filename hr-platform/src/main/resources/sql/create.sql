DROP TABLE IF EXISTS candidate CASCADE;
DROP TABLE IF EXISTS skill CASCADE;
DROP TABLE IF EXISTS candidate_skill CASCADE;

DROP SEQUENCE IF EXISTS candidate_seq CASCADE;
DROP SEQUENCE IF EXISTS skill_seq CASCADE;
DROP SEQUENCE IF EXISTS candidate_skill_seq CASCADE;

CREATE TABLE candidate (
    id integer NOT NULL,
    name varchar(50) NOT NULL,
    date_of_birth date,
    contact_number varchar(50),
    email varchar(50)
);

CREATE TABLE skill(
    id integer NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE candidate_skill (
    id integer NOT NULL,
    candidate integer NOT NULL,
    skill integer NOT NULL,
	unique(candidate, skill)
);

ALTER TABLE candidate ADD CONSTRAINT PK_Candidate 
	PRIMARY KEY(id);
ALTER TABLE skill ADD CONSTRAINT PK_Skill
	PRIMARY KEY(id);
ALTER TABLE candidate_skill ADD CONSTRAINT PK_Candidate_Skill 
	PRIMARY KEY(id);

ALTER TABLE candidate_skill ADD CONSTRAINT FK_Candidate_Skill_Candidate
	FOREIGN KEY (candidate) REFERENCES candidate (id);
ALTER TABLE candidate_skill ADD CONSTRAINT FK_Candidate_Skill_Skill
	FOREIGN KEY (skill) REFERENCES skill (id);

CREATE INDEX IDXFK_Candidate_Skill_Candidate
	ON candidate_skill (candidate);
CREATE INDEX IDXFK_Candidate_Skill_Skill
	ON candidate_skill (skill);

CREATE SEQUENCE candidate_seq 
INCREMENT 1;
CREATE SEQUENCE skill_seq 
INCREMENT 1;
CREATE SEQUENCE candidate_skill_seq 
INCREMENT 1;

