<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<style>
	.click-line:hover{
		background-color: #eee;	
		transition: 0.3s;
		cursor: pointer;
	}
</style>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">List Board</h3>
		</div>
		<div class="row">
			<div class="col-md-4">
				<button type="button" class="btn btn-success">글쓰기</button>
			</div><!--글쓰기 버튼-->
			<div class="col-md-4 offset-md-4"><!--검색 들어갈 부분-->
				<form action="/list.do" method="get" id="search">
					<input type="hidden" name="page" value="${pageDto.searchDTO.page }"/>
					<input type="hidden" name="amount" value="${pageDto.searchDTO.amount }"/>
					<select name="criteria" id="criteria">
						<option value="n" <c:out value="${pageDto.searchDTO.criteria == null? 'selected': '' }"/>>---------</option>
						<option value="title" <c:out value="${pageDto.searchDTO.criteria == 'title'? 'selected': '' }"/>>title</option>
						<option value="content" <c:out value="${pageDto.searchDTO.criteria == 'content'? 'selected': '' }"/>>content</option>
						<option value="name" <c:out value="${pageDto.searchDTO.criteria == 'name'? 'selected': '' }"/>>name</option>
					</select>
					<input type="text" name="keyword" id="keyword" value="${pageDto.searchDTO.keyword }"/>
					<input type="button" value="검색" class="btn btn-primary" />
				</form>
			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<tr>
				<th class='text-center' style='width:100px'>번호</th>
				<th class='text-center'>제목</th>
				<th class='text-center'>작성자</th>
				<th class='text-center'>날짜</th>
				<th class='text-center' style='width:100px'>조회수</th>
			</tr>
			<%--
				EL : 영역 속성(request, session) 에 담은 값 찾아오기 ( name 값으로 찾아옴 )
								~.setAttribute("[name]", [value])		==>> 	${[name] }
					ex ) 	session.setAttribute("login", loginDto)		==>>	${loginDto }		
						 	request.setAttribute("list", list)			==>>	${list }
			 --%>
			 
			 <%--
			 	JSTL : JSP 에서 자바 코드를 줄이고자 ( 자바 코드의 Tag 화 )
			 		for 문 : <c:forEach> </c:forEach>
			 		if 문 : <c:if> </c:if>
			  --%>
			<c:if test="${empty list }">
				<tr class="data">
					<td align="center" colspan="6">
						<h3>작성된 게시글이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			<c:forEach var="dto" items='${list }'>
				<tr class="click-line" ><!-- 리스트 목록 보여주기 -->
					<td class='text-center'>${dto.bno }</td><!--번호-->
					<td>
						<c:if test="${dto.re_lev != 0 }">
							<%-- 
							<c:forEach begin="0" end="${dto.re_lev * 1 }">
								&nbsp;
							</c:forEach>
							--%>
							<span style="margin-left: ${dto.re_lev * 15 }px; display: inline-block;">└</span>
						</c:if>
						<a href="${dto.bno }" class="move">${dto.title }</a>
					</td><!--제목-->
					<td class='text-center'>${dto.name }</td><!--작성자-->
					<td class='text-center'>${dto.regdate }</td><!--날짜-->
					<td class='text-center'><span class="badge badge-pill badge-primary">${dto.readcount }</span></td>
				</tr>		
			</c:forEach>
		</table>
		<div class="container">
			<div class="row  justify-content-md-center">
				<nav aria-label="Page navigation example">
				  <ul class="pagination"><!--하단의 페이지 나누기 부분-->
					<c:if test="${pageDto.prev }">
						<li class="page-item"><a href="${pageDto.searchDTO.page - 10 }" class="page-link">이전</a></li>
					</c:if>
					<%-- active : 부트스트랩 내부 클래스, 활성화 시 선택 표시가 됨 --%>
					<c:forEach var="idx" begin="${pageDto.startPage }" end="${pageDto.endPage }">
						<li class="page-item ${pageDto.searchDTO.page == idx?'active':'' }"><a href="${idx }" class="page-link">${idx }</a></li>
					</c:forEach>
					<c:if test="${pageDto.next }">
						<li class="page-item"><a href="${pageDto.searchDTO.page + 10 }" class="page-link">다음</a></li>
					</c:if>
				  </ul>
				</nav>					
			</div>
		</div>
		<div style="height:20px"></div>
	</div>	
</section>
<%-- 페이지 나누기 정보 폼 : 사용자가 요청한 페이지번호 / 한 페이지 표현 게시물 개수 --%>
<form action="" id="actionForm">
	<%-- <input type="hidden" name="bno" value=""/> --%>
	<input type="hidden" name="page" value="${pageDto.searchDTO.page }"/>
	<input type="hidden" name="amount" value="${pageDto.searchDTO.amount }"/>
	<input type="hidden" name="criteria" value="${pageDto.searchDTO.criteria }"/>
	<input type="hidden" name="keyword" value="${pageDto.searchDTO.keyword }"/>
</form>
<script>
	let totalPage = ${pageDto.totalPage};
</script>
<script src="/js/list.js"></script>
<%@include file="../include/footer.jsp"%>
