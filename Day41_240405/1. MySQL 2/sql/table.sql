#�а����̺�
create table department(
dept_code int(2) Not null, #�а���ȣ
dept_name char(30) Not null, #�а���
dept_ename varchar(50), #�а������̸�
Create_date date default null, #�а�������¥
primary key (dept_code)
)engine = innoDB;

#�����ȣ���̺�
create table post(
post_no varchar(7) Not null, #�����ȣ
post_dong char(30) Not null, #���̸�
post_address char(60) Not null, #�ּ�
ddd char(4), #DDD ��ȭ������ȣ
primary key (post_no)
)engine = innoDB;

#����(�л��Ż�)���̺�
create table student(
stu_no char(10) Not null, #�й�
stu_name char(10) Not null, #�л��̸�
stu_ename varchar(30), #�����̸�
dept_code int(2) Not null, #�а��ڵ�
grade int(1) Not null, # �г�
class int (1) Not null, #��
juya char(2), #�־߱���
id_num varchar(14) Not null, #�ֹε�Ϲ�ȣ
post_no varchar(7), #�����ȣ
address varchar(100), #�ּ�
tel varchar(14), #��ȭ��ȣ
phone_no varchar(14), #�޴���ȭ��ȣ
birth_year char(4), #����⵵
primary key (stu_no),
constraint s_dp_fk foreign key(dept_code)  #�ܷ�Ű �а� ���̺��� �а��ڵ�
references department(dept_code),
constraint s_ps_fk foreign key(post_no)  #�ܷ�Ű �����ȣ ���̺��� �����ȣ�ڵ�
references post(post_no)
) engine = innoDB;

#���������̺�
create table subject(
sub_code char(5) Not null, #�����ȣ
sub_name varchar(50) Not null, #�����
sub_ename varchar(50), #���������
create_year char(4), #�����⵵
primary key (sub_code)
)engine = innoDB;

#�������̺�
create table professor(
prof_code char(4) Not null, #������ȣ
prof_name char(10) Not null, #������
prof_ename varchar(30), #���������̸�
Create_date date default null, #�����ӿ볯¥
primary key (prof_code)
)engine = innoDB;

#������û
create table attend(
stu_no char(10) Not null, #�й�
att_year char(4) Not null, #�����⵵
att_term int(1) Not null, # �����б�
att_isu int(1) Not null, #�̼�����
sub_code char(5) Not null, #�����ڵ�
prof_code char(4) Not null, #������ȣ
att_point int(1) Not null, #�̼�����
att_grade int(3) default '0', #�������
att_div char(1) default 'N' Not null, #������û����
att_jae char(1) default '1', #����� ���� 1(���б� ����), 2(�����), 3(�����б� ����) 
att_date date Not null, #����ó������
primary key (stu_no, att_year, att_term, sub_code, prof_code, att_jae),
constraint su_att_fk foreign key(sub_code) #�ܷ�Ű ������ ���̺��� �����ڵ�
references subject(sub_code),
constraint pr_att_fk foreign key(prof_code) #�ܷ�Ű ���� ���̺��� �����ڵ�
references professor(prof_code)
) engine = innoDB;

#��ϱ����̺�
create table fee(
stu_no varchar(10) Not null, #�й�
fee_year varchar(4) Not null, #��ϳ⵵
fee_term int(1) Not null, #����б�
fee_enter int(7), #���б�
fee_price int(7) Not null, #��ϱ�(������)
fee_total int(7) Default '0' Not null, #��ϱ��Ѿ�=���б�+������
jang_code char(2) Null, #�����ڵ�
jang_total int(7), #���бݾ�
fee_pay int(7) Default '0' Not null, #�����Ѿ�=��ϱ��Ѿ�-���бݾ�
fee_div char(1) Default 'N' Not null, #��ϱ���
fee_date date Not null, #��ϳ�¥
primary key (stu_no, fee_year, fee_term)
) engine = innoDB;

#�������̺�
create table score(
stu_no char(10) Not null, #�й�
sco_year char(4) Not null, #�������⵵
sco_term int(1) Not null, #�б�
req_point int(2), #��û����
take_point int(2), #�������
exam_avg float(2,1), #�������
exam_total int(4), #����� ����
sco_div char(1), #��������
sco_date date, #����ó������
primary key (stu_no, sco_year, sco_term)
) engine = innoDB;

#���Ƹ����̺�
create table circle(
cir_num int(4) Not null auto_increment, #���Ƹ����Թ�ȣ
cir_name char(30) Not null, #���Ƹ���
stu_no char(10) Not Null, #�й�
stu_name char(10) Not Null, #�̸�
president char(1) default '2' Not null, #���Ƹ�ȸ��(0), ��ȸ��(1), ȸ��(2)
primary key (cir_num),
constraint s_ci_fk foreign key(stu_no) #�ܷ�Ű ���� ���̺��� �й�
references student(stu_no)
)engine = innoDB;