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
    
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css" />" >
    <link rel="stylesheet" href="<c:url value="/resources/css/style-signup.css" />" >

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
</head>
<div class="panel-body">
   <form action="/login" method="post">
        <fieldset>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="ID" name="username"/>
            </div>
            <div class="form-group">
                 <input type="password" class="form-control" placeholder="Password" name="password"/>
            </div>
            <button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
        </fieldset>
    </form>
</div>