<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="content">
		<div class="my_row">
		<!-- 주문상세내역 -->
			<div class="goods_cart">
				<h3>장바구니</h3>
				<div class="goods_cart_list">
				<form action="${cp}/shop/goods_list_order" method="post">
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
							<td><input type="text" class="form-control" style="width:50px;height:20px;margin:0 auto;" value="${basketvo.p_count}"></td>
							<td>${basketvo.p_price*basketvo.p_count}원</td>
							<td><input type="checkbox" name="c1" value="${basketvo.b_num}"></td>
							<td><a href="${cp}/shop/goods_cart_delete?b_num=${basketvo.b_num}">삭제</a></td>
							
						</tr>
						
						</c:forEach>
					
					</table>
							
						
							
							<div style="margin-top:30px;text-align:center;"><!-- 페이징 처리 -->
								<c:if test="${startPageNum>10 }">
									<a href="${cp }/shop/goods_cart?pageNum=${startPageNum-1 }">[이전]</a>
								</c:if>
								<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
									<c:choose>
										<c:when test="${i==pageNum }">
											<a href="${cp }/shop/goods_cart?pageNum=${i}" >
											<span style="color:black">[${i }]</span></a>
										</c:when>
										<c:otherwise>
											<a href="${cp }/shop/goods_cart?pageNum=${i}">
											<span style="color:grey">[${i }]</span></a>
										</c:otherwise>
									</c:choose>
								</c:forEach>	
								<c:if test="${endPageNum<pageCount }">
									<a href="${cp }/shop/goods_cart?pageNum=${endPageNum+1 }" >[다음]</a>
								</c:if>
							</div>
							
					<div class="btn_wrap">
						<button type="submit" class="btn btn-dark">주문하기</button>
					</div>
				</form>
	
				</div>
							
			</div>
			</div>
			</div>