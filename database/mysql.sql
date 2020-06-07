# 创建用户表
create table user(
    username varchar(11) primary key ,
    password varchar(18) not null ,
    nickname varchar(20),
    gender boolean,
    age int,
    shop_name varchar(32) not null ,
    record_name varchar(32) not null,
    balance double default 100.0,
    is_safe boolean default false
);
# 床建密保问题表
create table safe(
    username varchar(11) primary key ,
    question1 varchar(20),
    answer1 varchar(10),
    question2 varchar(20),
    answer2 varchar(10),
    question3 varchar(20),
    answer3 varchar(10)
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
    content blob,
    author varchar(10),
    view int default 0,
    constraint fk_comm_cate foreign key (category) references category(name)
);
insert into commodity(name, image_name, file_name, price, category, content, author) VALUES ('Java开发手册（泰山版）', '000001', 'Java开发手册（泰山版）', 22, 'java', 'alibaba出品的java开发手册', 'alibaba');
insert into commodity(name, image_name, file_name, price, category, content, author) VALUES ('Python基础入门到精通', 'Python基础入门到精通', 'Python基础入门到精通', 10, 'python', 'Python基础入门到精通,陈强编著', '陈强');

# 创建管理员表
create table admin(
    username varchar(11) primary key ,
    password varchar(18)
);

insert into admin values ('admin', '123456');

# 测试查询
select * from user;
select * from commodity
order by number desc ;
select * from safe;

show tables;
