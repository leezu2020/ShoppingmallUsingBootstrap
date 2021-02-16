<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

	<div class="row">


			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<a href="/customer/eventDetail?id=1"><img class="d-block img-fluid" src="http://placehold.it/900x350"
							alt="First slide"></a>
					</div>
					<div class="carousel-item">
						<a href="/customer/eventDetail?id=2"><img class="d-block img-fluid" src="http://placehold.it/900x350"
							alt="Second slide"></a>
					</div>
					<div class="carousel-item">
						<a href="/customer/eventDetail?id=3"><img class="d-block img-fluid" src="http://placehold.it/900x350"
							alt="Third slide"></a>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

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

</div>
