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
			<h3>상품목록</h3>
		</div>
		<div class="admin_content_box">
			<div class="admin_goods_menu">
				<ul>
					<li><a class="menu_btn" href="">남성</a></li>
					<li><a class="menu_btn" href="">여성</a></li>
					<!-- ajax로 ? -->
					<li class="category">
						<select class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option selected>카테고리</option>
						  <option value="1">ALL</option>
						  <option value="2">상의</option>
						  <option value="3">하의</option>
						  <option value="4">신발</option>
						</select>
						<input id="" class="form-control form-control-sm" type="text" placeholder="검색어를 입력해주세요" aria-label=".form-control-sm example">
						<button type="button" onclick="" class="btn btn-outline-dark catrgory_btn">검색</button>
					</li>
				</ul>
			</div>
			<div class="admin_goods_list">
			<table>
				<tr>
					<th><!-- 상품이미지 열 --></th>
					<th>상품명</th>
					<th>가격</th>
					<th>재고</th>
					<th>생성일</th>
					<th>조회수</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><a href="">수정</a></td>
					<td><a href="">삭제</a></td>
				</tr>
				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><a href="">수정</a></td>
					<td><a href="">삭제</a></td>
				</tr>
				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><a href="">수정</a></td>
					<td><a href="">삭제</a></td>
				</tr>
				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><a href="">수정</a></td>
					<td><a href="">삭제</a></td>
				</tr>
				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><a href="">수정</a></td>
					<td><a href="">삭제</a></td>
				</tr>
				
			</table>
			
			<div class="goods_pagenum">
				
				<span><a href="">1</a></span>
				
			</div>
			
			</div>

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