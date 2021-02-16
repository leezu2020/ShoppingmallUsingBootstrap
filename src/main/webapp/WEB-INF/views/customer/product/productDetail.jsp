<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	<h2 class="main title">상품 조회</h2>
	<c:choose>
		<c:when test="${authInfo.authority eq 0}">
			<form action = "/customer/addBasket" method = "post">
				<table class="basket">
					<tr style="text-align: center;">
						<td colspan="3" align="right">
							<button type="button" onclick="fnCalCount('p',this);">+</button>
							<input type="text" name="cnt" value="1" readonly="readonly" style="text-align: center;" />
							<button type="button" onclick="fnCalCount('m', this);">-</button>
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


<script>
	function fnCalCount(type, ths) {
		var $input = $(ths).parents("td").find("input[name='cnt']");
		var tCount = Number($input.val());
		var tEqCount = "<c:out value='${product.ea}'/>";

		if (type == 'p') {
			if (tCount < tEqCount)
				$input.val(Number(tCount) + 1);

		} else {
			if (tCount > 1)
				$input.val(Number(tCount) - 1);
		}
	}
</script>