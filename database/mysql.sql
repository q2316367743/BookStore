# 创建用户表
create table user(
    username varchar(11) primary key ,
    password varchar(32) not null ,
    nickname varchar(20),
    gender boolean,
    age int,
    shop_name varchar(32) not null ,
    record_name varchar(32) not null,
    balance double default 100.0,
    is_safe boolean default false
);

# 创建密保问题表
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
    status boolean default true,
    constraint fk_com_cate foreign key (category) references category(name)
);

# 创建管理员表
create table admin(
    username varchar(11) primary key ,
    password varchar(18)
);

# 创建网站信息表
create table global(
    id int primary key auto_increment,
    notice blob,
    view int,
    online int,
    commodity_sell_num int,
    turnover int,
    user_num int,
    commodity_num int
);
