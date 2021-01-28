<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">

</head>

<!-- 	검색기능 미구현
				<div class="breadcrumb">
				<h3 class="hidden">경로</h3>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</div>
			
			<div class="search-form margin-top first align-right">
				<h3 class="hidden">공지사항 검색폼</h3>
				<form class="table-form">
					<fieldset>
						<legend class="hidden">검색 필드</legend>
						<label class="hidden">검색분류</label>
						<select name="f">
							<option  value="title">아이디</option>
							<option  value="writerId">이름</option>
						</select> 
						<label class="hidden">검색어</label>
						<input type="text" name="q" value=""/>
						<input class="btn btn-search" type="submit" value="검색" />
					</fieldset>
				</form>
			</div> -->

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
					</td>
					<td>${user.userID}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td><c:choose>
							<c:when test="${user.emailChecked eq '1'.charAt(0)}">이메일 인증 완료</c:when>
							<c:otherwise>이메일 미인증 </c:otherwise>
						</c:choose></td>
					<td>${user.regDate}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
