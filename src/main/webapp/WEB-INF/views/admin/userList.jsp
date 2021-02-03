<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>유저 목록 조회</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">

</head>

<div class="notice margin-top">
	<h3 class="hidden">회원 목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th class="expand">선택</th>
				<th class="w60">아이디</th>
				<th class="expand">이름</th>
				<th class="w100">이메일</th>
				<th class="w130">이메일 인증 여부</th>
				<th class="w200">가입 날짜</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="user" items="${userList}">
				<tr>
					<td class="checkBox">
						<input type="checkBox" name="userBox" class="userBox" data-userID="${user.userID}" />
						<script>
							$(".userBox").click(function(){
								var confirm = confirm("정말 삭제하시겠습니까?");
								
							})
						</script>
					</td>
					<td>${user.userID}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td><c:choose>
							<c:when test="${user.emailChecked eq true}">이메일 인증 완료</c:when>
							<c:otherwise>이메일 미인증</c:otherwise>
						</c:choose></td>
					<td>${user.regDate}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<button type="button" class="selectDeleteBtn" style="float:right;">선택 삭제</button>
		<script>
			$(".selectDeleteBtn").click(function(){
				var confirm = confirm("정말 삭제하시겠습니까?");
				
			})
		</script>
</div>
