<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="content">
		<div class="my_row">
			<div class="mypage">
				<div class="mypage_sidemenu">
					<h3>마이페이지</h3>
					<jsp:include page="${sidemenu }"/>
				</div>
				<div class="mypage_orderlist">
					<h3>후기작성</h3>
					<div class="mypage_reviewform" style="margin-top:20px;">
						<form method="post" action="${pageContext.request.contextPath }/shop/mypage_orderlist_review">
						<input name="o_num" type="hidden" value="${o_num }">
						<div class="mb-3">
  							<label for="" class="form-label"></label>
  							<input name="reviewTitle" type="text" class="form-control" id="" placeholder="제목">
						</div>
						<div class="mb-3">
						  	<label for="" class="form-label"></label>
						  	<textarea name="reviewContent" class="form-control" id="" rows="5" placeholder="후기를 작성해주세요"></textarea>
						</div>
						<div class="btn_wrap" style="text-align:center;">
							<button type="submit" class="btn btn-dark" style="width:100px;">등록</button>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
