create table membertbl(
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	gender nvarchar(2) not null,
	email varchar2(50) not null
	);
	
CREATE TABLE membertbl(
   userid VARCHAR2(15) PRIMARY KEY,
   password VARCHAR2(20) NOT NULL,
   name NVARCHAR2(10) NOT NULL,
   gender NVARCHAR2(2) NOT NULL,
   email VARCHAR2(50) NOT NULL
	);

insert into membertbl values('hong123', 'hong123@', '홍길동', '남', 'hong123@naver.com');
insert into membertbl values('bab123', '1123!', '콩밥', '남', 'bab123@google.com');


