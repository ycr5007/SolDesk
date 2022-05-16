create table spring_board(
	bno number(10, 0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);

alter table spring_board add constraint pk_spring_board primary key(bno);

create sequence seq_board;

-- 댓글 수 컬럼 추가
alter table spring_board add (replycnt number default 0);

-- 기존 댓글 업데이트
update spring_board set replycnt = (select count(rno) from spring_reply where spring_board.bno = spring_reply.bno);

select * from SPRING_BOARD order by bno desc;

-- 더미 데이터
insert into SPRING_BOARD(bno, title, content, writer) (select seq_board.nextval, title, content, writer from spring_board);

select * from 
	(select rownum as rnum, A.* from 
		(select bno, title, writer, regdate, updatedate from SPRING_BOARD where bno > 0 order by bno desc) A
	where rownum <= 20) 
where rnum > 10;


-- 2) order by 컬럼이 인덱스라면 오라클 힌트 ( /*+INDEX_DESC([TableName] [PKName])*/ ) 이용 가능

select * from
	(select /*+INDEX_DESC(spring_board pk_spring_board)*/ rownum as rnum, bno, title, writer from spring_board where rownum <= 10)
where rnum > 0;



-- 댓글 처리

create table spring_reply(
	rno number(10, 0), -- 댓글 번호
	bno number(10, 0) not null, -- 원본글 번호
	reply varchar2(1000) not null, -- 댓글 내용
	replyer varchar2(50) not null, -- 댓글작성자
	replydate date default sysdate, -- 댓글 작성날짜
	updatedate date default sysdate -- 댓글 수정날짜
);

-- 댓글 시퀀스
create sequence seq_reply;

-- 댓글 테이블 기본키 지정
alter table spring_reply add constraint pk_reply primary key(rno);

-- 댓글 테이블 외래키 지정
alter table spring_reply add constraint fk_reply foreign key(bno) references spring_board(bno);

-- [bno / rno] 인덱스 생성
create index idx_reply on spring_reply(bno desc, rno asc);


-- 첨부파일 테이블 생성
create table spring_attach(
	uuid varchar2(100) not null,
	uploadpath varchar2(200) not null,
	filename varchar2(100) not null,
	filetype char(1) default '1',
	bno number(10, 0)
);

alter table spring_attach add constraint pk_attach primary key(uuid);
alter table spring_attach add constraint fk_board_attach foreign key(bno) references spring_board(bno);

