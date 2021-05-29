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
<!-- header -->
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
	<!-- content -->
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



	<!-- footer -->
	<div class="footer">
		<p>All Rights Reserved</p>
	</div>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>