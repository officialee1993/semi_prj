<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>상품등록</h3>
		</div>
		<script type="text/javascript">
		function checkData() {

			var p_id = document.getElementsByName("p_id")[0];
			var cg_name = document.getElementsByName("cg_name")[0];
			var p_name = document.getElementsByName("p_name")[0];
			var p_price = document.getElementsByName("p_price")[0];
			var p_count = document.getElementsByName("p_count")[0];
			var p_file = document.getElementsByName("p_file")[0];
			if (p_id.value == '카테고리(대)') {
				alert("카테고리(대) 체크하세요");
				p_id.focus();
				return false;

			}
			if (cg_name.value == '카테고리(소)') {
				alert("카테고리(소) 체크하세요");
				cg_name.focus();
				return false;

			}
			if (p_name.value.length == 0) {
				alert("상품명 체크하세요");
				p_name.focus();
				return false;

			}
			if (p_price.value.length == 0) {
				alert("가격 체크하세요");
				p_price.focus();
				return false;

			}
			if (p_count.value.length == 0) {
				alert("수량 체크하세요");
				p_count.focus();
				return false;
			}
			if (p_file.value.length == 0) {
				alert("첨부파일 체크하세요");
				p_file.focus();
				return false;
			}

		}
	</script>
		<div class="admin_content_box">
			<div class="goods_insert">
				<!-- 상품등록 폼 -->
				<form method="post" action="${pageContext.request.contextPath}/admin/goods_insert" enctype="multipart/form-data" onsubmit="return checkData();" >
				<!-- 카테고리 -->
				<div class="category_wrap">
				<select name ="p_id" class="form-select form-select-sm" aria-label=".form-select-sm example" >
				  <option selected>카테고리(대)</option>
				  <option value="1">남성</option>
				  <option value="2">여성</option>
				</select>
				<select name ="cg_name"  class="form-select form-select-sm" aria-label=".form-select-sm example" >
				  <option selected>카테고리(소)</option>
				  <option value="상의">상의</option>
				  <option value="하의">하의</option>
				  <option value="신발">신발</option>
				</select>
				</div>
				<!-- 상품정보 -->
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input name ="p_name" type="text" class="form-control" id="" placeholder="상품명"  >
				</div>
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input name ="p_price" type="text" class="form-control" id="" placeholder="가격" >
				</div>
				<div class="mb-3">
				  <label for="" class="form-label"></label>
				  <input name ="p_count" type="text" class="form-control" id="" placeholder="수량" >
				</div>
				<div class="input-group mb-3">
				  <input name ="p_file" type="file" class="form-control" id="inputGroupFile02" >
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
