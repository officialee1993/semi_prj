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
<div class="container_wrap">
	<div class="header">
	<div class="my_row">
		<div class="header_box">
			<div class="logo">
			<img src="images/logo2.png"/>
			</div>
			<div class="header_menu" id="header_menu">
			<ul>
				<li><a href="">신상품</a></li>
				<li><a href="">남성</a></li>
				<li><a href="">여성</a></li>
			</ul>
			</div>
		<div class="btn_wrap">
			<a href="">로그인</a>
			<a href="">회원가입</a>
		</div>
		</div>
		</div>
		<div class="menu_dropdown" id="menu_dropdown">
					<ul>
					<li><a href="">신상품</a></li>
					</ul>
					<ul>
					<li><a href="">상의</a></li>
					<li><a href="">하의</a></li>
					<li><a href="">신발</a></li>
					</ul>
					<ul>
					<li><a href="">상의</a></li>
					<li><a href="">하의</a></li>
					<li><a href="">신발</a></li>
					</ul>
			</div>
	</div>
	<!-- header END -->
	<div class="content">
		<div class="my_row">
		<!-- 주문상세내역 -->
			<div class="goods_cart">
				<h3>장바구니</h3>
				<div class="goods_cart_list">
				<form action="">
					<table>
						<tr>
							<th></th>
							<th>상품명</th>
							<th>가격</th>
							<th>수량</th>
							<th>주문금액</th>
							<th></th>
						</tr>
						<tr>
							<td style=""><img src="images/ex01.jpg" style="width:100px;"></td>
							<td>반팔</td>
							<td>가격</td>
							<td><input type="number" class="form-control" min="0" placeholder="0" style="width:50px;height:20px;margin:0 auto;"></td>
							<td>10,000원</td>
							<td><a href="">삭제</a></td>
						</tr>
					</table>
					<div class="btn_wrap">
						<button type="submit" class="btn btn-dark">주문하기</button>
					</div>
				</form>
				</div>
			</div>
			</div>
			</div>
	<!-- footer -->
	<div class="footer footer_bottom">
		<p>All Rights Reserved</p>
	</div>
	</div>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>