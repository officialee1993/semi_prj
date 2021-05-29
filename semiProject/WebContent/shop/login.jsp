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
			<div class="login_box">
				<h3 class="form_title">로그인</h3>
				
				<form class="login_insert" method="post" action="${pageContext.request.contextPath}/login">
				<div class="mb-3">
				  <label for="" class=""></label>
				  <input name="id" type="text" class="form-control" id="asd" placeholder="아이디를 입력해주세요">
				  <label for="" class=""></label>
				  <input name="pwd" type="password" class="form-control" id="zxc" placeholder="비밀번호를 입력해주세요">
				</div>
				<div class="login_search_box">
					<a href="">아이디 찾기</a>
					<a href="">비밀번호 찾기</a>
				</div>
				<button type="submit" class="btn btn-dark">로그인</button>
				</form>
				
				<button type="button" class="btn btn-light">회원가입</button>
				
			</div>
		</div>
	</div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>