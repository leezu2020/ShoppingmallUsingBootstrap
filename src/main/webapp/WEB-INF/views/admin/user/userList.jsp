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
				<th class="w200">가입 날짜</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userID}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td><fmt:formatDate value="${user.regDate}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	
	<div style="display: block; text-align: center;">		
		<c:if test="${page.startPage != 1 }">
			<a href="/admin/users?nowPage=${page.startPage - 1 }&cntPerPage=${page.cntPerPage}&condition=${page.condition}&keyword=${page.keyword}">이전</a>
		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="p">
			<c:choose>
				<c:when test="${p == page.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != page.nowPage }">
					<a href="/admin/users?nowPage=${p }&cntPerPage=${page.cntPerPage}&condition=${page.condition}&keyword=${page.keyword}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${page.endPage != page.lastPage}">
			<a href="/admin/users?nowPage=${page.endPage+1 }&cntPerPage=${page.cntPerPage}&condition=${page.condition}&keyword=${page.keyword}">다음</a>
		</c:if>
	</div>
</div>
<!-- 유저 검색 기능 -->
<form action="/admin/users" method="get">
	<div style="text-align: center;">
		<label for="condition" >검색조건</label>
		<select name="condition" id="condition">
			<option value="id" <c:if test="${condition eq 'id'}">selected</c:if>>아이디</option>
			<option value="name" <c:if test="${condition eq 'name'}">selected</c:if>>이름</option>
			<option value="idname" <c:if test="${condition eq 'idname'}">selected</c:if>>아이디+이름</option>
		</select>
		<input type="text" name="keyword" id="keyword" placeholder="검색어" value="${keyword }"/>
		<button type="submit">검색</button>
	</div>
</form>