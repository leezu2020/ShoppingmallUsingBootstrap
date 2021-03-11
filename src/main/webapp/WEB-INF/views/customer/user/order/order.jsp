<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form method="post" action="/customer/user/order">
	<div class="notice margin-top" style="padding-top: 10px">
		<h3 class="hidden" style="padding-bottom: 30px">주문 진행</h3>
		<table class="table">
			<thead>
				<tr align="center">
					<th class="w60" align="center">상품명</th>
					<th class="w50">단가</th>
					<th class="w30">수량</th>
					<th class="w100">금액</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="b" items="${products}">
				<input type="hidden" id="basketID" name="basketID" value="${b.basketID}"/>
				<input type="hidden" id="productID" name="productID" value="${b.productID}"/>
				<input type="hidden" id="userID" name="userID" value="${b.userID}"/>
				<input type="hidden" id="count" name="count" value="${b.count}"/>
				<input type="hidden" id="total" name="total" value="${b.total}"/>
					<tr>
						<td align="center">${b.productName}</td>
						<td align="right"><fmt:formatNumber value="${b.productPrice}" pattern="###,###,###"/> 원</td>
						<td align="center">${b.count}</td>
						<td align="right"><fmt:formatNumber value="${b.total}" pattern="###,###,###"/> 원</td>
						
					</tr>
				</c:forEach>
				<tr>
					<td />
					<td />
					<td align="center"><b>총 합계</b></td>
					<td align="right"><b><fmt:formatNumber value="${sum}" pattern="###,###,###"/>원</b></td>
				</tr>
			</tbody>
		</table>
	</div>

    <div class="margin-top first">
        <h3 class="hidden">주문 정보 입력</h3>
        <table class="table">
            <tbody>
                <tr class="content">
                	<th>우편번호</th>
                    <td colspan="4"><input type="text" id="postCode" name="zipcode" readonly size="10"></td>
                	<td><input type="button" onclick="showPostcode()" value="우편번호 찾기"></td>
                </tr>
                <tr>
                	<th>주소</th>
                	<td colspan="4"><input type="text" id="address1" name="address1" readonly size="50" ></td>
                </tr>
                <tr>
                	<th>상세주소</th>
                	<td colspan="4"><input type="text" id="address2" name="address2"></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="margin-top text-align-center">
        <input class="btn-text btn-default" type="submit" value="등록" />
        <a class="btn-text btn-cancel" href="/customer/user/baskets">돌아가기</a>
    </div>
</form>



<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function showPostcode(){
	new daum.Postcode({
		oncomplete: function(data){
			
			var fullAddress = '';
			var extraAddress = '';
			
			if(data.userSelectedType === 'R'){
				fullAddress = data.roadAddress;
			} else{
				fullAddress = data.jibunAddress;
			}
			
		if(data.userSelectedType === 'R'){
			if(data.bname !== ''){ extraAddress += data.bname;}
			
			if(data.buildingName !== ''){
				extraAddress += (extraAddress !== '' ? ', ' + data.buildingName : data.buildingName);
			}
			
			fullAddress += (extraAddress !== '' ? ' (' + extraAddress + ') ' : '');
		}
		
		document.getElementById('postCode').value = data.zonecode;
		document.getElementById('address1').value = fullAddress;
		
		document.getElementById('address2').focus();
		}
	}).open();
}
</script>