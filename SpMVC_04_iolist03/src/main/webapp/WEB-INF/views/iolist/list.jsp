<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<link href="${rootPath}/css/list-table.css?ver=20191128001" rel="stylesheet" type="text/css">
<link href="${rootPath}/css/top-scroll.css?ver=20191128001" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<style type="text/css">
p#insert {
	margin: 20px;
}

article.body {
	/* 
		width == article.body box의 폭을 화면비율의 95%로 고정하고
		overflow == 내부의 contents가 넘치더라도 body box의 폭은 그대로 유지하면서
		scroll을 표시하여 볼 수 있도록 만들어라
	*/	
	width: 95%; 
	
	overflow: auto;
	margin: 10px auto; /* body 가운데 정렬 */
}

</style>

<script>
	$(function() {

		$(".content-body").click(function(e) {

			// id에 설정된 값을 가져오기
			let id = $(this).attr("data-id")
			let name = $(this).attr("data-name")
			alert(id + name)
			
			// alert(d_code))

			// 현재 페이지를 /dept/view를 전환하라
			// 주소창에 /dept/view를 입력하여 서버에 전송하라
			// id 변수에 값을 실어서 보내라
			document.location.href = "${rootPath}/iolist/view?id=" + id

		})
		
		// 현재 보고있는 화면의 scroll Top값을 추출하여 preScroll 변수에 임시 보관
		var preScroll = $(window).scrollTop();

		// select를 할 때 따옴표로 묶지 않은 것들은 객체 
		$(window).scroll(function(e) {
			let curScroll = $(window).scrollTop();
			// 아래 방향으로 스크롤을 시도하면
			if (preScroll > curScroll) {
				$("ul.main-menu").css("top", 0)
			} else {
				$("ul.main-menu").css("top", -80)
			}
			preScroll = curScroll
		})
	})
</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section class="dept">
		<article>
			<p id="insert">
				<a href="${rootPath}/iolist/insert"><button>새로등록</button></a>
			</p>
		</article>
		<article class="body">
			<table>
				<tr>
					<th>NO</th>
					<th>거래일자</th>
					<th>구분</th>
					<th>CD</th>
					<th>거래처명</th>
					<th>대표자명</th>
					<th>CD</th>
					<th>상품명</th>
					<th>매입단가</th>
					<th>매출단가</th>
					<th>부가세</th>
					<th>수량</th>
					<th>단가</th>
					<th>금액</th>
				</tr>
				<c:choose>
					<c:when test="${empty IOLIST}">
						<tr>
							<td colspan="5">데이터가 없음</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${IOLIST}" var="dto" varStatus="info">
						<%
							/*
								tag에 포함할 수 있는 속성은 기본적으로 id, class 만 있다.
								하지만 최근 HTML5의 최신버전에서는 사용자정의형속성을 만들 수 있다.
								data- 시작하는 값으로 만들 수 있다.
								data-id, data-name, data-num, data-addr ...
								
								이 사용자 정의형 속성은 JS나 JQ에서 참조할 수 있다.
								
								id- 로 사용하면 되고, -뒤는 변수명이라서 사용자가 알아서 정의하면 된다.
						
							*/
						%>
							<tr class="content-body" data-id="${dto.io_seq}" data-name="홍길동">
								<td>${dto.io_seq}</td>
								<td>${dto.io_date}</td>
								<td>${dto.io_inout}</td>
								<td>${dto.io_dcode}</td>
								<td>${dto.io_dname}</td>
								<td>${dto.io_dceo}</td>
								<td>${dto.io_pcode}</td>
								<td>${dto.io_pname}</td>
								<td>${dto.io_iprice}</td>
								<td>${dto.io_oprice}</td>
								<td>${dto.io_vat}</td>
								<td>${dto.io_qty}</td>
								<td>${dto.io_price}</td>
								<td>${dto.io_total}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</table>
		</article>
	</section>
</body>
</html>