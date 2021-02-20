<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	<h2 class="main title">상품 조회</h2>
	<c:choose>
		<c:when test="${authInfo.authority eq 0}">
			<form action = "/customer/user/addBasket" method = "post">
				<table class="basket">
					<tr style="text-align: center;">
						<td colspan="3" align="right">
							<input type="number" name="cnt" value="1" style="text-align: center;" min="1" max="${product.ea}"/>
						</td>
						<td>
							<input type="hidden" name="productID" value="${product.productID}">
							<input type="submit" value="장바구니 담기">
						</td>
					</tr>
				</table>
			</form>
		</c:when>
	</c:choose>


	<div class="margin-top first">
		<table class="table">
			<tbody>
				<tr>
					<th>상품명</th>
					<td class="text-align-left text-indent text-strong text-orange"
						colspan="3">${product.name}</td>
				</tr>
				<tr>
					<th>가격</th>
					<td class="text-align-left text-indent text-strong text-orange"
						colspan="3">${product.price}</td>
				</tr>
				<tr>
					<th>수량</th>
					<td class="text-align-left text-indent text-strong text-orange"
						colspan="3">${product.ea}</td>
				</tr>
				<tr>
					<th>상품 이미지</th>
					<td colspan="3" class="text-align-left text-indent"><img
						class="card-img-top"
						src="${pageContext.request.contextPath}/resources/images/${product.imageUrl}"
						onerror="this.src='http://placehold.it/700x400'" alt="${n.name}">
					</td>
				</tr>
				<tr>
					<th>사이즈</th>
					<td class="text-align-left text-indent text-strong text-orange"
						colspan="3">${product.size}</td>
				</tr>
				<tr class="content">
					<th>설명</th>
					<td colspan="4">${product.description}</td>
				</tr>
			</tbody>
		</table>
	</div>
</main>
