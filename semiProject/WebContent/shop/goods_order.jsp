<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="content">
		<div class="my_row">
			<div class="goods_order_detail">
				<table>
					<tr>
						<th style="width:40%"></th>
						<th style="width:30%">상품명</th>
						<th style="width:10%">사이즈</th>
						<th style="width:10%">수량</th>
						<th style="width:10%">가격</th>
					</tr>
					<tr>
						<td><img src="images/ex01.jpg" style="width:200px;"></td>
						<td>제품명</td>
						<td>사이즈</td>
						<td>수량</td>
						<td>가격</td>
					</tr>
				</table>
			</div>
		
			<div class="join_wrap">
			<div class="join_box">
				<h3 class="form_title">상품주문</h3>
				<form action="" method="">
				<div class="mb-3">
  				<label for="" class="form-label">수령인</label>
  				<input type="text" class="form-control" id="" placeholder="수령인 성함을 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">연락처</label>
  				<input type="password" class="form-control" id="" placeholder="연락처를 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">주소</label>
  				<input type="text" class="form-control" id="" placeholder="주소를 입력해주세요">
  				</div>
  				<select class="form-select" aria-label="Default select example">
  				<option selected>결제방법</option>
 				<option value="1">계좌이체</option>
 				<option value="2">카드</option>
				</select>
  				<div class="btn_wrap">
  				<button type="submit" class="btn btn-dark">50,000원 주문하기</button>
  				</div>
				</form>
			</div>
			</div>
		</div>
	</div>
