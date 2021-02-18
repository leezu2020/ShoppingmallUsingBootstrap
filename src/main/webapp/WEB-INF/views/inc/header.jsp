<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<header id="header">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/">리주의 쇼핑몰</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<form name='headForm' method="post" action="/user/userLogin">
				<c:catch>
						<!-- 로그인 안한 상태 -->
					<c:choose>
						<c:when test="${empty authInfo}">
							<div class="collapse navbar-collapse" id="navbarResponsive">
								<ul class="navbar-nav ml-auto">
									<li class="nav-item"><a class="nav-link"
										href="/login/userLogin">로그인 <span class="sr-only">(current)</span>
									</a></li>
									<li class="nav-item"><a class="nav-link"
										href="/login/userReg">회원가입</a></li>
									<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
								</ul>
							</div>
						</c:when>
						<c:otherwise>

							<c:choose>
								<c:when test="${authInfo.authority eq 1}">
									<div class="collapse navbar-collapse" id="navbarResponsive">
										<ul class="navbar-nav ml-auto">
											<li class="nav-item"><a class="nav-link">관리자님 환영합니다.</a>
													<span class="sr-only">(current)</span>
											</li>
											<li class="nav-item"><a class="nav-link" href="/login/userLogout">로그아웃</a></li>
											<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
											<li class="nav-item"><a class="nav-link" href="/admin/userList?page=1">관리자 페이지</a></li>
										</ul>
										
									</div>
								</c:when>
									<c:when test="${authInfo.authority eq 0}">
										<div class="collapse navbar-collapse" id="navbarResponsive">
											<ul class="navbar-nav ml-auto">
												<li class="nav-item"><a class="nav-link">${authInfo.userName}님, 환영합니다.</a><span
													class="sr-only">(current)</span>
												</li>
												<li class="nav-item"><a class="nav-link"
													href="/login/userLogout">로그아웃</a></li>
												<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
												<li class="nav-item"><a class="nav-link" href="/customer/userInfo">내
														정보</a></li>
											</ul>
										</div>
									</c:when>

							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:catch>

			</form>

		</div>
	</nav>
</header>
