drop table customer;
create table customer(
	customer_id varchar2(10) primary key,
	customer_password varchar2(10) not null,
	customer_name varchar2(50) not null,
	customer_email varchar2(50) not null,
	customer_mileage number(7) default 10000 --default는 not null보다 먼저 선언
);

insert into customer values ('id-1','1111','유재석', 'ryujs@abc.com',1000);
insert into customer (customer_id,customer_password,customer_name,customer_email)
values ('id-2', '2222','정형돈', 'parkyh@ab.com');
insert into customer values ('id-3','3333','정준하', 'jungjh@abc.com',1000);
insert into customer values ('id-4','4444','박명수', 'parkms@abc.com',1000);
insert into customer values ('id-5','5555','하하', 'haha@abc.com',1000);
insert into customer values ('id-6','7777','광희', 'kwang@abc.com',1000);

-------------------------------------------------------------------------위는 예시 

drop table customer CASCADE CONSTRAINTS;
create table customer
(
	customer_id varchar2(20) primary key,
	customer_password varchar2(20) not null,
	customer_name varchar2(20) not null,
	customer_image varchar2(200),
	customer_mileage number(10) default 0,
	customer_type varchar2(10)
);

drop table restaurant CASCADE CONSTRAINTS;
create table restaurant
(   
	restaurant_id number(5) primary key,
	restaurant_name varchar2(60) not null,
	restaurant_description varchar2(200), 
	restaurant_phone varchar2(20) not null,
	restaurant_address varchar2(200) not null,
	restaurant_latitude number,
	restaurant_longitude number,
	restaurant_image varchar2(200),
	restaurant_rating number,
	restaurant_rating_count number(10) default 0,
	restaurant_mileage_percent number(3) default 0,
	owner_id varchar2(20),
	constraint restaurant_owner_fk foreign key(owner_id) references customer(customer_id)
);

drop table item CASCADE CONSTRAINTS;
create table item
(
	item_id number(5) primary key,
	item_name varchar2(60) not null,
	item_description varchar2(200),
	item_price number(10) not null,
	item_sort varchar2(10) not null,
	item_image varchar2(200),
	item_rating number,
	item_rating_count number(10) default 0,
	restaurant_id number(5),
	constraint item_restaurant_fk foreign key(restaurant_id) references restaurant(restaurant_id)
);

drop table review CASCADE CONSTRAINTS;
create table review
(
	review_id number(5) primary key,
	review_description varchar2(200) not null,
	review_create_date date not null,
	review_type varchar2(10) not null,
	item_id number(5),
	customer_id varchar2(20),
	constraint review_item_fk foreign key(item_id) references item(item_id),
	constraint review_customer_fk foreign key(customer_id) references customer(customer_id)
)

drop table receipt CASCADE CONSTRAINTS;
create table receipt
(
	receipt_id number(5) primary key,
	receipt_date date not null,
	receipt_table number(3) not null,
	receipt_state varchar2(20) not null,
	customer_id varchar2(20),
	restaurant_id number(5),
	constraint receipt_customer_fk foreign key(customer_id) references customer(customer_id),
	constraint receipt_restaurant_fk foreign key(restaurant_id) references restaurant(restaurant_id)
)

drop table order_list cascade constraints;
create table order_list
(
	order_list_id number(5) primary key,
	item_count number(3) not null,
	item_price number(10),
	item_id number(5),
	receipt_id number(5),
	constraint order_list_item_fk foreign key(item_id) references item(item_id),
	constraint order_list_receipt_fk foreign key(receipt_id) references receipt(receipt_id)
)



<!-- 자동으로 증가하게 해주는 sequence 등록-->

drop sequence seq_restaurant;
create sequence seq_restaurant nocache nocycle;

drop sequence seq_item;
create sequence seq_item nocache nocycle;

drop sequence seq_receipt;
create sequence seq_receipt nocache nocycle;

drop sequence seq_order_list;
create sequence seq_order_list nocache nocycle;

drop sequence seq_review;
create sequence seq_review nocache nocycle;


insert into customer values ('bobos','111','bobos','',10,'admin');
insert into customer values ('b','b','b','',10,'owner');
drop table book;
drop table department CASCADE CONSTRAINTS;
drop table employee;
drop table person;
drop table search;
drop table publisher cascade constranints;
