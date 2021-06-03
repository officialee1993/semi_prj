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
							
							<c:forEach var="vo" items="${requestScope.list}">
							
								<tr>
							
								<td><img src="${cp}/shop/productimgs/${vo.save_img_name}"></td>
								<td>${vo.cg_name}</td>
								<td>${vo.all_sum_price}원</td>
								<td>${vo.o_date}</td>
								<td>${vo.o_num}</td>
								<td>${vo.o_state}</td>
								<td></td>
							</tr>
							
							</c:forEach>
							
					
							
						
						</table>
						
					</div>
				</div>
			</div>
		</div>
</div>
