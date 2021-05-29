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

			<jsp:include page="header.jsp"/>

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
	<jsp:include page="footer.jsp"/>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>