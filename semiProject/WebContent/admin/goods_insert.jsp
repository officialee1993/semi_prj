<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>상품등록</h3>
		</div>
		<div class="admin_content_box">
			<div class="goods_insert">
				<!-- 상품등록 폼 -->
				<form method="post" action="${pageContext.request.contextPath}/admin/goods_insert" enctype="multipart/form-data">
				<!-- 카테고리 -->
				<div class="category_wrap">
				<select name ="cgb_num" class="form-select form-select-sm" aria-label=".form-select-sm example">
				  <option selected>카테고리(대)</option>
				  <option value="1">남성</option>
				  <option value="2">여성</option>
				</select>
				<select name ="cgs_name"  class="form-select form-select-sm" aria-label=".form-select-sm example">
				  <option selected>카테고리(소)</option>
				  <option value="상의">상의</option>
				  <option value="하의">하의</option>
				  <option value="신발">신발</option>
				</select>
				</div>
				<!-- 상품정보 -->
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input name ="p_name" type="text" class="form-control" id="" placeholder="상품명">
				</div>
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input name ="p_price" type="text" class="form-control" id="" placeholder="가격">
				</div>
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input name ="p_count" type="text" class="form-control" id="" placeholder="수량">
				</div>
				<div class="input-group mb-3">
				  <input name ="p_file" type="file" class="form-control" id="inputGroupFile02">
				  <label class="input-group-text" for="inputGroupFile02"></label>
				</div>
				<!-- 등록버튼 -->
				<div class="btn_wrap">
					<button type="submit" class="btn btn-outline-dark">등록</button>
				</div>
				</form>
			</div>
		</div>
	</div>
