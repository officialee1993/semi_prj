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
	<jsp:include page="header.jsp"/>
	<!-- header END -->

<!-- content -->
<div class="content">
	<div class="my_row">
		<div class="mypage">
				<div class="mypage_sidemenu">
					<h3>마이페이지</h3>
					<ul>
						<li><a href="">주문내역</a></li>
						<li><a href="">구매후기</a></li>
						<li><a href="">문의내역</a></li>
						<li><a href="">개인정보수정</a></li>
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
								<td><a href="">후기작성</a></td>
							</tr>

							<tr>
								<td><img src="images/ex01.jpg"></td>
								<td>반팔</td>
								<td>50,000원</td>
								<td>2021.05.05</td>
								<td>652465234</td>
								<td>배송완료</td>
								<td><a href="">후기작성</a></td>
							</tr>

						</table>
						
					</div>
				</div>
			</div>
		</div>
</div>
<!-- content-end -->

<!-- footer -->
<jsp:include page="footer.jsp"/>
<!-- footer-end -->
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>