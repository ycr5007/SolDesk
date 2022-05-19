package com.study.guestbook.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GuestbookDTO {
	private Long gno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regdate;
	private LocalDateTime updatedate;
}
