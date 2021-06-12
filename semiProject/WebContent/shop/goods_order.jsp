<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<td><img src="${cp}/shop/productimgs/${vo.save_img_name}" style="width:200px;"></td>
						<td>${vo.p_name}</td>
						<td>${p_size}</td>
						<td>${p_count}</td>
						<td>${vo.p_price*p_count}원</td>
					</tr>
				</table>
			</div>
		
			<div class="join_wrap">
			<div class="join_box">
				<h3 class="form_title">상품주문</h3>
				
				<form action="${cp}/shop/goods_order_ok?p_num=${vo.p_num}&b_num_max=${b_num_max}&ALL_SUM_PRICE=${vo.p_price*p_count}&p_count=${p_count}&p_size=${p_size}" method="post">
				<div class="mb-3">
  				<label for="" class="form-label">수령인</label>
  				<input type="text" class="form-control" name ="rec_name" placeholder="수령인 성함을 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">연락처</label>
  				<input type="text" class="form-control" name ="rec_phone" placeholder="연락처를 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">주소</label>
  				<input type="text" class="form-control" name ="rec_addr" placeholder="주소를 입력해주세요">
  				</div>
  				<select class="form-select" aria-label="Default select example" name ="payname">
  				<option selected>결제방법</option>
 				<option value="계좌이체">계좌이체</option>
 				<option value="카드">카드</option>
				</select>
  				<div class="btn_wrap">
  				<button type="submit" class="btn btn-dark">${vo.p_price*p_count}원 주문하기</button>
  				</div>
				</form>
			</div>
			</div>
		</div>
	</div>
