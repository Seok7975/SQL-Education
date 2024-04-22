#학과테이블
create table department(
dept_code int(2) Not null, #학과번호
dept_name char(30) Not null, #학과명
dept_ename varchar(50), #학과영문이름
Create_date date default null, #학과생성날짜
primary key (dept_code)
)engine = innoDB;

#우편번호테이블
create table post(
post_no varchar(7) Not null, #우편번호
post_dong char(30) Not null, #동이름
post_address char(60) Not null, #주소
ddd char(4), #DDD 전화지역번호
primary key (post_no)
)engine = innoDB;

#학적(학생신상)테이블
create table student(
stu_no char(10) Not null, #학번
stu_name char(10) Not null, #학생이름
stu_ename varchar(30), #영문이름
dept_code int(2) Not null, #학과코드
grade int(1) Not null, # 학년
class int (1) Not null, #반
juya char(2), #주야구분
id_num varchar(14) Not null, #주민등록번호
post_no varchar(7), #우편번호
address varchar(100), #주소
tel varchar(14), #전화번호
phone_no varchar(14), #휴대전화번호
birth_year char(4), #출생년도
primary key (stu_no),
constraint s_dp_fk foreign key(dept_code)  #외래키 학과 테이블의 학과코드
references department(dept_code),
constraint s_ps_fk foreign key(post_no)  #외래키 우편번호 테이블의 우편번호코드
references post(post_no)
) engine = innoDB;

#교과목테이블
create table subject(
sub_code char(5) Not null, #과목번호
sub_name varchar(50) Not null, #과목명
sub_ename varchar(50), #영문과목명
create_year char(4), #개설년도
primary key (sub_code)
)engine = innoDB;

#교수테이블
create table professor(
prof_code char(4) Not null, #교수번호
prof_name char(10) Not null, #교수명
prof_ename varchar(30), #교수영문이름
Create_date date default null, #교수임용날짜
primary key (prof_code)
)engine = innoDB;

#수강신청
create table attend(
stu_no char(10) Not null, #학번
att_year char(4) Not null, #수강년도
att_term int(1) Not null, # 수강학기
att_isu int(1) Not null, #이수구분
sub_code char(5) Not null, #과목코드
prof_code char(4) Not null, #교수번호
att_point int(1) Not null, #이수학점
att_grade int(3) default '0', #취득점수
att_div char(1) default 'N' Not null, #수강신청구분
att_jae char(1) default '1', #재수강 구분 1(본학기 수강), 2(재수강), 3(계절학기 수강) 
att_date date Not null, #수강처리일자
primary key (stu_no, att_year, att_term, sub_code, prof_code, att_jae),
constraint su_att_fk foreign key(sub_code) #외래키 교과목 테이블의 과목코드
references subject(sub_code),
constraint pr_att_fk foreign key(prof_code) #외래키 교수 테이블의 교수코드
references professor(prof_code)
) engine = innoDB;

#등록금테이블
create table fee(
stu_no varchar(10) Not null, #학번
fee_year varchar(4) Not null, #등록년도
fee_term int(1) Not null, #등록학기
fee_enter int(7), #입학금
fee_price int(7) Not null, #등록금(수업료)
fee_total int(7) Default '0' Not null, #등록금총액=입학금+수업료
jang_code char(2) Null, #장학코드
jang_total int(7), #장학금액
fee_pay int(7) Default '0' Not null, #납부총액=등록금총액-장학금액
fee_div char(1) Default 'N' Not null, #등록구분
fee_date date Not null, #등록날짜
primary key (stu_no, fee_year, fee_term)
) engine = innoDB;

#성적테이블
create table score(
stu_no char(10) Not null, #학번
sco_year char(4) Not null, #성적취득년도
sco_term int(1) Not null, #학기
req_point int(2), #신청학점
take_point int(2), #취득학점
exam_avg float(2,1), #평점평균
exam_total int(4), #백분율 총점
sco_div char(1), #성적구분
sco_date date, #성적처리일자
primary key (stu_no, sco_year, sco_term)
) engine = innoDB;

#동아리테이블
create table circle(
cir_num int(4) Not null auto_increment, #동아리가입번호
cir_name char(30) Not null, #동아리명
stu_no char(10) Not Null, #학번
stu_name char(10) Not Null, #이름
president char(1) default '2' Not null, #동아리회장(0), 부회장(1), 회원(2)
primary key (cir_num),
constraint s_ci_fk foreign key(stu_no) #외래키 학적 테이블의 학번
references student(stu_no)
)engine = innoDB;