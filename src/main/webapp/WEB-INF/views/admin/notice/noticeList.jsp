<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<title>공지사항</title>
<div class="notice margin-top">
	<h3 class="hidden">공지사항 목록</h3>
	<button type="button" onclick="location.href='/admin/regNotice'" style="float:right;">공지사항 등록</button>
	<table class="table">
		<thead>
			<tr>
				<th class="w60">번호</th>
				<th class="expand">제목</th>
				<th class="exapnd">내용</th>
				<th class="w100">작성자</th>
				<th class="w100">작성일</th>
				<th class="w100">수정일</th>
			</tr>
		</thead>
		<tbody>
				
		<c:forEach var="n" items="${noticeList}">
			<tr>
				<td>${n.noticeID}</td>
				<td class="title indent text-align-left"><a href="/admin/noticeDetail?id=${n.noticeID}">${n.title}</a></td>
				<td>
					<c:choose>
			           <c:when test="${fn:length(n.content) > 30}">
			            <c:out value="${fn:substring(n.content,0,29)}"/>....
			           </c:when>
			           <c:otherwise>
			           	 <c:out value="${n.content}"/>
			           </c:otherwise> 
				    </c:choose>
				</td>
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
	
	<div style="display: block; text-align: center;">		
		<c:if test="${page.startPage != 1 }">
			<a href="/admin/noticeList?nowPage=${page.startPage - 1 }&cntPerPage=${page.cntPerPage}">이전</a>
		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="p">
			<c:choose>
				<c:when test="${p == page.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != page.nowPage }">
					<a href="/admin/noticeList?nowPage=${p }&cntPerPage=${page.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${page.endPage != page.lastPage}">
			<a href="/admin/noticeList?nowPage=${page.endPage+1 }&cntPerPage=${page.cntPerPage}">다음</a>
		</c:if>
	</div>
</div>