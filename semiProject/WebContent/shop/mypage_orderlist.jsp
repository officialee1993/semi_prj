<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content">
	<div class="my_row">
		<div class="mypage">
				<div class="mypage_sidemenu">
					<h3>마이페이지</h3>
					<ul>
					<li><a href="${cp }/shop/mypage_orderlist">주문내역</a></li>
					<li><a href="${cp }/shop/mypage_reviewlist">구매후기</a></li>
					<li><a href="${cp }/shop/mypage_questionlist">문의내역</a></li>
					<li><a href="${cp }/shop/mypage_info_modify">개인정보수정</a></li>
					</ul>
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
							
							<tr>
								<td><img src="images/ex01.jpg"></td>
								<td>반팔</td>
								<td>50,000원</td>
								<td>2021.05.05</td>
								<td>652465234</td>
								<td>입금완료</td>
								<td></td>
							</tr>
							
							<tr>
								<td><img src="images/ex01.jpg"></td>
								<td>반팔</td>
								<td>50,000원</td>
								<td>2021.05.05</td>
								<td>652465234</td>
								<td>배송완료</td>
								<td><a href="${cp }/shop/mypage_orderlist_review">후기작성</a></td>
							</tr>

							<tr>
								<td><img src="images/ex01.jpg"></td>
								<td>반팔</td>
								<td>50,000원</td>
								<td>2021.05.05</td>
								<td>652465234</td>
								<td>배송완료</td>
								<td><a href="${cp }/shop/mypage_orderlist_review">후기작성</a></td>
							</tr>

						</table>
						
					</div>
				</div>
			</div>
		</div>
</div>
