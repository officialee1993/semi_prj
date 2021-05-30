<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>주문관리</h3>
		</div>
		<div class="admin_content_box">
		<form>
			<div class="admin_goods_menu">
				<ul>
					<!-- 카테고리 -->
					<li class="category">
						<select class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option selected>주문번호</option>
						  <option value="1">아이디</option>
						  <option value="2">주문자명</option>
						  <option value="3">주문상태</option>
						</select>
						<input class="form-control form-control-sm" type="text" placeholder="" aria-label=".form-control-sm example">
					<!-- 검색버튼 -->
						<button type="button" onclick="" class="btn btn-outline-dark catrgory_btn">검색</button>
					</li>
				</ul>
				
			</div>
		</form>

			<div class="admin_goods_list admin_order_list">
			<table>
			<!-- 제목 -->
				<tr>
					<th>주문번호</th>
					<th>아이디</th>
					<th>주문자명</th>
					<th>결제금액</th>
					<th>결제수단</th>
					<th>주문상태</th>
					<th></th>
				</tr>
				<!-- 반복문 실행(주문상태가 배송전일때) -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>입금완료</td>
					<td><button type="button" class="btn btn-outline-dark">발송</button></td>
				</tr>
				<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
								<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
												<!-- 주문상태가 배송완료일때 -->
				<tr>
					<td><a href="${cp }/admin/order_detail">20123124</a></td>
					<td>test</td>
					<td>이찬호</td>
					<td>50,000원</td>
					<td>계좌이체</td>
					<td>배송완료</td>
					<td></td>
				</tr>
				
				
			</table>
			
			<div class="goods_pagenum">
				
				<span><a href="">1</a></span>
				
			</div>
			
			</div>

		</div>
	</div>