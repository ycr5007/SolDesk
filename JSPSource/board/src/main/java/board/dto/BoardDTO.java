package board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class BoardDTO {

	private int rownum;
	private int bno;			// 글번호 ( sequence )
	private String name;		// 작성자
	private String password;	// 비밀번호
	private String title;		// 제목
	private String content;		// 내용
	private String attach;		// 파일첨부
	private int re_ref;			// 답변글 작성시 참조되는 글 번호
	private int re_lev;			// 답변글 레벨
	private int re_seq;			// 답변글 순서
	private int readcount;		// 조회수 ( default : 0 )
	private Date regdate;		// 작성날짜 ( default : sysdate )
	
}

/*
	invalid identifier : 오라클 내 예약어가 있을 경우 ( size ...
		> "size" 를 붙여 사용 가능 ( ex : "size" varchar2(10) )
		
create table board(
bno number(8), 
name nvarchar2(20) not null,
password varchar2(15) not null,
title nvarchar2(50) not null,
content nvarchar2(1000) not null,
attach nvarchar2(100),
re_ref number(8) not null,
re_lev number(8) not null,
re_seq number(8) not null,
readcount number(8) default 0,
regdate date default sysdate
);
	
	
alter table board add constraint pk_board primary key(bno);

create sequence board_seq;
	
	
insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) values(board_seq.nextval, 'admin', '1234', 'jsp/servlet BBS', 'Make ours BBS', null, board_seq.currval, 0, 0);

*/