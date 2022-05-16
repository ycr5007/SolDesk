package com.study.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.study.dto.AttachDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Slf4j
@Controller
public class UploadAjaxController {
	
	@GetMapping("/uploadAjax")
	public String uploadAjaxForm() {
		log.info("[GET] ajax 업로드 폼 요청");
		return "uploadform_ajax";
	}

	@PostMapping("/uploadAjax")
	public ResponseEntity<List<AttachDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("[POST] ajax 업로드 폼 요청");
		
		List<AttachDTO> attachList = new ArrayList<AttachDTO>();
		
		// 업로드 기본 폴더 지정
		String uploadBasicPath = "d:\\test";
		
		// 업로드 세부 폴더 지정
		String uploadFolderPath = getFolder();
		
		// 전체 업로드 경로 지정
		File uploadPath = new File(uploadBasicPath, uploadFolderPath);
		
		if(!uploadPath.exists()) { // 폴더가 없다면 폴더들 생성
			uploadPath.mkdirs();
		}
		
		// 업로드 파일명
		String uploadFileName = "";
		File save = null;
		for(MultipartFile f : uploadFile) {
			
			// 파일명 가져오기
			String oriFileName = f.getOriginalFilename();

			// 중복 파일명 해결하기
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + oriFileName;
			
			// 업로드 파일 객체 생성 ( JS 전달 목적 )
			AttachDTO attachDto = new AttachDTO();
			attachDto.setUploadPath(uploadFolderPath);
			attachDto.setFileName(oriFileName);
			attachDto.setUuid(uuid.toString());
			
			save = new File(uploadPath, uploadFileName);
			try {
				
				if(checkImageType(save)) {
					attachDto.setFileType(true);
					
					// 썸네일 저장
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					InputStream in  = f.getInputStream();
					Thumbnailator.createThumbnail(in, thumbnail, 80, 80);
					/*
						이미지 저장 시, 2번 저장 됨
							1 . 원본 크기의 파일
							2 . 80 x 80 사이즈의 파일
					*/
					in.close();
					thumbnail.close();
				}
				
				// 파일저장
				f.transferTo(save);

				attachList.add(attachDto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new ResponseEntity<List<AttachDTO>>(attachList, HttpStatus.OK);
		
		/*
			DB 저장
				Date : 폴더경로
				uuid
				OriginalFileName
				파일 확장자 여부
		*/
	}
	
	// 썸네일 이미지 보여주기
	@GetMapping(path = "/display")
	public ResponseEntity<byte[]> getFile(String fileName){
		log.info("[GET] 썸네일 파일 보여주기 " + fileName);
		File file = new File("d:\\test\\" + fileName);
		ResponseEntity<byte[]> image = null;
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-type", Files.probeContentType(file.toPath()));
			image = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	@GetMapping(path = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName){
		log.info("[GET] Request Download " + fileName);
		
		Resource resource = new FileSystemResource("d:\\test\\" + fileName);
		String resourceUidName = resource.getFilename();
		String resourceName = resourceUidName.substring(resourceUidName.indexOf("_") + 1);
		
		
//		String resourceName = resource.getFilename();
		
		// Spring 객체 >> headers 추가 
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("Content-Disposition", "attachment;filename=" + new String(resourceName.getBytes("utf-8"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	// 서버 파일 삭제
	@PostMapping(path = "/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("[POST] 파일 삭제 요청 " + fileName + "\t" + type);
		
		try {
			// URLDecoder.decode : Script 에서 Encode 되어 넘어온 URL 값을 Decode 해줌
			File file = new File("d:\\test\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete(); // Image 의 경우 썸네일 삭제, 일반 파일의 경우 원본 파일 삭제
			// 이미지의 경우 원본파일 삭제
			if(type.equals("image")) {
				// 원본파일 경로
				String largeName = file.getAbsolutePath().replace("s_", "");
				file = new File(largeName);
				file.delete();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	// 이미지 파일 여부 확인
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
			/*
				MIME Type 
					image/jpeg, image/gif, image/png ...
			*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	// 폴더 생성 메소드
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date(); // Wed Dec 08 16:40:05 KST 2022
		String str = sdf.format(date); // "2022-05-06"
		
		/*
			separator
				window : \
				unix : /
		*/
		return str.replace("-", File.separator); // "2022\05\06
	}
	

	
	
}
