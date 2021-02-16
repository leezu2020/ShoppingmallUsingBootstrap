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
					<td align="center">${b.productName}</td>
					<td align="right"><fmt:formatNumber value="${b.productPrice}" pattern="###,###,###"/></td>
					<td align="center">${b.count}</td>
					<td align="right"><fmt:formatNumber value="${b.total}" pattern="###,###,###"/></td>
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
				<td></td>
				<td>총 금액</td>
				<td></td>
			</tr>
		</tfoot>
	</table>

</div>