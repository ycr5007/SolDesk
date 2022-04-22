package item.dto;

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
public class ItemDTO {
	private int num;
	private String category;
	private String name;
	private String content;
	private String psize;
	private int price;
	private Date register_at;
}


/*

	테이블 생성
create table item (
num number primary key,
category nvarchar2(30) not null,
name nvarchar2(50) not null,
content nvarchar2(100) not null,
psize varchar2(30) not null,
price number not null,
register_at date default sysdate
);

	시퀀스 생성
create sequence item_seq;

	데이터 삽입 테스트
insert into item(num, category, name, content, psize, price) values(item_seq.nextval, 'outwear', '바지', '파란색 바지 XL', 'XL', 38000);
insert into item(num, category, name, content, psize, price) values(item_seq.nextval, 'pants', '청바지', '연청색 바지 L', 'L', 12000);
*/
