<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="/customer/users/${userInfo.userID}" method="post">
	<input type="hidden" name="_method" value="PUT"/>
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
	                                <input type="text" value="${userInfo.userName}" name="userName"/>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이메일</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="2">
	                               ${userInfo.userEmail}"
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	            
		<input type="submit" value="회원정보수정">			
    </main>
</form>