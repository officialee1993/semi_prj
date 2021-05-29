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
<div>
<jsp:include page="${top }"/>
</div>

	<!-- header END -->
	<div class="banner">
		<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
  		<div class="carousel-inner">
    	<div class="carousel-item active" data-bs-interval="10000">
     	 <img src="images/banner7.png" class="d-block w-100" alt="">
   		 </div>
   		 <div class="carousel-item" data-bs-interval="2000">
   		   <img src="images/banner8.png" class="d-block w-100" alt="">
   		 </div>
   		 <div class="carousel-item">
   		   <img src="images/banner9.png" class="d-block w-100" alt="">
  		  </div>
 		 </div>
  		<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
  		  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
  		  <span class="visually-hidden">Previous</span>
  		</button>
  		<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
  		  <span class="carousel-control-next-icon" aria-hidden="true"></span>
  		  <span class="visually-hidden">Next</span>
 		 </button>
		</div>
	</div>
	<div class="content">
		<div class="my_row">
			<div class="item_box">
				<div class="title">
					<p>New Product</p>
				</div>
				<ul>
					<li>
						<a href="">
						<img src="images/ex01.jpg">
						</a>
						<div class="text_box">
						<a href="" class="price">[남성]셔츠1</a>
						<p class="price">10,000원</p>
						</div>
					</li>
					<li>
						<a href="">
						<img src="images/ex01.jpg">
						</a>
						<div class="text_box">
						<a href="" class="price">[남성]셔츠1</a>
						<p class="price">10,000원</p>
						</div>
					</li>
					<li>
						<a href="">
						<img src="images/ex01.jpg">
						</a>
						<div class="text_box">
						<a href="" class="price">[남성]셔츠1</a>
						<p class="price">10,000원</p>
						</div>
					</li>
					<li>
						<a href="">
						<img src="images/ex01.jpg">
						</a>
						<div class="text_box">
						<a href="" class="price">[남성]셔츠1</a>
						<p class="price">10,000원</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div>
	<jsp:include page="${footer }"/>
	</div>



<script type="text/javascript" src="js/main.js"></script>
</body>
</html>