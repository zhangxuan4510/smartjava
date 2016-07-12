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

create TABLE t_payee(
userName VARCHAR(40) not null REFERENCES user.username,
account VARCHAR(20) not null,
name VARCHAR(30) not null,
address VARCHAR(80),
swiftCode VARCHAR (11),
bankName VARCHAR(80),
bankAddress VARCHAR(80),
PRIMARY key(userName,account)
);