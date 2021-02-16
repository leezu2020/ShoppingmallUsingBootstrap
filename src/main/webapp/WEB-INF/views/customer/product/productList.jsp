<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

	<div class="row">
		<c:forEach var="n" items="${productList}">
		<!-- el 표기법(n.getID()) -->
		<div class="col-lg-4 col-md-6 mb-4">
			<div class="card h-100">
				<a href="/customer/productDetail?id=${n.productID}"><img class="card-img-top"
					src="${pageContext.request.contextPath}/resources/images/${n.imageUrl}"
					onerror="this.src='http://placehold.it/700x400'"
					alt="${n.name}"></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">${n.name}</a>
					</h4>
					<h5>${n.price} 원</h5>
					<p class="card-text">${n.description}</p>
				</div>
				<div class="card-footer">
				<!-- &#9733은 채워진별 &#9734는 빈별 -->
					<small class="text-muted">&#9733; &#9733; &#9733; &#9733;
						&#9734;</small>
				</div>
			</div>
		</div>
		</c:forEach>


	</div>
</div>
