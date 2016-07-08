CREATE TABLE user(
custid VARCHAR(11) PRIMARY KEY ,
name VARCHAR(40) not NULL ,
username VARCHAR(40) not null,
userpwd VARCHAR(30) not null,
cardid VARCHAR(18) not null,
phone VARCHAR(11) not null,
email VARCHAR(30),
address VARCHAR(80),
registerdate date not null,
recentdate date not null
);