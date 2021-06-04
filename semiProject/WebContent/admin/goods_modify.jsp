<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 관리자 페이지 콘텐츠 영역 -->
<div class="admin_content_wrap">
	<div class="title_wrap">
		<h3>상품수정</h3>
	</div>

	<script type="text/javascript">
		function checkData() {

			var cg_id = document.getElementsByName("cg_id")[0];
			var p_id = document.getElementsByName("p_id")[0];
			var p_name = document.getElementsByName("p_name")[0];
			var p_price = document.getElementsByName("p_price")[0];
			var p_count = document.getElementsByName("p_count")[0];

			if (cg_id.value == '카테고리(대)') {
				alert("카테고리(대) 체크하세요");
				cg_id.focus();
				return false;

			}
			if (p_id.value == '카테고리(소)') {
				alert("카테고리(소) 체크하세요");
				p_id.focus();
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

		}
	</script>
	<div class="admin_content_box">
		<div class="goods_insert">
			<form action="${cp}/admin/goods_modify_ok?p_num=${p_num}"
				method="post" onsubmit="return checkData();">
				<div class="category_wrap">
					<select class="form-select form-select-sm"
						aria-label=".form-select-sm example" id="p_id" name="p_id">
						<option selected>카테고리(대)</option>
						<option value="1">남성</option>
						<option value="2">여성</option>
					</select> <select class="form-select form-select-sm"
						aria-label=".form-select-sm example" id="cg_name" name="cg_name">
						<option selected>카테고리(소)</option>
						<option value="상의">상의</option>
						<option value="하의">하의</option>
						<option value="신발">신발</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="" class="form-label"></label> <input type="text"
						class="form-control" id="p_name" placeholder="상품명" name="p_name" >
				</div>
				<div class="mb-3">
					<label for="" class="form-label"></label> <input type="text"
						class="form-control" id="p_price" placeholder="가격" name="p_price">
				</div>
				<div class="mb-3">
					<label for="" class="form-label"></label> <input type="text"
						class="form-control" id="p_count" placeholder="수량" name="p_count">
				</div>
				<div class="input-group mb-3">
					<input type="file" class="form-control" id="save_img_name"
						name="save_img_name"> <label class="input-group-text"
						for="inputGroupFile02"></label>
				</div>
				<div class="btn_wrap">
					<button type="submit" class="btn btn-outline-dark">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
