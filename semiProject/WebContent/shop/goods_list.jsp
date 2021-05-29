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
<!-- header-end -->

<!-- content -->
<div class="content">
	<div class="my_row">
		<div class="goods_list">
			<h3>남성</h3>
			<div class="goods_list_box">
				<ul class="goods_list_box_category">
					<li><a href="">상의</a></li>
					<li><a href="">하의</a></li>
					<li><a href="">신발</a></li>
					<li>
					<select class="form-select form-select-sm" aria-label=".form-select-sm example">
					  <option selected>신상품순</option>
					  <option value="1">낮은 가격순</option>
					  <option value="2">높은 가격순</option>
					</select>
					</li>
				</ul>
				<div class="goods_list_imgbox_wrap">
					<!-- 반복문에 들어갈 엘리먼트 -->
					<div class="goods_list_imgbox">
						<div><a href=""><img src="images/ex01.jpg"></a></div>
						<a href="" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>

					<div class="goods_list_imgbox">
						<div><a href=""><img src="images/ex01.jpg"></a></div>
						<a href="" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>					<div class="goods_list_imgbox">
						<div><a href=""><img src="images/ex01.jpg"></a></div>
						<a href="" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>					<div class="goods_list_imgbox">
						<div><a href=""><img src="images/ex01.jpg"></a></div>
						<a href="" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>					<div class="goods_list_imgbox">
						<div><a href=""><img src="images/ex01.jpg"></a></div>
						<a href="" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>


				</div>
			</div>
		</div>
	</div>
</div>
<!-- content -->

<!-- footer -->
<jsp:include page="footer.jsp"/>
<!-- footer-end -->
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>