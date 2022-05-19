package com.study.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.board.dto.AttachDTO;
import com.study.board.dto.BoardDTO;
import com.study.board.dto.Criteria;
import com.study.board.dto.PageDTO;
import com.study.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board/*")
@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("[GET] list >> " + cri);
		List<BoardDTO> list = service.getList(cri);
		// 전체 게시물 개수
		int total = service.getTotalCnt(cri);
		
		model.addAttribute("pageDTO", new PageDTO(total, cri));
		model.addAttribute("list", list);
	}
	
	@PreAuthorize("isAuthenticated()") // Security 정의 메소드 : isAuthenticated() >> 로그인 정보의 유무
	@GetMapping("/register")
	public void register() {
		log.info("[GET] register");
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String register(BoardDTO register, Criteria cri, RedirectAttributes rttr) {
		log.info("[POST] register " + register);
		log.info("[POST] register " + cri);
		service.register(register);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("result", register.getBno());
		return "redirect:/board/list";
	}
	@GetMapping("/read")
	public void read(int bno, Criteria cri ,Model model) {
		log.info("[GET] read >> " + bno + "\t" + cri);
		BoardDTO readOne = service.getOne(bno);
		model.addAttribute("boardDTO", readOne);
	}
	
	@GetMapping("/modify")
	public void modify(int bno, Criteria cri ,Model model) {
		log.info("[GET] modify >> " + bno + "\t" + cri);
		BoardDTO modifyOne = service.getOne(bno);
		model.addAttribute("boardDTO", modifyOne);
	}
	
	@PreAuthorize("principal.username == #modify.writer")
	@PostMapping("/modify")
	public String modify(BoardDTO modify, Criteria cri, RedirectAttributes rttr) {
		log.info("[POST] modify");
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("bno", modify.getBno());
		if(service.modify(modify))
			return "redirect:/board/read";
		return "redirect:/board/modify";
	}
	
	@PreAuthorize("principal.username == #writer")
	@GetMapping("/remove")
	public String remove(int bno, String writer, Criteria cri ,RedirectAttributes rttr) {
		log.info("[GET] remove >> " + bno + "\t" + cri);
		
		// 서버 폴더에 저장한 첨부 파일 삭제 ( 서버 저장소 )
		// bno 에 해당하는 첨부파일 리스트 가져오기
		deleteFiles(service.attachList(bno));
		
		// 게시글, 첨부파일, 댓글 삭제 ( DB ) -- Cascade 처리 가능 (단, Transaction 등 세부 기능에 제한이 생길 수 있다)
		
		try {
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			if(service.remove(bno)) {
				rttr.addFlashAttribute("result", "success");
				return "redirect:/board/list";
			}
		} catch (Exception e) {
			rttr.addAttribute("bno", bno);
			return "redirect:/board/modify";
		}
		return "redirect:/board/modify";
	}
	
	// 첨부파일 가져오기
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachDTO>> getAttachList(int bno){
		log.info("[GET] 첨부파일 가져오기 " + bno);
		return new ResponseEntity<List<AttachDTO>>(service.attachList(bno), HttpStatus.OK);
	}
	
	
	// 게시글 삭제시 파일 삭제 ( 파일 여러개 삭제 가능 )
	public void deleteFiles(List<AttachDTO> attachList) {
		log.info("[Method]폴더 내 첨부파일 삭제");
		
		if(attachList == null || attachList.size() <= 0) {
			return;
		}
		for(AttachDTO attach : attachList) {
			Path path = Paths.get("d:\\test\\", attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());
			
			try {
				// 일반파일, 원본이미지 삭제
				Files.deleteIfExists(path);
				
				// Files.probeContentType(Path) : 확장자를 통해 MIME 타입 판단
					// text/plain
					// text/html
					// image/jpeg
					// image/png
					// audio/mpeg
					// audio/ogg
					// audio/*
					// video/mp4
					// application/octet-stream
				if(Files.probeContentType(path).startsWith("image")) {
					Path thumb = Paths.get("d:\\test\\", attach.getUploadPath() + "\\s_" + attach.getUuid() + "_" + attach.getFileName());
					// 이미지의 경우, Thumbnail 삭제
					Files.delete(thumb);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
