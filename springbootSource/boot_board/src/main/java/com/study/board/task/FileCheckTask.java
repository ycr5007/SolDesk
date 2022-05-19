package com.study.board.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.study.board.dto.AttachDTO;
import com.study.board.mapper.AttachMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileCheckTask {
	
	@Autowired
	private AttachMapper attachMapper;
	
	// 전날 일자 폴더 구하기
	private String getFolderYesterDate() {
		// 전날 날짜 추출
		LocalDate yesterday = LocalDate.now().minusDays(1);
		
		// 추출된 날짜의 format 변경
		String str = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		return str.replace("-", File.separator);
	}
	
	@Scheduled(cron="0 0 10 * * *")
	public void checkFiles() {
		log.info("[Schedule] <<<<< File Check Task Run >>>>>");
		// 전날 날짜의 첨부파일 리스트 가져오기 ( DB )
		List<AttachDTO> oldList = attachMapper.getOldFiles();
		List<Path> fileListPaths = oldList.stream()
				.map(dto -> Paths.get("d:\\test", dto.getUploadPath(), dto.getUuid() + "_" +  dto.getFileName()))
				.collect(Collectors.toList());
		
		oldList.stream()
			.filter(dto -> dto.isFileType() == true)
			.map(dto -> Paths.get("d:\\test", dto.getUploadPath(), "s_" + dto.getUuid() + "_" +  dto.getFileName()))
			.forEach(f -> fileListPaths.add(f));
		
		// 전날 일자 폴더의 파일 목록 추출 ( 저장소 )
		File targetDir = Paths.get("d:\\test", getFolderYesterDate()).toFile();
		File[] removeFiles = targetDir.listFiles(f -> fileListPaths.contains(f.toPath()) == false);
		
		// 비교 후 저장소의 파일 삭제
		for(File remove : removeFiles) {
			log.info("Remove File :: " + remove.getAbsolutePath());
			remove.delete();
		}
	}
}
