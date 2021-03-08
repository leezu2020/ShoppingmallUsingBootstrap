<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<div class="col-lg-3">

	<h1 class="my-4">리주's SHOP</h1>
	<div class="list-group">
		<a href="/customer/noticeList" class="list-group-item">공지사항 &nbsp<span class="badge badge-pill badge-dark">${noticeNum}</span></a>
		<a href="/customer/eventList" class="list-group-item">이벤트 &nbsp<span class="badge badge-pill badge-dark">${eventNum}</span></a>
		<a href="/customer/productList"	class="list-group-item">전체 상품 &nbsp<span class="badge badge-pill badge-dark">${productNum}</span></a>
	</div>
	
	<c:choose>
		<c:when test="${authInfo.authority eq 0}">
			<h1 class="my-4">내 정보 관리</h1>
			<div class="list-group">
				<a href="/customer/user/userInfo" class="list-group-item">내 정보</a>
				<a href="/customer/user/basketList" class="list-group-item">장바구니 &nbsp<span class="badge badge-pill badge-dark">${basketNum}</span></a>
				<a href="/customer/user/orderList"	class="list-group-item">주문내역 &nbsp<span class="badge badge-pill badge-dark">${orderNum}</span></a>
			</div>
		
		</c:when>
		<c:when test="${authInfo.authority eq 1}">
				<h1 class="my-4">관리자 메뉴</h1>
				<div class="list-group">
																							<!-- 회원 수 가져와서 출력 -->
					<a href="/admin/userList?page=1" class="list-group-item">회원 관리<span class="badge badge-pill badge-dark">${userNum}</span></a>
					<a href="/admin/noticeList" class="list-group-item">공지사항 관리 &nbsp<span class="badge badge-pill badge-dark">${noticeNum}</span></a>
					<a href="/admin/eventList" class="list-group-item">이벤트 관리 &nbsp<span class="badge badge-pill badge-dark">${eventNum}</span></a>
					<a href="/admin/productList"	class="list-group-item">전체 상품 관리 &nbsp<span class="badge badge-pill badge-dark">${productNum}</span></a>
					<a href="/admin/orderList"	class="list-group-item">주문 관리 &nbsp<span class="badge badge-pill badge-dark">${allOrderNum}</span></a>
				</div>
		</c:when>
	</c:choose>

</div>