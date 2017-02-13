create table student(
   id int,
   name VARCHAR(100) NOT NULL,
   sex varchar(4) NOT NULL ,
   address varchar(150),
   PRIMARY KEY ( id )
);

insert into student values (1,'沙云鹏','男','上海宝山');
insert into student(id,name,sex) values(2,'connie','女');