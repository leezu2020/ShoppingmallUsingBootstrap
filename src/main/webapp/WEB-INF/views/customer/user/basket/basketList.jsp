<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<title>장바구니</title>
<div class="notice margin-top">
	<h3 class="hidden">장바구니 목록</h3>
	<table class="table">
		<thead>
			<tr align="center">
				<th class="w60" align="center">상품명</th>
				<th class="w50">단가</th>
				<th class="w30">수량</th>
				<th class="w100">금액</th>
				<th class="w70">등록일 / 최종 수정일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="b" items="${basketList}">
				<tr>
					<td align="center" onClick="location.href='/customer/productDetail?id=${b.productID}'">${b.productName}</td>
					<td align="right"><fmt:formatNumber value="${b.productPrice}" pattern="###,###,###"/> 원</td>
					<td align="center">${b.count}</td>
					<td align="right"><fmt:formatNumber value="${b.total}" pattern="###,###,###"/> 원</td>
					<td align="center">
						<fmt:formatDate value="${b.regDate}" pattern="yy-MM-dd" /> / 
						<fmt:formatDate value="${b.modDate}" pattern="yy-MM-dd" />		
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td><b>총 금액</b></td>
				<td align="right"><b><fmt:formatNumber value="${sum}" pattern="###,###,###"/> 원</b></td>
			</tr>
		</tfoot>
	</table>

</div>