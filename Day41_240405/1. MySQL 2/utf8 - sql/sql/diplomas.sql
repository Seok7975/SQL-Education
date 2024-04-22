CREATE TABLE DIPLOMAS
(COURSE VARCHAR(20) NOT NULL,
STUDENT VARCHAR(10) NOT NULL,
COU_NUM INT(2),
END_DATE DATE NOT NULL,
PRIMARY KEY (COURSE, STUDENT, END_DATE));


insert into diplomas values('웹프로그래밍','공자',2,'2007/07/25');
insert into diplomas values('웹프로그래밍','맹자',3,'2007/07/25');