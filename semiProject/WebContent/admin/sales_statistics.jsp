<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>매출통계</h3>
		</div>
		<div class="admin_content_box">
			<div class="admin_goods_list admin_order_detail">
			<div class="order_info">
				<h5>매출 통계</h5>
				<div class="sales_date">
					<button type="button" class="btn btn-outline-dark">오늘</button>
					<button type="button" class="btn btn-outline-dark">이번달</button>
					<button type="button" class="btn btn-outline-dark">올해</button>
					<!-- 날짜선택 -->
					<input type="date"><span>~</span><input type="date">
					<button type="button" class="btn btn-outline-dark">검색</button>
					<span class="sales_result">총 주문금액 : </span>
				</div>
				<table>
				<tr>
					<th>주문날짜</th>
					<th>결제금액</th>
				</tr>
				<tr>
					<td>2021.01.01</td>
					<td>50,000원</td>
				</tr>
				<tr>
					<td>2021.01.01</td>
					<td>50,000원</td>
				</tr>
				<tr>
					<td>2021.01.01</td>
					<td>50,000원</td>
				</tr>
				<tr>
					<td>2021.01.01</td>
					<td>50,000원</td>
				</tr>
				<tr>
					<td>2021.01.01</td>
					<td>50,000원</td>
				</tr>
				<tr>
					<td>2021.01.01</td>
					<td>50,000원</td>
				</tr>
				</table>
				
				<!-- 페이지번호 -->
				<div class="goods_pagenum">
				<span><a href="">1</a></span>
				</div>
				
			</div>
			

			</div>
		</div>
	</div>
    