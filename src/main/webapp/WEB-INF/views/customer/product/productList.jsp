<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 상품 검색 기능 -->
<form action="/customer/productList" method="get">
	<div style="text-align: center; padding-top: 20px; padding-bottom: 30px">
		<input type="text" name="keyword" id="keyword" style="text-align: center" placeholder="상품명" value="${keyword}"/>
		<label for="size" ><b>사이즈</b></label>
		<select name="size" id="size">
			<option value="all" <c:if test="${size eq 'all'}">selected</c:if>>all</option>
			<option value="s" <c:if test="${size eq 's'}">selected</c:if>>s</option>
			<option value="m" <c:if test="${size eq 'm'}">selected</c:if>>m</option>
			<option value="l" <c:if test="${size eq 'l'}">selected</c:if>>l</option>
			<option value="xl" <c:if test="${size eq 'xl'}">selected</c:if>>xl</option>
		</select>
		<b>가격 범위</b>
		<input type="number" min="1" max="2147483647" name="minprice" value="${minprice}" style="text-align: right"> <b>~</b>
		<input type="number" min="1" max="2147483647" name="maxprice" value="${maxprice}" style="text-align: right"> 원
		
		<button type="submit">검색</button>
	</div>
</form>
<form action="/customer/productList" method="get">
	<div style="text-align: right; padding-bottom: 10px">
		<c:choose>
			<c:when test="${view eq 'list'}">
				<input type="hidden" name="view" value="array" />
				<input type="hidden" name="keyword" value="${keyword }" />
				<input type="hidden" name="size" value="${size }" />
				<input type="hidden" name="minprice" value="${minprice }" />
				<input type="hidden" name="maxprice" value="${maxprice }" />
				<button type="submit" style="text-align: right ">배열형 보기</button>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="view" value="list" />
				<input type="hidden" name="keyword" value="${keyword }" />
				<input type="hidden" name="size" value="${size }" />
				<input type="hidden" name="minprice" value="${minprice }" />
				<input type="hidden" name="maxprice" value="${maxprice }" />
				<button type="submit" style="text-align: right">리스트형 보기</button>
			</c:otherwise>
		</c:choose>
	</div>
</form>

<c:choose>
	<c:when test="${view eq 'list'}">
		<div class="notice margin-top">
			<h3 class="hidden">상품 목록</h3>
			<table class="table">
				<thead>
					<tr>
						<th class="expand">선택</th>
						<th class="expand">상품명</th>
						<th class="w100">가격</th>
						<th class="w130">설명</th>
						<th class="w200">사이즈</th>
						<th class="w200">등록날짜</th>
						<th class="w200">좋아요 수</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="n" items="${productList}">
						<tr>
							<td class="checkBox"><input type="checkBox"
								name="productChecked" value="${n.productID}" /></td>
							<td><a href="/admin/productDetail?id=${n.productID}">${n.name}</a></td>
							<td>${n.price}</td>
							<td>${n.description}</td>
							<td>${n.size}</td>
							<td><fmt:formatDate value="${n.regDate}"
									pattern="yyyy-MM-dd" /></td>
							<td>${n.like}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
	</c:when>
	<c:otherwise>
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
							<h4 class="card-title" style="text-align: center">
								<a href="/customer/productDetail?id=${n.productID}">${n.name}</a>
							</h4>
							<h5 style="text-align: right"><fmt:formatNumber value="${n.price}"/> 원</h5>
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
	</c:otherwise>
</c:choose>
