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
	                        <tr>
	                            <th>이메일 인증 여부</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
	                               <c:if test="${user.emailChecked}">
	                            		<c:out value="인증 완료" />
	                               </c:if>
	                               <c:if test="${!user.emailChecked}">
	                            		<c:out value="미인증" />
	                               </c:if>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	            
	            <button type="button" class="ModerateUserBtn" style="float:right;" onclick = "location.href = '/customer/modUser'">정보 수정</button>		
    </main>