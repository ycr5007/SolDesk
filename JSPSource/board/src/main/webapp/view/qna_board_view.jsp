<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Read Board</h3>
		</div>
		<div style="height:20px"></div>
		<form action="" method="post" role="form">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10">
						<input type="text" name="name" size="10" class="form-control" maxlength='10' value='${viewDto.name }' readonly>
					</div>
				</div>
				<div class="form-group  row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"	maxlength='100' value='${viewDto.title }' readonly>
					</div>
				</div>
				<div class="form-group  row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='content' cols='60' class="form-control" rows='15' style="resize: none;" readonly>${viewDto.content }</textarea>
					</div>
				</div>
				<div class="form-group  row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
						<c:if test="${empty viewDto.attach }">
							<input type="file" name="attach" />
						</c:if>
						<c:if test="${!empty viewDto.attach }">
						<a href="/download.do?fileName=${viewDto.attach }">${viewDto.attach }</a>
						</c:if>
					</div>
				</div>
				<div style="height:10px"></div>
				<div class="box-footer text-center">
					<button type="button" class="btn btn-success" id="reply">답변</button>
					<button type="button" class="btn btn-warning" id="modify">수정</button>
					<button type="button" class="btn btn-danger" id="delete">삭제</button>
					<button type="button" class="btn btn-primary" id="list">목록보기</button>
				</div>
				<div style="height:20px"></div>
			</div>
		</form>
	</div>
</section>

<%-- JSP 간 값 주고받는 방법 ② : a 태그에 QueryString 을 활용해 전송 > ?attr=?&attr=?... !!) 단, 큰 용량은 전송이 불가 --%>
<%-- JSP 간 값 주고받는 방법 ① : Form 태그에 값을 넣어 Script를 통해 Submit --%>
<form action="" method="get" id="actionForm">
	<input type="hidden" name="bno" value='${viewDto.bno }' />
	
	<%-- 페이지 나누기 후 추가 --%>
	<input type="hidden" name="page" value="${searchDto.page }"/>
	<input type="hidden" name="amount" value="${searchDto.amount }"/>
	<input type="hidden" name="criteria" value="${searchDto.criteria }"/>
	<input type="hidden" name="keyword" value="${searchDto.keyword }"/>
</form>

<script src="/js/view.js"></script>
<%@include file="../include/footer.jsp"%>
