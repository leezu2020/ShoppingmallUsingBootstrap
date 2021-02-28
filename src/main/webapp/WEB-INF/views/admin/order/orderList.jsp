<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form action="/admin/modOrder" method="post">
	<div class="notice margin-top" style="padding-top: 10px">
		<h3 class="hidden">주문 목록</h3>
		<table class="table">
			<thead>
				<tr align="center">
					<th></th>
					<th class="w40">주문자</th>
					<th class="w60" align="center">상품명</th>
					<th class="w50">수량</th>
					<th class="w30">금액</th>
					<th class="w70">주문일 / 배송 예정일</th>
					<th class="w20">주문 상태 설정</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="o" items="${orderList}">
					<tr>
						<td class="checkBox">
							<input type="checkBox" name="orderChecked" value="${o.orderID}" />
						</td>
						<td align="center">${o.userName}</td>
						<td align="center">${o.name}</td>
						<td align="center">${o.count}</td>
						<td align="right"><fmt:formatNumber value="${o.total}" pattern="###,###,###"/> 원</td>
						<td align="center">
							<fmt:formatDate value="${o.regDate}" pattern="yy-MM-dd" /> / 
							<fmt:formatDate value="${o.dueDate}" pattern="yy-MM-dd" />		
						</td>
						<td align="center">
							<select name="state" id="state">
								<option value="preOrder" <c:if test="${state eq 'preOrder' }"> selected </c:if>>주문 준비중</option>
								<option value="orderChecked" <c:if test="${state eq 'orderChecked' }"> selected </c:if>>주문 접수 완료</option>
								<option value="depositChecked" <c:if test="${state eq 'depositChecked' }"> selected </c:if>>입금 확인</option>
								<option value="preDel" <c:if test="${state eq 'preDel' }"> selected </c:if>>배송 준비중</option>
								<option value="startDel" <c:if test="${state eq 'startDel' }"> selected </c:if>>배송 시작</option>
								<option value="delivered" <c:if test="${state eq 'delivered' }"> selected </c:if>>배송 완료</option>
							</select>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<input type="submit" value="주문 상태 변경" style="float: right"/>
</form>