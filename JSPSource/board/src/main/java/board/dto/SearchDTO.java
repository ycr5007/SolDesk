package board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchDTO {
	private String criteria;
	private String keyword;
	
// Page 나누기 추가
	// 현재 페이지 번호
	private int page;
	// 한 페이지당 보여줄 게시물 개수
	private int amount;
	
	public SearchDTO(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
}
