
insert into candidate(id, name, date_of_birth, contact_number, email)
values (nextval('candidate_seq') ,'Stefan Orcic', '1996-06-01', '065', 'orcic.stefan@gmail.com'),
(nextval('candidate_seq') ,'Stefan', '1996-06-01', '065', 'stefank@gmail.com'),
(nextval('candidate_seq') ,'Pera Peric', '1996-06-01', '065', 'pera@gmail.com'),
(nextval('candidate_seq') ,'Jovan Jovanovic', '1996-06-01', '065', 'jova@gmail.com');

insert into skill(id, name)
values 
(nextval('skill_seq') ,'C# programming'),
(nextval('skill_seq') ,'Java programming'),
(nextval('skill_seq') ,'Database design'),
(nextval('skill_seq') ,'English'),
(nextval('skill_seq') ,'Russian'),
(nextval('skill_seq') ,'German language ');

insert into candidate_skill(id, candidate, skill)
values 
(nextval('candidate_skill_seq'), 1,1),
(nextval('candidate_skill_seq'), 1,2),
(nextval('candidate_skill_seq'), 2,3),
(nextval('candidate_skill_seq'), 2,1),
(nextval('candidate_skill_seq'), 2,4),
(nextval('candidate_skill_seq'), 3,5),
(nextval('candidate_skill_seq'), 3,2),
(nextval('candidate_skill_seq'), 3,6),
(nextval('candidate_skill_seq'), 4,2),
(nextval('candidate_skill_seq'), 4,3);