<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content">
	<div class="my_row">
		<div class="mypage">
			<!-- 사이드메뉴 -->
			<div class="mypage_sidemenu">
				<h3>마이페이지</h3>
				<ul>
					<li><a href="${cp }/shop/mypage_orderlist">주문내역</a></li>
					<li><a href="${cp }/shop/mypage_reviewlist">구매후기</a></li>
					<li><a href="${cp }/shop/mypage_questionlist">문의내역</a></li>
					<li><a href="${cp }/shop/mypage_info_modify">개인정보수정</a></li>
				</ul>
			</div>
			<!-- 프로필 수정 -->
			<div class="mypage_orderlist">
				<h3>개인정보수정</h3>
					<!-- 비밀번호 확인 -->
					<form class="mypage_password_check">
					<div class="mb-3">
					  <label for="" class="form-label"></label>
					  <input type="password" class="form-control" id="" placeholder="비밀번호를 입력해주세요">
					</div>
					<button type="button" class="btn btn-outline-dark">확인</button>
					</form>
					<!-- 회원정보 수정(비밀번호 인증시 보임) -->
					<div class="mypage_info_modify">
					<form action="" method="post">
					<div class="mb-3">
	  				<label for="" class="form-label">아이디</label>
	  				<input type="text" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">비밀번호</label>
	  				<input type="password" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">이름</label>
	  				<input type="text" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">주소</label>
	  				<input type="text" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">이메일</label>
	  				<input type="email" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">전화번호</label>
	  				<input type="text" class="form-control">
	  				</div>
	  				<div class="btn_wrap">
	  				<button type="submit" class="btn btn-outline-dark">수정</button>
	  				</div>
					</form>
					</div>
			</div>
		</div>
	</div>
</div>
