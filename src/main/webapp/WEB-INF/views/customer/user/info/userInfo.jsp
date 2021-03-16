<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <main>
        <h2 class="main title">내 정보 조회</h2>
	            <div class="margin-top first">
	                <table class="table">
	                    <tbody>
	                    	<tr>
	                            <th>아이디</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
	                                ${user.userID}
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이름</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
	                                ${user.userName}
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이메일</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
	                               ${user.userEmail}
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	            
	            <button type="button" class="ModerateUserBtn" style="float:right;" onclick = "location.href = '/customer/users/${user.userID}/form'">정보 수정</button>		
    </main>