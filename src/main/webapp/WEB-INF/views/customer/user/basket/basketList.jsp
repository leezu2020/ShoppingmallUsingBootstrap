<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<title>장바구니</title>
<div class="notice margin-top">
	<h3 class="hidden">장바구니 목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th class="w60">상품명</th>
				<th class="w100">수량</th>
				<th class="w100">등록일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="b" items="${basketList}">
				<tr>
					<td>${b.productID}</td>
					<td>${b.count}</td>
					<td>
						<fmt:formatDate value="${b.regDate}" pattern="yyyy-MM-dd" />		
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>