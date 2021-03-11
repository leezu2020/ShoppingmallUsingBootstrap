<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<header id="header">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/">리주의 쇼핑몰</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

				<sec:authorize access="!isAuthenticated()">
					<div class="collapse navbar-collapse" id="navbarResponsive">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link"
								href="/login">로그인 <span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item">
								<a class="nav-link"	href="/customer/user">회원가입</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
						</ul>
					</div>
				</sec:authorize>


			<sec:authorize access="isAuthenticated()">
			<!-- 유저 로그인 -->
				<sec:authorize access="hasRole('ROLE_USER')">
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link">
							<sec:authentication property="principal.userName"/> 님,
								환영합니다.</a><span class="sr-only">(current)</span></li>
						<li class="nav-item"><a class="nav-link"
							href="/logout">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/customer/user/<sec:authentication property="principal.username"/>">내 정보</a></li>
					</ul>
				</div>
				</sec:authorize>
			<!-- 관리자 로그인 -->	
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<div class="collapse navbar-collapse" id="navbarResponsive">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link">관리자님 환영합니다.</a> <span
								class="sr-only">(current)</span></li>
							<li class="nav-item"><a class="nav-link"
								href="/logout">로그아웃</a></li>
							<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/admin/users?page=1">관리자 페이지</a></li>
						</ul>
					</div>
				</sec:authorize>
			</sec:authorize>
		</div>
	</nav>
</header>
