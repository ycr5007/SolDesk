package com.study.guestbook.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.dto.PageResultDTO;
import com.study.guestbook.entity.Guestbook;
import com.study.guestbook.entity.QGuestbook;
import com.study.guestbook.repository.GuestbookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GuestbookServiceImpl implements GuestbookService{
	
	@Autowired
	private GuestbookRepository repository;
	
	@Override
	public Long register(GuestbookDTO insertDto) {
		log.info("<<<<< Register >>>>>");
		log.info("[DTO] : " + insertDto);
		
		Guestbook entity = dtoToEntity(insertDto);
		log.info("[Entity] : " + entity);
		
		repository.save(entity);
		
		return entity.getGno();
	}
	
	@Override
	public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDto) {
		
		// Sort 기준
		Pageable pageable = requestDto.getPageable(Sort.by("gno").descending());
		
		BooleanBuilder booleanBuilder = getSearch(requestDto);
		
		Page<Guestbook> result = repository.findAll(booleanBuilder, pageable);
		
		Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
		
		return new PageResultDTO<GuestbookDTO, Guestbook>(result, fn); 
	}
	
	@Override
	public GuestbookDTO getOne(Long gno) {
		
		Optional<Guestbook> result = repository.findById(gno);
		// 서버 ( Entity ) / 화면 ( DTO )
		return result.isPresent() ? entityToDto(result.get()) : null ;
	}
	
	@Override
	public void remove(Long gno) {
		repository.deleteById(gno);
	}
	
	@Override
	public Long modify(GuestbookDTO updateDto) {
		log.info("<<<<< Modify >>>>>");
		log.info("[DTO] : " + updateDto);
		
		Optional<Guestbook> result = repository.findById(updateDto.getGno());
			Guestbook entity = null;
		if(result.isPresent()) {
			entity = result.get();
			entity.setTitle(updateDto.getTitle());
			entity.setContent(updateDto.getContent());
			
			repository.save(entity);
		}
		
		return entity.getGno();
	}
	
	
	private BooleanBuilder getSearch(PageRequestDTO requestDto) {
		// 검색조건 가져오기
		String type = requestDto.getType();
		String keyword = requestDto.getKeyword();
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QGuestbook qGuestbook = QGuestbook.guestbook;
		
		BooleanExpression expression = qGuestbook.gno.gt(0L);
		booleanBuilder.and(expression);
		
		if(type == null || type.trim().length() == 0) {
			return booleanBuilder;
		}
		
		BooleanBuilder conditionBuilder = new BooleanBuilder();
		
		if(type.contains("t")) {
			conditionBuilder.or(qGuestbook.title.contains(keyword));
		}
		if(type.contains("c")) {
			conditionBuilder.or(qGuestbook.content.contains(keyword));
		}
		if(type.contains("w")) {
			conditionBuilder.or(qGuestbook.writer.contains(keyword));
		}
		
		booleanBuilder.and(conditionBuilder);
		
		return booleanBuilder;
	}
	
}

/*
	함수형 인터페이스 ( Lambda )
		=> 추상메소드가 하나만 존재 ( default, static 상관 X )
		
		
	java.util.Function 패키지 안에 자주 사용하는 형식의 추상 메소드를 함수형 인터페이스로 정의해 놓음
	
	Function<T, R> : T ( 매개변수 Type ) · R ( 반환 Type )
	
	ex ) Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
		Guestbook : 매개변수 타입
		GuestbookDTO : 반환 타입
*/
