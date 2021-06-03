<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>문의상세</h3>
		</div>
		<div class="admin_content_box">
			<div class="goods_insert question_detail">
				<!-- 입력폼 -->
				<form action="${cp}/admin/question_detail" method="post">
				<input name="qnum" type="hidden" value="${vo.q_b_num }">
				<div class="mb-3">
			    <label for="" class="col-sm-2 col-form-label"></label>
			    <div class="col-sm-10">
			     <input type="text" readonly class="form-control-plaintext" id="" value="${vo.q_b_category }">
			   	</div>
			 	</div>
				<div class="mb-3">
			    <label for="" class="col-sm-2 col-form-label"></label>
			    <div class="col-sm-10">
			     <input type="text" readonly class="form-control-plaintext" id="" value="${vo.id }">
			   	</div>
			 	</div>
			 	<div class="mb-3">
			    <label for="" class="col-sm-2 col-form-label"></label>
			    <div class="col-sm-10">
			     <input type="text" readonly class="form-control-plaintext" id="" value="${vo.q_b_title }">
			   	</div>
			 	</div>
			 	<div class="mb-3">
				<label for="" class="form-label"> </label>
				<textarea readonly class="form-control-plaintext" class="form-control" id="" rows="7">
				${vo.q_b_content }
				</textarea>
				</div>
				<div class="btn_wrap">
				<c:choose>
					<c:when test="${vo.q_b_state=='답변대기' }">
					<div class="mb-3">
				 	<label for="" class="form-label"></label>
					<textarea name="answer" class="form-control" id="" rows="3">${vo.q_a_content }</textarea>
					</div>
					</c:when>
					<c:otherwise>
					<div class="mb-3">
				 	<label for="" class="form-label"></label>
					<textarea name="answer" readonly class="form-control-plaintext" id="" rows="3">${vo.q_a_content }</textarea>
					</div>
					</c:otherwise>
				</c:choose>

				<button type="submit" class="btn btn-outline-dark">등록</button>
				</div>
				</form>
				<!-- 상품데이터 -->
				<div class="question_detail_goodsinfo">
				
				<table>
				<tr>
					<th><!-- empty --></th>
					<th>상품명</th>
					<th>가격</th>
					<th>재고</th>

				</tr>
				<tr>
					<td><img src="${cp}/shop/productimgs/${vo.save_img_name}" width="200px;" style="vertical-aling:middle"></td>
					<td>${vo.p_name }</td>
					<td>${vo.p_price }</td>
					<td>${vo.p_count }</td>
				</tr>
				</table>
				</div>
			</div>
			
			
			
			
			
			
			
			
		</div>
	</div>
