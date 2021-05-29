<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="content">
		<div class="my_row">
			<div class="login_box">
				<h3 class="form_title">로그인</h3>
				
				<form class="login_insert" method="post" action="${cp}/shop/login">
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
