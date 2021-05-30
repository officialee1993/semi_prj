<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>상품수정</h3>
		</div>
		<div class="admin_content_box">
			<div class="goods_insert">
				<form action="" method="">
				<div class="category_wrap">
				<select class="form-select form-select-sm" aria-label=".form-select-sm example">
				  <option selected>카테고리(대)</option>
				  <option value="1">남성</option>
				  <option value="2">여성</option>
				</select>
				<select class="form-select form-select-sm" aria-label=".form-select-sm example">
				  <option selected>카테고리(소)</option>
				  <option value="1">상의</option>
				  <option value="2">하의</option>
				  <option value="3">신발</option>
				</select>
				</div>
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input type="text" class="form-control" id="" placeholder="상품명">
				</div>
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input type="text" class="form-control" id="" placeholder="가격">
				</div>
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input type="text" class="form-control" id="" placeholder="수량">
				</div>
				<div class="input-group mb-3">
				  <input type="file" class="form-control" id="inputGroupFile02">
				  <label class="input-group-text" for="inputGroupFile02"></label>
				</div>
				<div class="btn_wrap">
					<button type="button" class="btn btn-outline-dark">등록</button>
				</div>
				</form>
			</div>
		</div>
	</div>
