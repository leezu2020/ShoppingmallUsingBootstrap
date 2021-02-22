<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<td>${n.num}</td>
				<td class="title indent text-align-left"><a href="/customer/noticeDetail?id=${n.noticeID}">${n.title}</a></td>
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
			<a href="/customer/noticeList?nowPage=${page.startPage - 1 }&cntPerPage=${page.cntPerPage}&condition=${page.condition}&keyword=${page.keyword}">이전</a>
		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="p">
			<c:choose>
				<c:when test="${p == page.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != page.nowPage }">
					<a href="/customer/noticeList?nowPage=${p }&cntPerPage=${page.cntPerPage}&condition=${page.condition}&keyword=${page.keyword}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${page.endPage != page.lastPage}">
			<a href="/customer/noticeList?nowPage=${page.endPage+1 }&cntPerPage=${page.cntPerPage}&condition=${page.condition}&keyword=${page.keyword}">다음</a>
		</c:if>
	</div>
</div>
<!-- 공지사항 검색 기능 -->
<form action="/customer/noticeList" method="get">
	<div style="text-align: center;">
		<label for="condition" >검색조건</label>
		<select name="condition" id="condition">
			<option value="all" <c:if test="${condition eq 'all'}">selected</c:if>>제목+내용</option>
			<option value="title" <c:if test="${condition eq 'title'}">selected</c:if>>제목</option>
			<option value="content" <c:if test="${condition eq 'content'}">selected</c:if>>내용</option>
		</select>
		<input type="text" name="keyword" id="keyword" placeholder="검색어" value="${keyword }"/>
		<button type="submit">검색</button>
	</div>
</form>