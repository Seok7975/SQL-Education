CREATE TABLE DIPLOMAS
(COURSE VARCHAR(20) NOT NULL,
STUDENT VARCHAR(10) NOT NULL,
COU_NUM INT(2),
END_DATE DATE NOT NULL,
PRIMARY KEY (COURSE, STUDENT, END_DATE));


insert into diplomas values('�����α׷���','����',2,'2007/07/25');
insert into diplomas values('�����α׷���','����',3,'2007/07/25');