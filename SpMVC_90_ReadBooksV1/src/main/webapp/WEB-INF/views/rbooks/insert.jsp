<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>

	.form-group{
	
		border: 1px solid green;
		border-radius: 5px;
		margin: 0 auto;
		padding: 2rem;
	}

</style>
</head>
<body>

<header>
	<div class="jumbotron text-center">
		<h3>도서록 목록 추가</h3>
	</div>
</header>
<div class="form-group">
	<form:form modelAttribute="rbDTO" autocomplete="on" class="book-form">
	<input name="rb_seq" type="hidden" value="<c:out value="${rbDTO.rb_seq}" default="0"/>">
	
		<label for="rb_bcode">ISBN</label>
		<form:input path="rb_bcode" class="form-control" placeholder="도서코드를 입력하세요"/><br/>
		
		<label for="rb_bname">도서명</label>
		<form:input path="rb_bname" class="form-control" placeholder="도서명을 입력하세요"/><br/>
		
		<input name="rb_bname" type="hidden" value="<c:out value="${rbDTO.rb_bname}" />">
		
		<label for="rb_date">독서일자</label>
		<form:input path="rb_date" class="form-control" placeholder="독서일자를 입력하세요"/><br/>
		
		<label for="rb_stime">독서시작시간</label>
		<form:input path="rb_stime" class="form-control" placeholder="독서일자를 입력하세요"/><br/>
		
		<label for="rb_rtime">독서시간</label>
		<form:input type="number" path="rb_rtime" class="form-control" placeholder="독서일자를 입력하세요"/><br/>
		
		<label for="rb_subject">한줄소감</label>
		<form:input path="rb_subject" class="form-control" placeholder="한줄 감상평을 입력하세요"/><br/>
		
		<label for="rb_text">긴줄소감</label>
		<form:input path="rb_text" rows="5" class="form-control" placeholder="소감을 입력하세요"/><br/>
		
		<label for="rb_star">별점</label>
		<form:input type="number" path="rb_star" class="form-control" placeholder="별점을 입력하세요"/><br/>
	
		<button type="reset" class="btn btn-outline-warning btn-block">새로작성</button>
		<button type="submit" id="btn-save" class="btn btn-outline-primary btn-block">저장</button>
		
	</form:form>
</div>	
 <script>
 	
 $(function(){
	 
 })
 
 </script>

</body>
</html>