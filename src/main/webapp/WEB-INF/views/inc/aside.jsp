<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="col-lg-3">

	<h1 class="my-4">리주's SHOP</h1>
	<div class="list-group">
		<a href="/customer/noticeList" class="list-group-item">공지사항 &nbsp<span class="badge badge-pill badge-dark">${noticeNum}</span></a>
		<a href="/customer/eventList" class="list-group-item">이벤트 &nbsp<span class="badge badge-pill badge-dark">${eventNum}</span></a>
		<a href="/customer/productList"	class="list-group-item">전체 상품 &nbsp<span class="badge badge-pill badge-dark">${productNum}</span></a>
	</div>

</div>