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
					<h3>후기작성</h3>
					<div class="mypage_reviewform" style="margin-top:20px;">
					
						<form>
						    <select class="form-select form-select-sm" aria-label=".form-select-sm example">
					  			<option selected>후기유형</option>
					  			<option value="1">일반후기</option>
					  			<option value="2">????</option>
					  			<option value="3">????</option>
							</select>
						<div class="mb-3">
  							<label for="" class="form-label"></label>
  							<input type="text" class="form-control" id="" placeholder="아이디">
						</div>
						<div class="mb-3">
						  	<label for="" class="form-label"></label>
						  	<textarea class="form-control" id="" rows="5" placeholder="후기를 작성해주세요"></textarea>
						</div>
						<div class="btn_wrap" style="text-align:center;">
							<button type="button" class="btn btn-dark" style="width:100px;">등록</button>
						</div>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>


<!-- footer -->
<jsp:include page="footer.jsp"/>
<!-- footer-end -->
</body>
</html>