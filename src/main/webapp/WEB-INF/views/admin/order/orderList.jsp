<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="notice margin-top" style="padding-top: 10px">
	<h3 class="hidden">주문 목록</h3>
	<table class="table">
		<thead>
			<tr align="center">
				<th></th>
				<th class="w50">주문자</th>
				<th class="w60" align="center">상품명</th>
				<th class="w20">가격</th>
				<th class="w10">수량</th>
				<th class="w30">금액</th>
				<th class="w20">주문 상태 설정</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="o" items="${orderList}" varStatus="status">
				<tr>
					<td class="checkBox">
						<input id="checkBox" type="checkBox" name="orderChecked" value="${o.orderID}" />
					</td>
					<td align="center">${o.userName}</td>
					<td align="center">${o.name}</td>
					<td align="right"><fmt:formatNumber value="${o.price}" pattern="###,###,###"/> 원</td>
					<td align="center">${o.count}</td>
					<td align="right"><fmt:formatNumber value="${o.total}" pattern="###,###,###"/> 원</td>
					
					<td align="center">
						<select id="state${status.index}">
							<option value="주문 준비중" <c:if test="${o.state eq '주문 준비중'}" > selected </c:if>>주문 준비중</option>
							<option value="주문 접수 완료" <c:if test="${o.state eq '주문 접수 완료'}" > selected </c:if>>주문 접수 완료</option>
							<option value="입금 확인" <c:if test="${o.state eq '입금 확인'}" > selected </c:if>>입금 확인</option>
							<option value="배송 준비중" <c:if test="${o.state eq '배송 준비중'}" > selected </c:if>>배송 준비중</option>
							<option value="배송 시작" <c:if test="${o.state eq '배송 시작'}" > selected </c:if>>배송 시작</option>
							<option value="배송 완료" <c:if test="${o.state eq '배송 완료'}" > selected </c:if>>배송 완료</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right"><b>주소</b></td>
					<td align="center" colspan="3">${o.address}</td>
					<td colspan="2" align="center"><b>주문일 / 배송 예정일</b></td>
					<td align="center" ><fmt:formatDate value="${o.regDate}" pattern="yy-MM-dd" /> / 
						<fmt:formatDate value="${o.dueDate}" pattern="yy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<input type="button" value="주문 상태 변경" onclick="changeState()" style="float: right"/>

<script type="text/javascript">	
	function changeState(){
	
		var newForm = document.createElement('form');
		newForm.name = 'newForm';
		newForm.method = 'post';
		newForm.action = '/admin/modOrder';
		
 		var checkbox = $('input[id=checkBox]:checked');
		var resultArray = new Array();
		
		checkbox.each(function(i){
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			var orderID = td.eq(0).children().val();
			var id = document.createElement('input');
			id.setAttribute("type","hidden");
			id.setAttribute("name","orderID");
			id.setAttribute("value",orderID);
			
			// 선택된 row의 인덱스
			var index = tr.parent().children().index(tr);
			
			// 선택된 select (tr을 추가되어 index에 2를 나눠야됨)
			var sel = document.getElementById("state" + index / 2);
			// 선택된 select의 값
			var state = sel.options[sel.selectedIndex].value;
			var s = document.createElement('input');
			s.setAttribute("type","hidden");
			s.setAttribute("name","state");
			s.setAttribute("value",state);
			
			newForm.appendChild(id);
			newForm.appendChild(s);
			
			document.body.appendChild(newForm);
			newForm.submit();
			
		})
	}
</script>
