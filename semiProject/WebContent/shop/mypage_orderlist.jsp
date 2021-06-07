<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="my_row">
		<div class="mypage">
				<div class="mypage_sidemenu">
					<h3>마이페이지</h3>
					<jsp:include page="${sidemenu }"/>
				</div>
				<div class="mypage_orderlist">
					<h3>주문내역</h3>
					<div class="mypage_orderlist_wrap">
					
						<table>
							<tr>
								<th></th>
								<th>상품명</th>
								<th>주문금액</th>
								<th>주문일자</th>
								<th>주문번호</th>
								<th>주문상태</th>
								<th></th>
							</tr>
							
							<c:forEach var="orderList" items="${requestScope.myOrderlist}">
								<c:choose>
									<c:when test="${orderList.o_state=='주문완료' }">
										<tr>
											<td><img src="${cp}/shop/productimgs/${orderList.save_img_name}"></td>
											<td>${orderList.p_name}</td>
											<td>${orderList.all_sum_price}원</td>
											<td>${orderList.o_date}</td>
											<td>${orderList.o_num}</td>
											<td>${orderList.o_state}</td>
											<td></td>
										</tr>
									</c:when>
									<c:when test="${orderList.o_state=='배송완료' }">
										<tr>
											<td><img src="${cp}/shop/productimgs/${orderList.save_img_name}"></td>
											<td>${orderList.p_name}</td>
											<td>${orderList.all_sum_price}원</td>
											<td>${orderList.o_date}</td>
											<td>${orderList.o_num}</td>
											<td>${orderList.o_state}</td>
											<c:choose>
												<c:when test="${orderList.a_b_content!=null }">
												<td><span style="font-size:14px">후기작성완료</span></td>
												</c:when>
												<c:otherwise>
												<td><button onclick="location.href='${cp}/shop/mypage_orderlist_review?o_num=${orderList.o_num}'" type="button" class="btn btn-outline-dark" style="font-size:12px">후기작성</button></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
</div>
