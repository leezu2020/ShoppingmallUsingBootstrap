<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<title>공지사항</title>
<div class="notice margin-top">
	<h3 class="hidden">공지사항 목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th class="w60">번호</th>
				<th class="expand">제목</th>
				<th class="expand">내용</th>
				<th class="w100">작성자</th>
				<th class="w100">작성일</th>
				<th class="w100">수정일</th>
			</tr>
		</thead>
		<tbody>
				
		<c:forEach var="n" items="${noticeList}">
			<tr>
				<td>${n.noticeID}</td>
				<td class="title indent text-align-left"><a href="noticeDetail">${n.title}</a></td>
				<td>${n.content}</td>
				<td>${n.writerID}</td>
				<td>
					<fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd" />		
				</td>
				<td>
					<fmt:formatDate value="${n.modDate}" pattern="yyyy-MM-dd" />	
				</td>
			</tr>
		</c:forEach>	

		
		</tbody>
	</table>
</div>