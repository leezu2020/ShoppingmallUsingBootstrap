<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 상품 검색 기능 -->
<form action="/customer/productList" method="get">
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

<div class="container">

	<div class="row">
		<c:forEach var="n" items="${productList}">
		<!-- el 표기법(n.getID()) -->
		<div class="col-lg-4 col-md-6 mb-4">
			<div class="card h-100">
				<a href="/customer/productDetail?id=${n.productID}"><img class="card-img-top"
					src="${pageContext.request.contextPath}/resources/images/${n.imageUrl}"
					onerror="this.src='http://placehold.it/700x400'"
					alt="${n.name}"></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">${n.name}</a>
					</h4>
					<h5>${n.price} 원</h5>
					<p class="card-text">${n.description}</p>
				</div>
				<div class="card-footer">
				<!-- &#9733은 채워진별 &#9734는 빈별 -->
					<small class="text-muted">&#9733; &#9733; &#9733; &#9733;
						&#9734;</small>
				</div>
			</div>
		</div>
		</c:forEach>


	</div>
</div>
