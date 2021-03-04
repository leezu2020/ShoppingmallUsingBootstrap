<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main>
    <h2 class="main title">상품 조회</h2>
        
	<div class="margin-top first">
		<table class="table">
			<tbody>
				<tr>
					<td rowspan="7" align="center">
					<img class="card-img-top"
						src="${pageContext.request.contextPath}/resources/images/${product.imageUrl}"
						onerror="this.src='http://placehold.it/700x400'" alt="${n.name}" style="height: 300px; object-fit:contain">
					</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td class="text-align-left text-indent text-strong text-orange">
						${product.name}
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td class="text-align-left text-indent text-strong text-orange">
						<fmt:formatNumber value="${product.price}"/> <b>원</b>
					</td>
				</tr>
				<tr>
					<th>재고</th>
					<td class="text-align-left text-indent text-strong text-orange"colspan="3">
						${product.ea} <b>개</b>
					</td>
				</tr>
				<tr>
					<th>사이즈</th>
					<td class="text-align-left text-indent text-strong text-orange">
						${product.size}
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
					<c:choose>
						<c:when test="${avgRate eq 0}">판매 기록 無</c:when>
						<c:when test="${avgRate eq 1}">★☆☆☆☆</c:when>
						<c:when test="${avgRate eq 2}">★★☆☆☆</c:when>
						<c:when test="${avgRate eq 3}">★★★☆☆</c:when>
						<c:when test="${avgRate eq 4}">★★★★☆</c:when>
						<c:otherwise>★★★★★</c:otherwise>
					</c:choose>
					<br/>( ${cnt} )
					<td>
				</tr>
				<tr>
					<th>설명</th>
					<td colspan="4">${product.description}</td>
				</tr>
			</tbody>
		</table>
	</div>
	            
            <button type="button" class="delProduct" style="float:right;" onclick = "location.href = '/admin/delProduct?id=${product.productID}'">삭제하기</button>	
			<button type="button" class="modProduct" style="float:right;" onclick = "location.href = '/admin/modProduct?id=${product.productID}'">수정하기</button>	
  	<div class="margin-top">
		<h2>상품 후기</h2>
		<table class="table" style="margin-bottom: 100px">
			<thead>
				<tr>
					<th width="40%" style="text-align: center">작성자</th>
					<th width="10%" style="text-align: center">평점</th>
					<th width="50%" style="text-align: center">후기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eval" items="${evalList}">
					<tr>
						<td align="center">${eval.userName}</a></td>
						<td align="center"><!-- 별점 출력 c:if로 해야할듯? -->
							<c:choose>
								<c:when test="${eval.evalRate eq 1}">★☆☆☆☆</c:when>
								<c:when test="${eval.evalRate eq 2}">★★☆☆☆</c:when>
								<c:when test="${eval.evalRate eq 3}">★★★☆☆</c:when>
								<c:when test="${eval.evalRate eq 4}">★★★★☆</c:when>
								<c:otherwise>★★★★★</c:otherwise>
							</c:choose>
						</td>
						<td align="center">${eval.content}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>  
</main>