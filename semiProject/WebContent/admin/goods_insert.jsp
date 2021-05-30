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
				<li><a href="">상품등록</a></li>
				<li><a href="">상품조회</a></li>
			</ul>
		</div>
		<div class="admin_content_menu_list"><a href="">회원관리</a></div>
		<div class="admin_content_menu_list"><a href="">주문관리</a></div>
		<div class="admin_content_menu_list"><a href="">문의관리</a></div>
		<div class="admin_content_menu_list"><a href="">매출통계</a></div>
		</div>
	</div>


</div>

<script type="text/javascript">

	document.getElementById("admin_goods").addEventListener('mouseover',function(){
		document.getElementById("dropdown_menu").style.display='block';
	})
	document.getElementById("dropdown_menu").addEventListener('mouseleave',function(){
		document.getElementById("dropdown_menu").style.display='none';
	})

</script>
</body>
</html>