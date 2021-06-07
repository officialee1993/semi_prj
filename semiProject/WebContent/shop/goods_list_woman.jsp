<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- content -->
<div class="content">
	<div class="my_row">
		<div class="goods_list">
			<h3>여성</h3>
			<div class="goods_list_box">
				<ul class="goods_list_box_category">
					<li><a href="${cp }/shop/goods_list_women_under?cg_id=${3}">상의</a></li>
					<li><a href="${cp }/shop/goods_list_women_under?cg_id=${4}">하의</a></li>
					<li><a href="${cp }/shop/goods_list_women_under?cg_id=${5}">신발</a></li>
					<li>
					<select class="form-select form-select-sm" aria-label=".form-select-sm example" onchange="if(this.value) location.href=(this.value);">
					  <option disabled selected values> -- 정렬 -- </option>
					  <option value="${cp }/shop/goods_list_new">신상품순</option>
					  <option value="${cp }/shop/goods_list_low">낮은 가격순</option>
					  <option value="${cp }/shop/goods_list_high">높은 가격순</option>
					</select>
					</li>
				</ul>
				<div class="goods_list_imgbox_wrap">
				
					<c:forEach var="vo" items="${wo_list_all }">
						<div class="goods_list_imgbox">
							<div><a href="${cp }/shop/goods_detail"><img src="${cp }/shop/productimgs/${vo.save_img_name }"></a></div>
							<a href="${cp }/shop/goods_detail" class="textbox">
							<span class="title">${vo.p_name }</span>
							<span class="price">${vo.p_price }원</span>
							</a>
						</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- content -->
