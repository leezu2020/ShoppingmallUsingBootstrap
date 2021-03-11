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
<!-- 상품 검색 기능 -->
<form action="/admin/products" method="get">
	<div style="text-align: center; padding-top: 20px; padding-bottom: 30px">
		<input type="text" name="keyword" id="keyword" style="text-align: center" placeholder="상품명" value="${keyword }"/>
		<label for="size" ><b>사이즈</b></label>
		<select name="size" id="size">
			<option value="all" <c:if test="${size eq 'all'}">selected</c:if>>all</option>
			<option value="s" <c:if test="${size eq 's'}">selected</c:if>>s</option>
			<option value="m" <c:if test="${size eq 'm'}">selected</c:if>>m</option>
			<option value="l" <c:if test="${size eq 'l'}">selected</c:if>>l</option>
			<option value="xl" <c:if test="${size eq 'xl'}">selected</c:if>>xl</option>
		</select>
		<b>가격 범위</b>
		<input type="number" min="1" max="2147483647" name="minprice"> <b>~</b>
		<input type="number" min="1" max="2147483647" name="maxprice"> 원
		
		<button type="submit">검색</button>
	</div>
</form>

<form action="/admin/product" method="post">
	<input type="hidden" name="_method" value="delete">
	<div class="notice margin-top">
		<h3 class="hidden">상품 목록</h3>
		<button type="button" onclick="location.href='/admin/reg-product'" style="float:right;">상품 등록</button>
		<table class="table">
			<thead>
				<tr>
					<th class="expand" style="text-align: center">선택</th>
					<th class="expand" style="text-align: center">상품명</th>
					<th class="w30" style="text-align: center">가격</th>
					<th class="w130" style="text-align: center">설명</th>
					<th class="w50" style="text-align: center">사이즈</th>
					<th class="w200" style="text-align: center">등록날짜</th>
					<th class="w50" style="text-align: center">상품평</th>
				</tr>
			</thead>
			<tbody>
	
				<c:forEach var="prod" items="${productList}">
					<tr>
						<td style="text-align: center" class="checkBox">
							<input type="checkBox" name="productChecked" value="${prod.productID}" />
						</td>
						<td style="text-align: center"><a href="/admin/product/${prod.productID}">${prod.name}</a></td>
						<td style="text-align: right; te"><fmt:formatNumber value="${prod.price}"/>원</td>
						<td style="text-align: center">${prod.description}</td>
						<td style="text-align: center">${prod.size}</td>
						<td style="text-align: center"><fmt:formatDate value="${prod.regDate}" pattern="yyyy-MM-dd" /></td>
						<td style="text-align: center">${prod.evalAvg}</td>
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
		
		<input type="submit" value="선택 삭제" style="float:right;"/>
	</div>
</form>