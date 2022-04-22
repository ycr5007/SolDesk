package board.action;

public class BoardActionFactory {
	private static BoardActionFactory af;
	
	private BoardActionFactory() {}
	
	public static BoardActionFactory getInstance() {
		if(af == null) {
			af = new BoardActionFactory();
		}
		return af;
	}
	
	Action action = null;
	
	public Action action(String cmd) {
		switch(cmd) {
			case "/write.do" :
				action = new BoardWriteAction("/list.do");
				break;
			case "/list.do" :
				action = new BoardListAction("/view/qna_board_list.jsp");
				break;
			case "/view.do" :
				action = new BoardViewAction("/view/qna_board_view.jsp");
				break;
			case "/hitUpdate.do" :
				action = new BoardHitUpadeAction("/view.do");
				break;
			case "/delete.do" :
				action = new BoardDeleteAction("/list.do");
				break;
			case "/modify.do" :
				action = new BoardViewAction("/view/qna_board_modify.jsp");
				break;
			case "/update.do" :
				action = new BoardUpdateAction("/view.do");
				break;
			case "/download.do" :
				action = new BoardDownloadAction();
				break;
			case "/replyView.do" :
				// 원본글의 re_ref, 원본글의 re_seq, 원본글의 re_lev 값 필요
				action = new BoardViewAction("/view/qna_board_reply.jsp");
				break;
			case "/reply.do" :
				action = new BoardReplyAction("/list.do");
				break;
//			case "/search.do" :
//				action = new BoardSearchAction("/view/qna_board_list.jsp");
//				break;
			default:
				action = null;
				break;
		}
		
		return action;
	}
}
