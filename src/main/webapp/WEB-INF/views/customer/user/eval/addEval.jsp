<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="post" action="/customer/users/eval">
<input type="hidden" name="orderID" value="${order.orderID}">
<input type="hidden" name="productID" value="${order.productID}">
	<div class="margin-top first">
	    <h3 class="hidden">평가 입력</h3>
	    <table class="table">
	        <tbody>
	            <tr>
	                <th>상품명</th>
	                <td colspan="2">
	                    ${order.name}
	                </td>
	                <th>평가</th>
	                <td colspan="3">
	                    <input type="number" name="evalRate" value="1" min="1" max="5" />
	                </td>
	            </tr>
	            <tr>
	            	<th>상품 후기</th>
	                <td colspan="4"><textarea name="content" cols="70" rows="20" required></textarea></td>
	            </tr>
	        </tbody>
	    </table>
	</div>
	<div class="margin-top text-align-center">
	    <input class="btn-text btn-default" type="submit" value="등록" />
	    <a href="/customer/users/orders">취소</a>
	</div>
</form>