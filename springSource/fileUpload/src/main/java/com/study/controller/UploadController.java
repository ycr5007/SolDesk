package com.study.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {
	
	@GetMapping("/uploadform")
	public void uploadForm() {
		log.info("[GET] Request upload Form");
	}

	// type = file 에 들어있는 값 가져오기 :: MultipartFile[] [inputTag Name] ( 파일을 여러개 받아오기로 했기 때문에 (multiple="multiple") 배열로 처리
	@PostMapping("/uploadform")
	public void uploadFormPost(MultipartFile[] uploadFile) {
		log.info("[POST] Request upload Form");
		/*
			MultipartFile :: Multipart request 요청(enctype="multipart/form-data")을 처리하기 위한 인터페이스
			
			transferTo(); >> 파일 저장
				>> File : 파일객체 (경로 + 파일명) 객체를 매개변수로 전달하여 Upload 한 파일 저장
				>> Path : ??
		*/
		
		// Upload 폴더 지정
		String uploadPath = "d:\\test";

		for(MultipartFile f : uploadFile) {
			log.info("파일명 : " + f.getOriginalFilename());
			log.info("파일크기 : " + f.getSize() / 1024 + " KB");

			
			try {
				File save = new File(uploadPath, f.getOriginalFilename());
				f.transferTo(save);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	/*
		MediaType.APPLICATION_OCTET_STREAM_VALUE : 보내는 데이터의 타입을 변경
	 */
//	@GetMapping(path = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	public ResponseEntity<Resource> downloadFile(String fileName){
//		log.info("[GET] Request Download " + fileName);
//		
//		Resource resource = new FileSystemResource("d:\\test\\" + fileName);
//		String resourceName = resource.getFilename();
//		
//		// Spring 객체 >> headers 추가 
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//			headers.add("Content-Disposition", "attachment;filename=" + new String(resourceName.getBytes("utf-8"), "ISO-8859-1"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}
}
