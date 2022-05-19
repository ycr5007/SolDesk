package com.study.board.dto;

import lombok.Data;

@Data
public class AttachDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType; // image 1, other 0
	private int bno; // 원본 글 번호
}
