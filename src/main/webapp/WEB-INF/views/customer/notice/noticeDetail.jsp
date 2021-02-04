<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<main>
		<h2 class="main title">게시판</h2>
		
			<div class="margin-top first">
				<h3 class="hidden">게시판 내용</h3>
				<table class="table">
					<tbody>
						<tr>
							<th>제목</th>
							<td class="text-align-left text-indent text-strong text-orange" colspan="3">${notice.title}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td class="text-align-left text-indent" colspan="3">${notice.regDate}</td>
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
							<td colspan="4">${notice.content}</td>
						</tr>
					</tbody>
				</table>
			</div>
		
			<div class="margin-top text-align-center">
				<a class="btn btn-list" href="noticelist">목록</a>
			</div>
			
			<div class="margin-top">
				<table class="table border-top-default">
					<tbody>
						
						<tr>
							<th>다음글</th>
							<td colspan="3"  class="text-align-left text-indent">다음글이 없습니다.</td>
						</tr>
						
						<tr>
							<th>이전글</th>
							<td colspan="3"  class="text-align-left text-indent"><a class="text-blue text-strong" href="">스프링 DI 예제 코드</a></td>
						</tr>
						
						
					</tbody>
				</table>
			</div>			
			
	</main>		