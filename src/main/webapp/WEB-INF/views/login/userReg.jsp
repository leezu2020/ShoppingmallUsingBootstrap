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
                    <form:input id="email" type="text" class="form-control" placeholder="Email" path="userEmail"/>
                    <form:errors path="userEmail"/>
                    <input type="button" id="email-btn" onClick="fn_sendEmail()" value="이메일 인증">
                    <input type="text" disabled="disabled" id="inputCode" placeholder="인증번호를 입력해주세요">
                    <input type="button" id="code-btn" onClick="fn_checkCode()" value="인증번호 확인" disabled="disabled">
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
                <input type="submit" id="submit-btn" class="btn btn-default" disabled="disabled" value="가입하기">
                <button type="reset" class="btn btn-default">취소하기</button>
            </form:form>
        </div>
    </div>
</div>

<script type="text/javascript">
	var code = '';
	function fn_sendEmail(){
		$.ajax({
			url : "/email/" + $('#email').val(),
			type : "get",
			success : function(result){
				alert('이메일이 전송되었습니다.');
				$('#inputCode').attr("disabled",false);
				$('#code-btn').attr("disabled",false);
				code = result;
				console.log(code);
			},
			error : function(e){
				console.log(e);
			}
		});
	};
	
	function fn_checkCode(){
		var inputCode = $('#inputCode').val();
		console.log(inputCode);
		console.log(code);
		if(inputCode == code){
			alert('인증되었습니다.');
			$('#submit-btn').attr("disabled",false);
		} else {
			alert('인증번호를 다시 확인해주세요.');
		}
	}
</script>