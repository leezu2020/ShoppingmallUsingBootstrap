<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div style="padding-top: 20px; padding-bottom: 20px">
	<h3 class="hidden">장바구니 변동사항</h3>
	<c:choose>
		<c:when test="${empty noticeList || noticeList eq null}">
			<h5>변동 사항이 없습니다.</h5>
		</c:when>
	</c:choose>
	<c:forEach var="n" items="${noticeList}">
		<h5>상품 <b>"${n.content}"</b> 가 재고 및 기타이유로 삭제되었습니다.<fmt:formatNumber value="${n.regDate}" pattern="yy-mm-dd"/></h5>
	</c:forEach>
</div>


<form action="/customer/user/order" method="Get">
	<div class="notice margin-top" style="padding-top: 10px">
		<h3 class="hidden">장바구니 목록</h3>
		<table class="table">
			<thead>
				<tr align="center">
					<th class="expand">선택</th>
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
						<td class="checkBox">
							<input type="checkBox" name="basketChecked" value="${b.basketID}" />
						</td>
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
	<div style="text-align: right">
		<input type="submit" value="주문하기">
	</div>
</form>