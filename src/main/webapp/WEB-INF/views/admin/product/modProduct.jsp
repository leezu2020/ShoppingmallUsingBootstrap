<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="/admin/product/${product.productID}" method="post" enctype="multipart/form-data">
	<input type="hidden" name="_method" value="PUT" />
	<div class="margin-top first">
		<h3 class="hidden">상품 수정</h3>
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
						colspan="3"><input type="number" value="${product.price}"
						name="price" min="1" max="2147483647" /> <b>원</b></td>
				</tr>
				<tr>
					<th>상품 이미지</th>
					<td colspan="3" class="text-align-left text-indent"><img
						class="card-img-top"
						src="${pageContext.request.contextPath}/resources/images/${product.imageUrl}"
						onerror="this.src='http://placehold.it/700x400'" alt="${n.name}"
						style="width: 200px"> <input type="file" name="file" /></td>
				</tr>
				<tr>
					<th>사이즈</th>
					<td><select name="size" id="size">
							<option value="s"
								<c:if test="${product.size eq 's'}">selected</c:if>>S</option>
							<option value="m"
								<c:if test="${product.size eq 'm'}">selected</c:if>>M</option>
							<option value="l"
								<c:if test="${product.size eq 'l'}">selected</c:if>>L</option>
							<option value="xl"
								<c:if test="${product.size eq 'xl'}">selected</c:if>>XL</option>
					</select></td>
				</tr>
				<tr class="content">
					<th>재고</th>
					<td><input type="number" name="ea" min="1" max="2147483647"
						value="${product.ea}" /> <b>개</b></td>
				</tr>
				<tr class="content">
					<th>설명</th>
					<td colspan="4"><textarea class="content" name="description">${product.description}</textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="margin-top text-align-center">
		<input class="btn-text btn-default" type="submit" value="수정하기" />
	</div>
</form>

