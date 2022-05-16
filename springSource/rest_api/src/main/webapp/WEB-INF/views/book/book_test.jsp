<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>도서정보</h3>
		<input type="text" name="in-code" id="in-code" />
		<button type="button" id="all" class="btn btn-secondary">전체 데이터</button>
		<button type="button" id="get" class="btn btn-primary">한개 데이터</button>
		<button type="button" id="delete" class="btn btn-danger">데이터 삭제</button>
		<button type="button" id="update" class="btn btn-success">데이터 수정</button>
		
		<div id="result">
			<table class="table">
				
			</table>
		</div>
		
		<div>
			<form method="post">
				<div>
					<label>Code</label>
					<input type="text" name="code" id="code" />
				</div>
				<div>
					<label>Title</label>
					<input type="text" name="title" id="title" />
				</div>
				<div>
					<label>Writer</label>
					<input type="text" name="writer" id="writer" />
				</div>
				<div>
					<label>Price</label>
					<input type="text" name="price" id="price" />
				</div>
				<div>
					<button type="button" id="insert">Send</button>
				</div>
			</form>
		</div>
		
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>

	/*
		ajax (Asynchronous Javascript and Xml) : 비동기 방식
			동기 : 웹 페이지 로딩을 하며, 페이지 전체가 이동
			비동기 : 웹 페이지 전체를 로딩하는 것이 아닌, 페이지의 일부분만 변경하기 위해 사용
			
		과거 >> 서버와 통신하기 위해 XMLHttpRequest(XHR) 객체 사용 
		최근 >> fetch API 를 이용, jQuery 를 통해 이용
	*/
	$(function(){
		$("#all").click(function(){
		// ajax 방식으로 데이터 처리
			/*  ajax 기본 방식
				$.ajax({
					url : '',
					method : '',
					data : {
						
					},
					dataType : 'json',
					success : function(){
						// 서버 상태코드 200 (정상) 일 때 
					}
				}) 
			*/
		// 가져올 데이터가 json 이라면
			$.getJSON({
				url : 'list',
				success : function(data){
					console.log(data);
					
					// 본문 table 영역 변경
					let result = $("#result table");
					let str = "";
					$.each(data, function(idx, item){
						str += "<tr>";
						str += "<td>" + item.code + "</td>";
						str += "<td>" + item.title + "</td>";
						str += "<td>" + item.writer + "</td>";
						str += "<td>" + item.price + "</td>";
						str += "</tr>";
					})
					result.html(str);
				}
			})
		})
		
		
		$("#get").click(function(){
			$.getJSON({
				url : '1000',
				success : function(data){
					console.log(data);
					
					// 본문 table 영역 변경
					let result = $("#result table");
					let str = "";
					str += "<tr>";
					str += "<td>" + data.code + "</td>";
					str += "<td>" + data.title + "</td>";
					str += "<td>" + data.writer + "</td>";
					str += "<td>" + data.price + "</td>";
					str += "</tr>";
					result.html(str);
				}
			})
		})
		
		
		$("#delete").click(function(){
			$.ajax({
				url : '100',
				type : 'delete', // Delete Mapping 호출
				success : function(data){
					alert(data);
				},
				error : function(xhr, status, error){
					alert(xhr.responseText);
				}
			})
		})
		
		$("#update").click(function(){
			
			// Javascript 객체
			let param = {price : 100000};
			
			$.ajax({
				url : '2006',
				type : 'put',
				data : JSON.stringify(param), // JSON.stringify(JS Obj) : JavaScript 객체를 JSON 형태로 변환
				contentType : 'application/json', // 미지정 시 : 'application/x-www-form-urlencoded;charset=utf-8' not supported
				success : function(data){
					alert(data);
				},
				error : function(xhr, status, error){
					alert(xhr.responseText);
				}
			})
		})
		
		$("#insert").click(function(){
			
			// Javascript 객체
			let param = {
				code : $("#code").val(),
				title : $("#title").val(),
				writer : $("#writer").val(),
				price : $("#price").val()
			};
			
			console.log(param);
			
			// JSON 형태 데이터 전달 ( JSON.stringify(param) )
			/* $.ajax({
				url : 'new',
				type : 'post',
				data : JSON.stringify(param),
				contentType : 'application/json',
				success : function(data){
					alert(data);
				},
				error : function(xhr, status, error){
					alert(xhr.responseText);
				}
			}) */
			
			
			// Form 형태 데이터 전달 ( $("form").serialize() )
			$.ajax({
				url : 'new2',
				type : 'post',
				data : $("form").serialize(),
				success : function(data){
					alert(data);
				},
				error : function(xhr, status, error){
					alert(xhr.responseText);
				}
			})
			
		})
		
	})
</script>
</body>
</html>