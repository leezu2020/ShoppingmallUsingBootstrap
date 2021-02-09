<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form role="form" modelAttribute="notice" action="/admin/modNotice?id=${notice.noticeID}" method="post">
<input type="hidden" name="noticeID" value="${notice.noticeID}"/>
	<main>
		<h2 class="main title">게시판</h2>
		
			<div class="margin-top first">
				<h3 class="hidden">게시판 내용</h3>
				<table class="table">
					<tbody>
						<tr>
							<th>제목</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">
							<form:input type="text" class="form-control" placeholder="${notice.title}" path="title"/>
							</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td class="text-align-left text-indent" colspan="3">${notice.regDate}</td>
						</tr>
						<tr>
							<th>최종 수정일</th>
							<td class="text-align-left text-indent" colspan="3">${notice.modDate}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${notice.writerID}</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3"></td>
						</tr>
						<tr class="content">
							<th>내용</th>
							<td colspan="4">
								<form:input type="text" class="form-control" placeholder="${notice.content}" path="content"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		
		<button type="submit" class="btn btn-default">저장</button>			
	</main>		
</form:form>
		