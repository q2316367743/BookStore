create table user(
	username varchar(11) primary key,
	password varchar(18) noy null,
	nickname varchar(8),
	gender boolean,
	age int
);

create table commodity(
    id int primary key auto_increment,
    name varchar(20) not null ,
    image_name varchar(32) not null ,
    file_name varchar(20) not null ,
    number int default 0,
    price double
);
insert into commodity(name, image_name, file_name, number, price) VALUES ('Java开发手册（泰山版）', '000001', 'Java开发手册（泰山版）', 0, 22);
