<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>상품목록</h3>
		</div>
		<div class="admin_content_box">
			<div class="admin_goods_menu">
				<ul>
					<li><a class="menu_btn" href="">남성</a></li>
					<li><a class="menu_btn" href="">여성</a></li>
					<!-- ajax로 ? -->
					<li class="category">
						<select class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option selected>카테고리</option>
						  <option value="1">ALL</option>
						  <option value="2">상의</option>
						  <option value="3">하의</option>
						  <option value="4">신발</option>
						</select>
						<input id="" class="form-control form-control-sm" type="text" placeholder="검색어를 입력해주세요" aria-label=".form-control-sm example">
						<button type="button" onclick="" class="btn btn-outline-dark catrgory_btn">검색</button>
					</li>
				</ul>
			</div>
			<div class="admin_goods_list">
			<table>
				<tr>
					<th><!-- 상품이미지 열 --></th>
					<th>상품명</th>
					<th>가격</th>
					<th>재고</th>
					<th>생성일</th>
					<th>조회수</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
		<c:forEach var="vo" items="${list}">
				<tr>
					<td><img src="${cp}/shop/productimgs/${vo.save_img_name}" width="80px;" style="vertical-aling:middle"></td>
					<td>${vo.cg_name}</td>
					<td>${vo.p_price}원</td>
					<td>${vo.p_count}</td>
					<td>${vo.p_date}</td>
					<td>${vo.p_click_num}</td>
					<td><button onclick="location.href='${cp}/admin/goods_modify?p_num=${vo.p_num}'" type="button" class="btn btn-outline-dark">수정</button></td>
					<td><button onclick="location.href='${cp}/admin/goods_delete?p_num=${vo.p_num}'" type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
		</c:forEach>
			</table>
			
			<div class="goods_pagenum">
				
				<span><a href="">1</a></span>
				
			</div>
			
			</div>

		</div>
	</div>
<script>

</script>