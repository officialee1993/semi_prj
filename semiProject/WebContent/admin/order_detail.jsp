<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>


<div class="admin_content">

	<div class="admin_content_menu_wrap">
		<div class="logo_wrap"><img src="images/logo_org_white.png"></div>
		<div class="admin_content_menu">
		<div class="admin_content_menu_list"><a href="" id="admin_goods">상품관리</a>
		<ul class="dropdown_menu" id="dropdown_menu">
				<li><a href="">상품목록</a></li>
				<li><a href="">상품등록</a></li>
			</ul> 
		</div>
		<div class="admin_content_menu_list"><a href="">회원관리</a></div>
		<div class="admin_content_menu_list"><a href="">주문관리</a></div>
		<div class="admin_content_menu_list"><a href="">문의관리</a></div>
		<div class="admin_content_menu_list"><a href="">매출통계</a></div>
		</div>
	</div>
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
				<tr>
					<td>20123124</td>
					<td>2021.12.12</td>
					<td>50,000원</td>
					<td>입금완료</td>
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
				<tr>
					<td>test</td>
					<td>이찬호</td>
					<td>010-1234-1234</td>
					<td>서울</td>
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
				<tr>
					<td>23</td>
					<td>반팔</td>
					<td>10</td>
					<td>50,000원</td>
				</tr>
				</table>
			</div>

			</div>
		</div>
	</div>
</div>

</body>
</html>