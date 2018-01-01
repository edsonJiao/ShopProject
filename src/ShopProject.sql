Create database ShopProject;
use ShopProject;
CREATE TABLE IF NOT EXISTS goods(
	id INT AUTO_INCREMENT PRIMARY KEY,
    goodName varchar(15) NOT NULL,
    account INT NOT NULL DEFAULT 0,
    price DOUBLE NOT NULL DEFAULT 0,
    picture MEDIUMBLOB
);
create table if not exists root(
	id int auto_increment primary key,
    admin varchar(10) not null,
    password varchar(10) not null
);
CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  admin varchar(15) NOT NULL,
  password varchar(15) NOT NULL DEFAULT '123456',
  username varchar(15) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY admin (admin)
);
insert into root(admin,password) values('admin12','123456');
alter table users modify admin varchar(15) Not null unique;

