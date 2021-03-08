<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
</head>
<div class="panel-body">
    	*는 필수 정보입니다.
    <div class="row">
        <div class="col-lg-6">
            <form:form modelAttribute="userRegReq" action="/login/userReg" method="post">
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-check">*</i></span>
                    <form:input type="text" class="form-control" placeholder="ID" path="userID"/>
                    <form:errors path="userID"/>
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope">*</i></span>
                    <form:input type="text" class="form-control" placeholder="Email" path="userEmail"/>
                    <form:errors path="userEmail"/>
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <form:input type="text" class="form-control" placeholder="Name" path="userName"/>
                    <form:errors path="userName"/>
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-lock">*</i></span>
                    <form:password class="form-control" placeholder="Password" path="userPassword"/>
                    <form:errors path="userPassword"/>
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-lock">*</i></span>
                    <form:password class="form-control" placeholder="Password Check" path="checkPassword"/>
                    <form:errors path="checkPassword"/>
                </div>
                <button type="submit" class="btn btn-default">가입하기</button>
                <button type="reset" class="btn btn-default">취소하기</button>
            </form:form>
        </div>
    </div>
</div>
