<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <main>
        <h2 class="main title">상품 등록</h2>

        <form method="post" action="/admin/regProduct" enctype="multipart/form-data">
            <div class="margin-top first">
                <h3 class="hidden">상품 입력</h3>
                <table class="table">
                    <tbody>
                        <tr>
                            <th>상품명</th>
                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
                                <input type="text" name="name" />
                            </td>
                        </tr>
                        <tr>
                            <th>가격</th>
                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
                                <input type="number" name="price" min="1" max="2147483647"/> <b>원</b>
                            </td>
                        </tr>
                        <tr>
                            <th>상품 이미지</th>
                            <td colspan="3" class="text-align-left text-indent"><input type="file"
                                    name="file" /> </td>
                        </tr>
                        <tr>
                            <th>사이즈</th>
                            <td>
	                           <select name="size" id="size">
									<option value="s" selected>S</option>
									<option value="m" >M</option>
									<option value="l" >L</option>
									<option value="xl" >XL</option>
								</select>
							</td>
                        </tr>
                        <tr class="content">
                        	<th>재고</th>
							<td>
								<input type="number" name="ea" min="1" max="2147483647"/> <b>개</b>
							</td>
                        </tr>
                        <tr class="content">
                        	<th>설명</th>
                            <td colspan="4"><textarea class="content" name="description"></textarea></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="margin-top text-align-center">
                <input class="btn-text btn-default" type="submit" value="등록" />
                <a class="btn-text btn-cancel" href="/admin/productList">취소</a>
            </div>
        </form>

    </main>
