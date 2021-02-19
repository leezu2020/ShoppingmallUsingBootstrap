<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <main>
        <h2 class="main title">상품 조회</h2>
        
	            <div class="margin-top first">
	                <table class="table">
	                    <tbody>
	                        <tr>
	                            <th>상품명</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
	                                ${product.name}
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>가격</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
	                               ${product.price}
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>상품 이미지</th>
	                            <td colspan="3" class="text-align-left text-indent">
	                            <img class="card-img-top"
								src="${pageContext.request.contextPath}/resources/images/${product.imageUrl}"
								onerror="this.src='http://placehold.it/700x400'"
								alt="${n.name}">
								</td>
	                        </tr>
	                        <tr>
	                            <th>사이즈</th>
	                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
	                                ${product.size}
	                            </td>
	                        </tr>
	                        <tr class="content">
	                        	<th>설명</th>
	                            <td colspan="4">
	                            	${product.description}
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	            
            <button type="button" class="delProduct" style="float:right;" onclick = "location.href = '/admin/delProduct?id=${product.productID}'">삭제하기</button>	
			<button type="button" class="modProduct" style="float:right;" onclick = "location.href = '/admin/modProduct?id=${product.productID}'">수정하기</button>	
    </main>