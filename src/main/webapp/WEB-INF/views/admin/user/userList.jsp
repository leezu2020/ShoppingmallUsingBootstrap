<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<td>${user.userID}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td><c:choose>
							<c:when test="${user.emailChecked eq true}">이메일 인증 완료</c:when>
							<c:otherwise>이메일 미인증</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate value="${user.regDate}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	
	<div style="display: block; text-align: center;">		
		<c:if test="${page.startPage != 1 }">
			<a href="/admin/userList?nowPage=${page.startPage - 1 }&cntPerPage=${page.cntPerPage}">이전</a>
		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="p">
			<c:choose>
				<c:when test="${p == page.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != page.nowPage }">
					<a href="/admin/userList?nowPage=${p }&cntPerPage=${page.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${page.endPage != page.lastPage}">
			<a href="/admin/userList?nowPage=${page.endPage+1 }&cntPerPage=${page.cntPerPage}">다음</a>
		</c:if>
	</div>
</div>
