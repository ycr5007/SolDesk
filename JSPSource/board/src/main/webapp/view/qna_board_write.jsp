<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@include file="../include/header.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- Main content -->
<section class="content">
  <div class="box box-primary">
    <div class="box-header">
      <h3 class="box-title">Board Write</h3>
    </div>
    <div style="height:20px"></div>
    <form action="/write.do" method="post" role="form" id="writeForm" enctype="multipart/form-data" class="writeForm">
      <div class="box-body">
        <div class="form-group row">
          <label for="name" class="col-sm-2 col-form-label">작성자</label>
          <div class="col-sm-10">
            <input type="text" name="name" id="name" size="10" class="form-control" maxlength="10" />
          </div>
        </div>
        <div class="form-group row">
          <label for="title" class="col-sm-2 col-form-label">제목</label>
          <div class="col-sm-10">
            <input type="text" name="title" id="title" size="50" class="form-control" maxlength="100" />
          </div>
        </div>
        <div class="form-group row">
          <label for="content" class="col-sm-2 col-form-label">내용</label>
          <div class="col-sm-10">
            <textarea name="content" id="content" cols="60" class="form-control" rows="15" required></textarea>
          </div>
        </div>
        <div class="form-group row">
          <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
          <div class="col-sm-10">
            <input type="password" name="password" id="password" class="form-control" size="10" maxlength="10" />
          </div>
        </div>
        <div class="form-group row">
          <label for="file" class="col-sm-2 col-form-label">파일첨부</label>
          <div class="col-sm-10">
          <%-- accept 속성 : 사용자에게 파일선택 창에서 선택파일에 대한 가이드 역할 ( 단, 사용자의 확장자 선택으로 모든 파일 입력 가능 ) > 해결 : Script 활용하여 방지 --%>
            <input type="file" name="attach" id="file" />
            <small class="text-muted" id="file">(파일크기 : 2MB)</small>
            <%-- java.lang.IllegalArgumentException: 요청 타겟에서 유효하지 않은 문자가 발견되었습니다. 유효한 문자들은 RFC 7230과 RFC 3986에 정의되어 있습니다. 
            		server.xml Connector 수정 > relaxedQueryChars="[]()^|&quot;"
            --%>
          </div>
        </div>
        <div style="height:20px"></div>
        <div class="form-group text-center">
          <button type="submit" class="btn btn-primary">등록</button>
          <button type="reset" class="btn btn-danger">다시작성</button>
          <button type="button" class="btn btn-warning" id="list">목록보기</button>
        </div>
        <div style="height:20px"></div>
      </div>
      <input type="hidden" name="page" value="1" />
	  <input type="hidden" name="amount" value="<%=request.getParameter("amount") %>" />
	  <input type="hidden" name="criteria" value="" />
	  <input type="hidden" name="keyword" value="" />
    </form>
  </div>
  <!-- /.box -->
</section>

<form action="/list.do" id="actionForm">
	<input type="hidden" name="page" value="<%=request.getParameter("page") %>" />
	<input type="hidden" name="amount" value="<%=request.getParameter("amount") %>" />
	<input type="hidden" name="criteria" value="<%=request.getParameter("criteria") %>" />
	<input type="hidden" name="keyword" value="<%=request.getParameter("keyword") %>" />
</form>
<script src="/js/write.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/additional-methods.min.js"></script>
<script src="/js/write_validate.js"></script>
<%@include file="../include/footer.jsp"%>
