<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="content">
		<div class="my_row">
			<div class="join_wrap">
			<div class="join_box">
				<h3 class="form_title">회원가입</h3>
				<form action="${cp}/shop/join" method="post">
				<div class="mb-3">
  				<label for="" class="form-label">아이디</label>
  				<input type="text" class="form-control" name="id" placeholder="~자 이상의 영문과 숫자를 조합">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">비밀번호</label>
  				<input type="password" class="form-control" name="pwd" placeholder="비밀번호를 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">이름</label>
  				<input type="text" class="form-control" name="name" placeholder="이름을 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">주소</label>
  				<input type="text" class="form-control" name="address" placeholder="주소를 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">이메일</label>
  				<input type="email" class="form-control" name="email" placeholder="이메일을 입력해주세요">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">전화번호</label>
  				<input type="text" class="form-control" name="phone" placeholder="전화번호를 입력해주세요">
  				</div>
  				<div class="btn_wrap">
  				<button type="submit" class="btn btn-dark">가입하기</button>
  				</div>
				</form>
			</div>
			</div>
		</div>
	</div>
