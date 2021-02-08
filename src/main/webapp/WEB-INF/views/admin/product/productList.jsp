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

<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">

</head>

<div class="notice margin-top">
	<h3 class="hidden">상품 목록</h3>
	<button type="button" onclick="location.href='/admin/regProduct'" style="float:right;">상품 등록</button>
	<table class="table">
		<thead>
			<tr>
				<th class="expand">상품명</th>
				<th class="w100">가격</th>
				<th class="w130">설명</th>
				<th class="w200">사이즈</th>
				<th class="w200">등록날짜</th>
				<th class="w200">좋아요 수</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="prod" items="${productList}">
				<tr>
					<td><a href="/admin/productDetail?id=${prod.productID}">${prod.name}</a></td>
					<td>${prod.price}</td>
					<td>${prod.description}</td>
					<td>${prod.size}</td>
					<td><fmt:formatDate value="${prod.regDate}" pattern="yyyy-MM-dd" /></td>
					<td>${prod.like}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<button type="button" class="selectDeleteBtn" style="float:right;">선택 삭제</button>
</div>