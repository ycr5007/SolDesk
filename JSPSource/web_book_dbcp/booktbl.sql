CREATE TABLE bookTBL(
   code NUMBER(4) primary key,
   title NVARCHAR2(50) not null, -- 가변 문자열 형식 : varchar2(한글 : 3Byte) / nvarchar2(글자 수 계산)
   writer NVARCHAR2(10) not null,
   price NUMBER(8)
);

insert into BOOKTBL values(1000, '이것이 자바다', '신용균', 28000);
insert into BOOKTBL values(1001, '자바의 신', '강신용', 29000);
insert into BOOKTBL values(1002, '자바의 정석', '남궁성', 27000);
insert into BOOKTBL values(1003, '자바 1000제', '김용만', 26000);