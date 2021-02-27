<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="notice margin-top" style="padding-top: 10px">
	<h3 class="hidden">주문 목록</h3>
	<table class="table">
		<thead>
			<tr align="center">
				<th class="w40">주문자</th>
				<th class="w60" align="center">상품아이디</th>
				<th class="w50">수량</th>
				<th class="w30">금액</th>
				<th class="w70">주문일 / 배송 예정일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="o" items="${orderList}">
				<tr>
					<td align="center">${o.userID}</td>
					<td align="center">${o.productID}</td>
					<td align="center">${o.count}</td>
					<td align="right"><fmt:formatNumber value="${o.total}" pattern="###,###,###"/> 원</td>
					<td align="center">
						<fmt:formatDate value="${o.regDate}" pattern="yy-MM-dd" /> / 
						<fmt:formatDate value="${o.dueDate}" pattern="yy-MM-dd" />		
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