<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="content">
		<div class="my_row">
		<!-- 주문상세내역 -->
			<div class="goods_cart">
				<h3>장바구니</h3>
				<div class="goods_cart_list">
				<form action="">
					<table>
						<tr>
							<th></th>
							<th>상품명</th>
							<th>사이즈</th>
							<th>가격</th>
							<th>수량</th>
							<th>주문금액</th>
							<th></th>
						</tr>
						<c:forEach var="basketvo" items="${basketlistvo}">
						
							<tr>
							<td style=""><img src="${cp}/shop/productimgs/${basketvo.save_img_name}" style="width:100px;"></td>
							<td>${basketvo.p_name}</td>
							<td>${basketvo.p_size}</td>
							<td>${basketvo.p_price}</td>
							<td><input type="number" class="form-control" min="0" placeholder="0" style="width:50px;height:20px;margin:0 auto;" value="${basketvo.p_count}"></td>
							<td>${basketvo.p_price*basketvo.p_count}원</td>
							<td><a href="${cp}//shop/goods_cart_delete">삭제</a></td>
						</tr>
						
						</c:forEach>
					
					</table>
					<div class="btn_wrap">
						<button type="submit" class="btn btn-dark">주문하기</button>
					</div>
				</form>
				</div>
			</div>
			</div>
			</div>