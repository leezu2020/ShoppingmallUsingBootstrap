<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="col-lg-3">

	<h1 class="my-4">리주's SHOP</h1>
	<div class="list-group">
		<a href="/customer/user/userInfo" class="list-group-item">내 정보</a>
		<a href="/customer/user/basketList" class="list-group-item">장바구니 &nbsp<span class="badge badge-pill badge-dark">${basketNum}</span></a>
		<a href="/customer/user/orderList"	class="list-group-item">주문내역 &nbsp<span class="badge badge-pill badge-dark">${orderNum}</span></a>
	</div>

</div>