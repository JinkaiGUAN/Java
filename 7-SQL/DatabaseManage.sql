/*Databse manage
All the commands should be dictated.
*/

create table if not exists `grade`(
	`gradeID` int not null auto_increment comment 'grade id',
    `name` varchar(50) not null comment 'grade name',
    primary key(`gradeID`)
)engine=INNODB default charset=utf8mb4;

show tables;

drop table if exists student_1;

create table if not exists `student`(
`id` int Not null Auto_increment COMMENT 'The ID of the record',
`name` varchar(30) Not null Default 'anonymity' comment 'Name',
`pwd` varchar(20) Not null Default '123456' comment 'Password',
`sex` varchar(10) Not null Default 'Female' comment 'Sex',
`birthday` Datetime default null comment 'Biorthday',
`gradeID` int not null comment 'grade id',
`address` varchar(100) Default null comment 'Family address',
`email` varchar(50) Default null comment 'Email',
Primary key (`id`),
Key `FK_gradeID` (`gradeID`), -- define foreign key
constraint `FK_gradeID` foreign key (`gradeID`) references `grade` (`gradeID`) -- add constaint 
)ENGINE=INNODB Default Charset=utf8mb4;
-- If you wanna delete a table with foreign key related, you need to drop the table (i.e., students) that creates the foreign key, then drop the main table (i.e., grade).

desc student;

create table if not exists `student2`(
`id` int Not null Auto_increment COMMENT 'The ID of the record',
`name` varchar(30) Not null Default 'anonymity' comment 'Name',
`pwd` varchar(20) Not null Default '123456' comment 'Password',
`sex` varchar(10) Not null Default 'Female' comment 'Sex',
`birthday` Datetime default null comment 'Biorthday',
`gradeID` int not null comment 'grade id',
`address` varchar(100) Default null comment 'Family address',
`email` varchar(50) Default null comment 'Email',
Primary key (`id`)
)ENGINE=INNODB Default Charset=utf8mb4;

alter table `student2`
add constraint `FK_gradeID2` foreign key(`gradeID`) references `grade` (`gradeID`);

/*
以上增加物理外键不建议使用
*/

-- DML： Insert, update, delete
Insert into grade (`name`) values ('Fourth year');

Insert into grade (`name`) values ('third year');
desc grade;

Insert into grade(`name`)
values ('Second year'), ('first year');

create table if not exists `student3` (
`id` int Not null auto_increment comment 'ID',
`name` varchar(50) not null default 'anonymity' comment 'name',
`pwd` varchar(20) not null default '123456' comment 'pass word',
`sex` varchar(20) not null default 'female' comment 'sex',
`birthday` Datetime default null comment 'birthday',
`address` varchar(100) default null comment 'family address',
`email` varchar(50) default null comment 'email',
primary key(`id`)
)Engine=INNODB Default charset=utf8mb4;

insert into `student3` (`name`, `pwd`, `sex`) 
values ('John', '123456', 'male');

desc student3;
select * from student3;

insert into `student3` (`name`, `pwd`, `sex`)
values ('step', '12346', 'male'), 
('jognnk', '1234568', 'female');
select * from student3;

-- alter the information of the pre-inserted records
update `student3` SET `name`='kusngshen' where id = 1;
select * from student3;

use school;
show tables;
select * from student3;

delete from `student3` where id = 1; -- cannot delete all data completely
truncate table `student3`;  -- clear all data in this table
/*
Truncate 会重新设置自增列， 计数器会归零； 不会影响事务。

如果使用Delete
1. Engine = INNODB， 重启数据库， 自增列会从1开始， 因为储存在内存中， 数据没了就会重新开始。
2. ENgine == MyiSAM, 重启数据库， 会从上一个子增量开始， 因为他储存在文件中， 不会丢失。
*/

create table if not exists `student4`(
	`id` int not null auto_increment comment 'ID',
	`name` varchar(20) not null,
    primary key(`id`)
)Engine=INNODB Default Charset=utf8mb4;

insert into `student4` (`name`)
values ('John'), ('Ham'), ('Step');

select * from student4;

Delete from `student4`; -- would not be safe
select * from student4;
truncate table `student4`;




