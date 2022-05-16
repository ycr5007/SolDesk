create table sp_user(
	userid varchar2(50),
	email varchar2(100) not null,
	enabled char(1) default '1',
	password varchar2(100) not null
);

alter table sp_user add constraint sp_user_pk primary key(userid);

create table sp_user_authority(
	userid varchar2(50) not null,
	authority varchar2(50) not null
);

alter table sp_user_authority add constraint sp_user_authority_fk foreign key(userid) references sp_user(userid);

insert into sp_user(userid, email, password) values('1', 'user@test.com', '1111');
insert into sp_user_authority(userid, authority) values('1', 'ROLE_USER');
insert into sp_user_authority(userid, authority) values('1', 'ROLE_ADMIN');

-- 권한 가져오기
select * from sp_user_authority where userid='1';

-- 내부조인 / 외부조인
	-- 내부조인 ( Inner Join ) :: 일차하는 Column 을 기준으로 값 가져오기
		select use.userid, email, password, enabled, authority from sp_user use join sp_user_authority auth on use.userid = auth.userid where use.userid = '1';  
	-- 외부조인 ( Outer Join ) 
		-- Left Outer Join
		-- Right Outer Join
		
		
select * from sp_user;


-- 로그인 기억하기 테이블 : 고정 ( Spring Security 정의 됨 )
create table persistent_logins(
	username varchar(64) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
);

select * from persistent_logins;


