package board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PageDTO {
	// 화면에 보여줄 첫번째 페이지 번호
	private int startPage;
	// 화면에 보여줄 마지막 페이지 번호
	private int endPage;
	// 이전 부분을 보여줄 것인지 여부
	private boolean prev;
	// 다음 부분을 보여줄 것인지 여부
	private boolean next;
	
	// 전체 페이지 수
	private int totalPage;
	
	// 전체 게시물 수
	private int total;
	
	// 검색어, 검색기준, 현재페이지번호, 게시물 개수
	private SearchDTO searchDTO;
	
	public PageDTO(int totalRows, SearchDTO dto) {
		this.total = totalRows;
		this.searchDTO = dto;

		// 현재 화면의 마지막 페이지 수
		endPage = (int)(Math.ceil(dto.getPage() / 10.0)) * 10;

		// 현재 화면의 시작 페이지 수
		startPage = endPage - 9;
		
		// 끝나는 페이지 다시 계산 ( 페이지의 개수가 게시물의 개수를 초과하지 않도록 처리 )
		int realEnd = (int)(Math.ceil((totalRows / 1.0) / dto.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		// prev / next 버튼 활성화
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		// 10 단위로 움직이기 때문에, 없는 페이지가 요청되는 경우 ( JavaScript 작업 )
			// endPage / startPage : amount 단위로 움직이는 단위
			// realEnd : 글의 개수에 맞춰 마지막 페이지 값을 지정해주는 변수
		
		totalPage = realEnd;
	}
}
