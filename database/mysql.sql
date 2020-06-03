# 创建用户表
create table user(
    username varchar(11) primary key ,
    password varchar(18) not null ,
    nickname varchar(20),
    gender boolean,
    age int,
    shop_name varchar(32) not null ,
    record_name varchar(32) not null,
    balance double default 100.0
);
# 创建图书分类表
create table category(
    name varchar(10) primary key ,
    description varchar(20)
);

insert into category(name, description) values ('java', 'java相关书籍');
insert into category(name, description) values ('python', 'python相关书籍');
insert into category(name, description) values ('c', 'c相关书籍');
# 创建商品信息表
create table commodity(
    id int primary key auto_increment,
    name varchar(20) not null ,
    image_name varchar(32) not null ,
    file_name varchar(20) not null ,
    number int default 0,
    price double,
    category varchar(10),
    view int default 0,
    constraint fk_comm_cate foreign key (category) references category(name)
);
insert into commodity(name, image_name, file_name, price, category) VALUES ('Java开发手册（泰山版）', '000001', 'Java开发手册（泰山版）', 22, 'java');
insert into commodity(name, image_name, file_name, price, category) VALUES ('Python基础入门到精通', 'Python基础入门到精通', 'Python基础入门到精通', 10, 'python');

# 测试查询
select * from user;
select * from commodity;
select * from commodity where category = 'java';

show tables;
