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
	<div class="content">
		<div class="my_row">
		<!-- 상품설명 -->
			<div class="detail_box">
				<div class="left_box">
					<img src="images/ex01.jpg">
				</div>
				<form class="right_box" action="" method="">
				<div class="text_box">
					<h4>제품명</h4>
					<h5 style="margin-top:50px;">가격</h5>
					<p>50,000원</p>
					<input type="number" class="form-control" min="0" placeholder="수량">
					<select name="" class="form-select form-select-sm" aria-label=".form-select-sm example">
					  <option selected>사이즈</option>
					  <option value="1">M</option>
					  <option value="2">L</option>
					  <option value="3">XL</option>
					</select>
				</div>
				<div class="btn_box">
					<button type="submit" formaction="" class="btn btn-outline-dark">구매하기</button>
					<button type="submit" formaction="" class="btn btn-dark" style="margin-left:10px">장바구니</button>
				</div>
				</form>
			</div>
		<!-- 상품설명 END -->
		<!-- 후기 게시판 -->
		<div class="board review_board">
			<h3>상품후기</h3>
			<table class="table table-striped table-hover" style="font-size:14px;">
			<tr style="text-align:center;border-bottom:1px solid #222;">
				<th scope="col" style="width:10%;">분류</th>
				<th scope="col" style="width:15%;">작성자</th>
				<th scope="col" style="width:55%;">제목</th>
				<th scope="col" style="width:20%;">작성일</th>
			</tr>
			<!-- 반복문 시작 -->
			<tr style="text-align:center;">
				<td>후기</td>
				<td>이찬호</td>
				<td>
				<a id="review_title" href="">제목
				</a>
				<div class="board_content review_content"><p>시들어 이는 모래뿐일 관현악이며, 같은 원대하고, 봄바람이다. 영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. 꽃이 생생하며, 밝은 그들은 꽃 바이며, 낙원을 어디 것이다. 할지니, 청춘을 충분히 열락의 새가 힘차게 두기 방지하는 끓는다. 밝은 듣기만 구하지 가진 것이 없으면 끓는 용기가 동력은 사막이다. 들어 청춘에서만 인간이 타오르고 찾아 노래하며 끓는 것이다. 영락과 청춘을 보이는 뿐이다.</p>
				
				<div class="comment_list review_comment_list">
				<!-- 댓글입력시 추가될 div className -->
				<div class="comment_box review_comment_box">
				<p class="writer">작성자</p>
				<span class="content">영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. </span>
				</div>
				
				<div class="comment_box review_comment_box">
				<p class="writer">작성자</p>
				<span class="content">영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. </span>
				</div>
				<!-- 댓글입력시 추가될 div className 끝 -->
				</div>
				<!-- 댓글 입력폼 -->
				<div class="mb-3" style="display:flex">
  				<label for="" class="form-label"></label>
  				<textarea class="form-control" id="" rows="1"></textarea>
  				<button type="button" class="btn btn-secondary" style="width:70px;margin-left:10px;">등록</button>
				</div>
				<!-- 댓글 입력폼 끝 -->
				</div>
				</td>
				<td>2021-05-28</td>
				
			</tr>
			<!-- 반복문 종료 -->
			<tr style="text-align:center;">
				<td>후기</td>
				<td>이찬호</td>
				<td>
				<a id="review_title" href="">제목
				</a>
				<div class="review_content"></div>
				</td>
				<td>2021-05-28</td>
			</tr>
			</table>
			<!-- 후기 게시판 페이징 번호 -->
			<div class="board_page review_board_page">
			<span>이전</span>
			<span>1</span>
			<span>다음</span>
			</div>
		</div>
		<!-- 후기 게시판 END -->
		<!-- 문의 게시판 -->
		<div class="board question_board">
			<h3>문의게시판</h3>
			<table class="table table-striped table-hover" style="font-size:14px;">
			<tr style="text-align:center;border-bottom:1px solid #222;">
				<th scope="col" style="width:10%;">분류</th>
				<th scope="col" style="width:15%;">작성자</th>
				<th scope="col" style="width:55%;">제목</th>
				<th scope="col" style="width:20%;">작성일</th>
			</tr>
			<!-- 반복문 시작 -->
			<tr style="text-align:center;">
				<td>문의</td>
				<td>이찬호</td>
				<td>
				<a id="review_title" href="">제목
				</a>
				<div class="board_content review_content"><p>시들어 이는 모래뿐일 관현악이며, 같은 원대하고, 봄바람이다. 영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. 꽃이 생생하며, 밝은 그들은 꽃 바이며, 낙원을 어디 것이다. 할지니, 청춘을 충분히 열락의 새가 힘차게 두기 방지하는 끓는다. 밝은 듣기만 구하지 가진 것이 없으면 끓는 용기가 동력은 사막이다. 들어 청춘에서만 인간이 타오르고 찾아 노래하며 끓는 것이다. 영락과 청춘을 보이는 뿐이다.</p>
				<div class="comment_list question_comment_list">
				<!-- 댓글입력시 추가될 div className -->
				<div class="comment_box question_comment_box">
				<p class="writer">작성자</p>
				<span class="content">영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. </span>
				</div>
				
				<div class="comment_box question_comment_box">
				<p class="writer">작성자</p>
				<span class="content">영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. </span>
				</div>
				<!-- 댓글입력시 추가될 div className 끝 -->
				</div>
				<!-- 댓글 입력폼 -->
				<div class="mb-3" style="display:flex">
  				<label for="" class="form-label"></label>
  				<textarea class="form-control" id="" rows="1"></textarea>
  				<button type="button" class="btn btn-secondary" style="width:70px;margin-left:10px;">등록</button>
				</div>
				<!-- 댓글 입력폼 끝 -->
				</div>
				</td>
				<td>2021-05-28</td>
			</tr>
			<!-- 반복문 종료 -->
			<tr style="text-align:center;">
				<td>문의</td>
				<td>이찬호</td>
				<td>
				<a id="review_title" href="">제목
				</a>
				<div class="review_content"></div>
				</td>
				<td>2021-05-28</td>
			</tr>
			
			</table>
			<!-- 문의 게시판 페이징 번호 -->
			<div class="board_page question_board_page">
			<span>이전</span>
			<span>1</span>
			<span>다음</span>
			<button class="btn btn-dark" id="question_write" data-bs-toggle="modal" data-bs-target="#question_modal" type="button">작성하기</button>
			</div>
		</div>
		<!-- 문의 게시판 END -->
		</div>
	</div>
	
	<!-- 문의글 쓰기 폼 -->
	<form method="post" action="">
		<div class="modal fade" id="question_modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
    	<div class="modal-content">
      	<div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">상품문의</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      	</div>
      	<div class="modal-body">
      	<select class="form-select form-select-sm" aria-label=".form-select-sm example">
  		<option selected>문의유형</option>
  		<option value="1">상품문의</option>
  		<option value="2">배송문의</option>
  		<option value="3">기타문의</option>
		</select>
		<div class="mb-3">
  		<label for="" class="form-label"></label>
  		<input type="text" class="form-control" id="" placeholder="제목을 입력해주세요">
		</div>
		<div class="mb-3">
  		<label for="" class="form-label"></label>
  		<input type="password" class="form-control" id="" placeholder="비밀번호를 입력해주세요">
		</div>
		<div class="mb-3">
  		<label for="" class="form-label"></label>
  		<textarea class="form-control" id="" rows="10"></textarea>
		</div>
      	</div>
      	<!-- 문의글 쓰기 버튼영역 -->
      	<div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="submit" class="btn btn-primary">등록</button>
      	</div>
    	</div>
 		</div>
		</div>
	</form>
	<!-- footer -->
	<div class="footer">
		<p>All Rights Reserved</p>
	</div>
	</div>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>