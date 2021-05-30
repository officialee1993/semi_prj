<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="content">
		<div class="my_row">
			<div class="mypage">
				<div class="mypage_sidemenu">
					<h3>마이페이지</h3>
					<ul>
					<li><a href="${cp }/shop/mypage_orderlist">주문내역</a></li>
					<li><a href="${cp }/shop/mypage_reviewlist">구매후기</a></li>
					<li><a href="${cp }/shop/mypage_questionlist">문의내역</a></li>
					<li><a href="${cp }/shop/mypage_info_modify">개인정보수정</a></li>
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
  							<input type="text" class="form-control" id="" placeholder="이름">
						</div>
						<div class="mb-3">
  							<label for="" class="form-label"></label>
  							<input type="text" class="form-control" id="" placeholder="제목">
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
