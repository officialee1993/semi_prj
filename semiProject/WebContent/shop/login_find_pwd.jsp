<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="content">
		<div class="my_row">
			<div class="login_box">
				<h3 class="form_title">비밀번호 찾기</h3>
				<form class="login_insert" method="post" action="${cp}/shop/login_find_pwd">
				<div class="mb-3">
				  <label for="" class=""></label>
				  <input name="id" type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요">
				  <label for="" class=""></label>
				  <input name="email" type="email" class="form-control" id="email" placeholder="이메일을 입력해주세요">
				</div>
				<button type="submit" class="btn btn-dark">찾기</button>
				</form>
			</div>
		</div>
	</div>
