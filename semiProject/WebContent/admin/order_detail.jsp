<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>주문상세</h3>
		</div>
		<div class="admin_content_box">
			<div class="admin_goods_list admin_order_detail">
			<div class="order_info">
				<h5>주문 정보</h5>
				<table>
				<tr>
					<th>주문번호</th>
					<th>주문날짜</th>
					<th>결제금액</th>
					<th>주문상태</th>
				</tr>
				<tr style="background-color:#fdfdfd;">
					<td>${vo.o_num }</td>
					<td>${vo.o_date }</td>
					<td>${vo.all_sum_price }</td>
					<td>${vo.o_state }</td>
				</tr>
				</table>
			</div>
			
			<div class="orderer_info">
				<h5>주문자 정보</h5>
				<table>
				<tr>
					<th>아이디</th>
					<th>주문자명</th>
					<th>연락처</th>
					<th>배송지 주소</th>
				</tr>
				<tr style="background-color:#fdfdfd;">
					<td>${vo.id }</td>
					<td>${vo.rec_name }</td>
					<td>${vo.rec_phone }</td>
					<td>${vo.rec_addr }</td>
				</tr>
				</table>
			</div>

			<div class="goods_info">
				<h5>상품 정보</h5>
				<table>
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>수량</th>
					<th>상품금액</th>
				</tr>
				<tr style="background-color:#fdfdfd;">
					<td>${vo.p_num }</td>
					<td>${vo.p_name }</td>
					<td>${vo.p_count }</td>
					<td>${vo.p_price }</td>
				</tr>
				</table>
			</div>

			</div>
		</div>
	</div>
