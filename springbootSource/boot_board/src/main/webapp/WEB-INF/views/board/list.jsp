<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board List</h1>
	</div> <!-- /.col-lg-12 -->
</div> <!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
			    Board List Page
			    <button id="regBtn" type="button" class="btn btn-xs pull-right">
			    	Register New Board
			    </button>
			</div> <!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번 호</th>
							<th>제 목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
				  	<!-- 게시판 리스트 반복문 (完) -->
					<tbody>
						<c:forEach var="dto" items="${list }">
							<tr>
								<td style="width: 70px;">${dto.bno }</td>
								<td style="text-align: left;"><a href="${dto.bno }" class="move">${dto.title } <strong>[${dto.replycnt }]</strong> </a></td>
								<td style="width: 150px;">${dto.writer }</td>
								<td style="width: 200px"><fmt:formatDate value="${dto.regdate }" pattern="yyyy-MM-dd HH:mm" /></td>
								<td style="width: 200px"><fmt:formatDate value="${dto.updatedate }" pattern="yyyy-MM-dd HH:mm" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row">
				<!-- start search -->
					<div class="col-md-12">
						<div class="col-md-8"><!--search Form-->
							<form action="" method="get" id="searchForm">
								<input type="hidden" name="pageNum" value="${criteria.pageNum }" />
								<input type="hidden" name="amount" value="${criteria.amount }" />
								<select name="type" class="form-control" style="size: 4; width: 20%;">
									<option value="" <c:out value="${criteria.type == '' ? 'selected' : '' }"/>>───────────</option>
									<option value="T" <c:out value="${criteria.type == 'T' ? 'selected' : '' }"/>>제목</option>
									<option value="C" <c:out value="${criteria.type == 'C' ? 'selected' : '' }"/>>내용</option>
									<option value="W" <c:out value="${criteria.type == 'W' ? 'selected' : '' }"/>>작성자</option>
									<option value="TC" <c:out value="${criteria.type == 'TC' ? 'selected' : '' }"/>>제목 / 내용</option>
									<option value="TW" <c:out value="${criteria.type == 'TW' ? 'selected' : '' }"/>>제목 / 작성자</option>
									<option value="TCW" <c:out value="${criteria.type == 'TCW' ? 'selected' : '' }"/>>모두</option>
								</select>
								<input type="text" name="keyword" class="form-control" style="width: 40%;" value="${criteria.keyword }"/>
								<button type="submit" class="btn btn-default">Search</button>
								<button type="reset" class="btn btn-danger">초기화</button>
							</form>
						</div>
						<div class="col-md-2 col-md-offset-2">
						<!--페이지 목록 갯수 지정하는 폼-->
						<select name="" id="amount" class="form-control">
							<option value="10" ${criteria.amount == "10" ? 'selected' : '' }>10</option>
							<option value="25" ${criteria.amount == "25" ? 'selected' : '' }>25</option>
							<option value="50" ${criteria.amount == "50" ? 'selected' : '' }>50</option>
							<option value="100" ${criteria.amount == "100" ? 'selected' : '' }>100</option>
						</select>
					    </div>
					</div>
				</div><!-- end search -->
				<div class="text-center">
				<!-- start Pagination -->
					<ul class="pagination">
						<c:if test="${pageDTO.prev }">
							<li class="paginate_button previous"><a href="${pageDTO.startPage - 1 }">Previous</a></li>
						</c:if>
						<c:forEach begin="${pageDTO.startPage }" end="${pageDTO.endPage }" var="idx">
							<li class="paginate_button ${pageDTO.cri.pageNum == idx ? 'active' : '' }"><a href="${idx }">${idx }</a></li>
						</c:forEach>
						<c:if test="${pageDTO.next }">
							<li class="paginate_button next"><a href="${pageDTO.endPage + 1 }">Next</a></li>
						</c:if>
					</ul>
				</div> <!-- end Pagination -->
			</div> <!-- end panel-body -->
		</div> <!-- end panel -->
	</div>
</div> <!-- /.row -->
<!-- 페이지링크 처리 form -->
<form action="/board/list" id="actionForm">
	<!-- 
		변수 값 가져오는 방법
			model.modelAttribute 를 통해 저장된 DTO 에서 값 가져오기 ( ex, pageDTO.cri.pageNum )
			(@ModelAttribute([default : criteria]) Controller 의 Criteria (도메인) 객체를 통해 값 가져오기 ( ex, criteria.pageNum )
	 -->
	<input type="hidden" name="pageNum" value="${criteria.pageNum }" />
	<input type="hidden" name="amount" value="${criteria.amount }" />
	<input type="hidden" name="type" value="${criteria.type }" />
	<input type="hidden" name="keyword" value="${criteria.keyword }" />
</form>
<!-- 모달 추가 -->
<div class="modal" tabindex="-1" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Register Board</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>처리가 완료되었습니다.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- 스크립트 -->
<script type="text/javascript">
	// 게시글 작성 성공 후 result 값 확인
	let result = '${result}';
</script>
<script src="/js/list.js"></script>
<%@include file="../includes/footer.jsp" %>
