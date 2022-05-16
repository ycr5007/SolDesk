package com.study.myapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.dto.ItemDTO;
import com.study.service.ItemService;

public class ItemApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		ItemService service = (ItemService)ctx.getBean("service");
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while(flag) {
			System.out.println("──────────────────────── M E N U ────────────────────────");
			System.out.println("1 ) 아이템 추가");
			System.out.println("2 ) 아이템 조회");
			System.out.println("3 ) 아이템 삭제");
			System.out.println("4 ) 아이템 수정");
			System.out.println("5 ) 아이템 전체 조회");
			System.out.println("0 ) 종료");
			System.out.println("─────────────────────────────────────────────────────────");
			int no = 0;
			try {
				no = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("메뉴 숫자를 입력해주세요 ...");
				no = 7;
			}
			switch(no) {
				case 1 :
					ItemDTO insertDto = new ItemDTO();
					System.out.print("상품 품목을 입력해주세요 >> ");
					insertDto.setCategory(sc.nextLine());
					System.out.print("상품 이름을 입력해주세요 >> ");
					insertDto.setName(sc.nextLine());
					System.out.print("상품 상세정보를 입력해주세요 >> ");
					insertDto.setContent(sc.nextLine());
					System.out.print("상품 사이즈를 입력해주세요 >> ");
					insertDto.setPsize(sc.nextLine());
					System.out.print("상품 가격을 입력해주세요 >> ");
					insertDto.setPrice(Integer.parseInt(sc.nextLine()));
					System.out.println(service.insert(insertDto) ? "Success Insert" : "Fail Insert");
					break;
				case 2 :
					System.out.print("조회할 번호를 입력해주세요 >> ");
					int select = Integer.parseInt(sc.nextLine());
					ItemDTO dto = service.getRow(select);
					if(dto != null) {
						System.out.println(dto);
					}else {
						System.out.println("존재하지 않는 상품번호입니다.");
					}
					break;
				case 3 :
					System.out.print("삭제할 상품의 번호를 입력해주세요 >> ");
					int deleteNum = Integer.parseInt(sc.nextLine());
					System.out.println(service.delete(deleteNum) ? "Success Delete" : "Fail Delete");
					break;
				case 4 :
					System.out.print("변경할 상품의 번호를 입력해주세요 >> ");
					int updateNum = Integer.parseInt(sc.nextLine());
					System.out.print("상품의 사이즈를 입력해주세요 >> ");
					String updatePsize = sc.nextLine();
					System.out.print("상품의 가격을 입력해주세요 >> ");
					int updatePrice = Integer.parseInt(sc.nextLine());
					System.out.println(service.update(updateNum, updatePsize, updatePrice) ? "Success Update" : "Fail Update");
					break;
				case 5 :
					List<ItemDTO> list = service.select();
					for(ItemDTO element : list) {
						System.out.println(element);
					}
					break;
				case 0 :
					System.out.println("프로그램을 종료합니다...");
					flag = false;
					break;
				default :
					System.out.println("잘못된 값을 입력하셨습니다.");
					break;
			}
		}
		
		sc.close();
	}
}
