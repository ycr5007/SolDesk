package com.study.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.dto.PageResultDTO;
import com.study.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTest {
	
	@Autowired
	private GuestbookService service;
	
//	@Test
//	public void testRegister() {
//		GuestbookDTO dto = GuestbookDTO.builder()
//									.title("지나갑니다 ...")
//									.content("지나갔습니다 ...")
//									.writer("스프링")
//									.build();
//		System.out.println(service.register(dto));
//	}
	
	@Test
	public void testGetList() {
		PageResultDTO<GuestbookDTO, Guestbook> result = service.getList(PageRequestDTO.builder().page(1).size(10).type("tc").keyword("지나").build());
		
		System.out.println("─────────────────────────────────────────────────────");
		
		System.out.println("prev : " + result.isPrev());
		System.out.println("next : " + result.isNext());
		System.out.println("total : " + result.getTotalPage());
		
		System.out.println("─────────────────────────────────────────────────────");
		
		result.getDtoList().forEach(guestbook -> {
			System.out.println(guestbook);
		});

		System.out.println("─────────────────────────────────────────────────────");
		
		result.getPageList().forEach(i -> System.out.println(i));
		
		System.out.println("─────────────────────────────────────────────────────");
	}
	
}
