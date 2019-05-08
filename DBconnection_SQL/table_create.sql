create table schoolclass(
schoolclass_id integer,
name varchar(30) not null,
create_at date not null,
update_at date not null,
primary key(schoolclass_id));

create table student(
student_id integer,
schoolclass_id integer not null references schoolclass(schoolclass_id),
name varchar (60) not null,
create_at date not null,
update_at date not null,
primary key(student_id));


create table course(
course_id varchar(60),
name varchar(150) not null,
create_at date not null,
update_at date not null,
primary key(course_id));

create table result(
result_id integer,
student_id integer references student(student_id),
course_id varchar(60) references course(course_id),
result integer not null,
create_at date not null,
update_at date not null,
primary key(result_id));

CREATE SEQUENCE schoolclass_id_seq
    INCREMENT BY 1
    START WITH 1
    NO CYCLE;

CREATE SEQUENCE student_id_seq
    INCREMENT BY 1
    START WITH 1
    NO CYCLE;

CREATE SEQUENCE result_id_seq
    INCREMENT BY 1
    START WITH 1
    NO CYCLE;

insert into schoolclass values(nextval('schoolclass_id_seq'),'A',current_timestamp,current_timestamp);
insert into schoolclass values(nextval('schoolclass_id_seq'),'B',current_timestamp,current_timestamp);
insert into schoolclass values(nextval('schoolclass_id_seq'),'C',current_timestamp,current_timestamp);

begin transaction;
insert into course values('eng','英語',current_timestamp,current_timestamp);
insert into course values('math','数学',current_timestamp,current_timestamp);
insert into course values('japanese','国語',current_timestamp,current_timestamp);
insert into course values('social','社会',current_timestamp,current_timestamp);
insert into course values('science','理科',current_timestamp,current_timestamp);
commit;

--select* from schoolclass;
--select* from course;

