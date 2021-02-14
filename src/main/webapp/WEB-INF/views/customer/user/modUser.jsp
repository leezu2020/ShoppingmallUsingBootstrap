<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form role="form" modelAttribute="userInfo" action="/customer/user/modUser" method="post">
<input type="hidden" name="userID" value="${userInfo.userID}"/>
    <main>
        <h2 class="main title">내 정보 수정</h2>
	            <div class="margin-top first">
	                <table class="table">
	                    <tbody>
	                    	<tr>
	                            <th>아이디</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="2">
	                                ${userInfo.userID}
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이름</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="2">
	                                <form:input type="text" class="form-control" placeholder="${userInfo.userName}" path="userName"/>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이메일</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="2">
	                               <form:input type="text" class="form-control" placeholder="${userInfo.userEmail}" path="userEmail"/>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	            
		<button type="submit" class="btn btn-default">저장</button>			
    </main>
</form:form>