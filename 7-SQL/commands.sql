Create DATABASE if not exists school;

Drop database if exists deep_learning_results;

USE SCHOOL;

Drop database if exists school;

Create database if not exists school;

use school;

show tables; -- show the  table in the corresponding database;

/*data type in SQL:
---- Value
1. tinyint: really small value, one byte;
2. samllint: quite small value, two bytes;
3. mediumint: medium integer, three bytes;
4. int: standard integer, four bytes;
5. big: really larger integer, eight bytes;
6. float: floating number, four bytes;
7. double: floating number, eight bytes;
8. decimal: floating number represented by string, whcih is used in finance. 

---- String
1. char: fixed-length string: 0 ~ 255
2. varchar: changeable length string, 0 ~ 65535. This is used in string.
3. tinytext: can be used in blog, 2^8 - 1
4. text: a book, 2^16 - 1. This is used in text, normally.

---- Time and date
1. date, YYYYY-MM-DD
2. time, HH:mm:ss
3. datetime, YYYYY-MM-DD HH:mm:ss, normally used in the priject. 
4. timestamp, the milliseconds from 1970.1.1.
5. year, the year.

---- null
No thing in the record, do not use it cause you will gain null if you use it in mathematicla operations.

*/


/*
数据库字段属性

1. Unsigned:
	- unsigned int
    - cannot be negative number
2. zerofill:
	- fill with zero, E.g., if you use int(3), 5 == 005;
3. 自增
	主键可以设置 
4. 非空， Null, not null
5. 默认： 设置默认值 
*/

/*
每一个表都必须存在五个字段
id 主键
version 乐观锁
is_delete  伪删除
gmt_create 创建时间
mgt_update 更新时间 
*/

create database if not exists school;

use school;

create table if not exists `student`(
`id` int Not null Auto_increment COMMENT 'The ID of the record',
`name` varchar(30) Not null Default 'anonymity' comment 'Name',
`pwd` varchar(20) Not null Default '123456' comment 'Password',
`sex` varchar(10) Not null Default 'Female' comment 'Sex',
`birthday` Datetime default null comment 'Biorthday',
`address` varchar(100) Default null comment 'Family address',
`email` varchar(50) Default null comment 'Email',
Primary key (`id`)
)ENGINE=INNODB Default Charset=utf8;

show tables;

show create database school;

show create table student;

describe student;

/*
Engine:
1. INNODB, this is the default engine in SQL.
2. MYISAM: this is used in the several years before. 
*/

alter table student rename as student_1;

create table if not exists `student`(
	`id` int not null auto_increment comment 'The ID',
    primary key(`id`)
)Default charset=utf8mb4;

Alter table student add age int not null;

alter table student modify age varchar(10); -- modify is to change the constraint
describe table student;
alter table student Change age age1 int; -- change is used to change the name
desc student;

alter table student drop age1;
desc student;

Drop table if exists student;





