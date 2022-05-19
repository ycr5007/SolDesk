package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.board.dto.Criteria;
import com.study.board.dto.ReplyDTO;
import com.study.board.dto.ReplyPageDTO;
import com.study.board.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/replies/*")
@Slf4j
@RestController
public class ReplyController {
	
	@Autowired
	private ReplyService service;

	
	
	// Insert /replies/new + POST + body(JSON DATA)
	
	// consumes : 받아서 처리할 Content 타입 지정
	// produces : 내보낼 데이터의 타입 지정
//	@PostMapping(path = "/new", produces = MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<String> insert(@RequestBody ReplyDTO insertDto){
//		log.info("[POST] Reply Insert >> " + insertDto);
//		return service.replyInsert(insertDto) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
//	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping(path="/new", produces=MediaType.TEXT_PLAIN_VALUE)
	   public ResponseEntity<String> create(@RequestBody ReplyDTO insertDTO) {
	      log.info("댓글 입력 요청");
	      return service.replyInsert(insertDTO) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	
	
	
	// 댓글하나 가져오기 - /replies/rno + GET
	// 성공시 ReplyDTO + 200
	@GetMapping(path = "/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReplyDTO> read(@PathVariable("rno") int rno){
		log.info("[GET] Read One >> " + rno);
		return new ResponseEntity<ReplyDTO>(service.read(rno), HttpStatus.OK);
	}
	
	// 댓글 수정 : /replies/rno + PUT + body(JSON DATA)
	// RequestMapping 으로 처리할 경우, @RequestMapping(path = "/{val}", method = RequestMethod.PUT)
	// RequestMapping 으로 처리할 경우, @RequestMapping(path = "/{val}", method = RequestMethod.PATCH)
	@PreAuthorize("principal.username == #updateDto.replyer")
	@PutMapping(path = "/{rno}")
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReplyDTO updateDto){
		log.info("[PUT] Update Reply >> " + rno + "\t" + updateDto);
		updateDto.setRno(rno);
		return service.replyUpdate(updateDto) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	// 댓글 삭제 : /replies/rno + DELETE
	@PreAuthorize("principal.username == #dto.replyer")
	@DeleteMapping(path = "/{rno}")
	public ResponseEntity<String> delete(@PathVariable("rno") int rno, @RequestBody ReplyDTO dto){
		log.info("[DELETE] Delete Reply >> " + rno);
		return service.replyDelete(rno) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}

	// 댓글 리스트 : /replies/pages/bno/page + GET
	@GetMapping("/pages/{bno}/{page}")
	public ResponseEntity<ReplyPageDTO> list(@PathVariable("bno") int bno, @PathVariable("page") int page){
		log.info("[GET] 댓글 리스트 요청 >> " + bno + "\t" + page);
		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<ReplyPageDTO>(service.getList(cri, bno), HttpStatus.OK);
	}
	
}
