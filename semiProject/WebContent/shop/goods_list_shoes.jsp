<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- content -->
<div class="content">
	<div class="my_row">
		<div class="goods_list">
			<h3>신상품</h3>
			<div class="goods_list_box">
				<ul class="goods_list_box_category">
					<li><a href="${cp }/shop/goods_list_top?cg_id=3&cg_id1=6">상의</a></li>
					<li><a href="${cp }/shop/goods_list_bottom?cg_id=4&cg_id1=7">하의</a></li>
					<li><a href="${cp }/shop/goods_list_shoes?cg_id=5&cg_id1=8">신발</a></li>
					<li><select class="form-select form-select-sm"
						aria-label=".form-select-sm example"
						onchange="if(this.value) location.href=(this.value);">
							<option disabled selected values>-- 정렬 --</option>
							<option value="${cp }/shop/goods_list_shoes?cg_id=5&cg_id1=8&order=1">신상품순</option>
							<option value="${cp }/shop/goods_list_shoes?cg_id=5&cg_id1=8&order=2">낮은 가격순</option>
							<option value="${cp }/shop/goods_list_shoes?cg_id=5&cg_id1=8&order=3">높은 가격순</option>
					</select>
					</li>
				</ul>
				<div class="goods_list_imgbox_wrap">
					<c:choose>
						<c:when test="${param.order eq 1 }">
							<c:forEach var="vo" items="${new_pro_list}">
								<div class="goods_list_imgbox">
									<div>
										<a href="${cp }/shop/goods_detail?p_num=${vo.p_num}"><img
											src="${cp }/shop/productimgs/${vo.save_img_name }"></a>
									</div>
									<a href="${cp }/shop/goods_detail" class="textbox"> <span
										class="title">${vo.p_name }</span> <span class="price">${vo.p_price }원</span>
									</a>
								</div>
							</c:forEach>
						</c:when>
						<c:when test="${param.order eq 2 }">
							<c:forEach var="vo" items="${low_pro_list}">
								<div class="goods_list_imgbox">
									<div>
										<a href="${cp }/shop/goods_detail?p_num=${vo.p_num}"><img
											src="${cp }/shop/productimgs/${vo.save_img_name }"></a>
									</div>
									<a href="${cp }/shop/goods_detail" class="textbox"> <span
										class="title">${vo.p_name }</span> <span class="price">${vo.p_price }원</span>
									</a>
								</div>
							</c:forEach>
						</c:when>
						<c:when test="${param.order eq 3 }">
							<c:forEach var="vo" items="${high_pro_list}">
								<div class="goods_list_imgbox">
									<div>
										<a href="${cp }/shop/goods_detail?p_num=${vo.p_num}"><img
											src="${cp }/shop/productimgs/${vo.save_img_name }"></a>
									</div>
									<a href="${cp }/shop/goods_detail" class="textbox"> <span
										class="title">${vo.p_name }</span> <span class="price">${vo.p_price }원</span>
									</a>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${pro_list}">
								<div class="goods_list_imgbox">
									<div>
										<a href="${cp }/shop/goods_detail?p_num=${vo.p_num}"><img
											src="${cp }/shop/productimgs/${vo.save_img_name }"></a>
									</div>
									<a href="${cp }/shop/goods_detail" class="textbox"> <span
										class="title">${vo.p_name }</span> <span class="price">${vo.p_price }원</span>
									</a>
								</div>
							</c:forEach>
							<c:forEach var="vo" items="${pro_list1}">
								<div class="goods_list_imgbox">
									<div>
										<a href="${cp }/shop/goods_detail?p_num=${vo.p_num}"><img
											src="${cp }/shop/productimgs/${vo.save_img_name }"></a>
									</div>
									<a href="${cp }/shop/goods_detail" class="textbox"> <span
										class="title">${vo.p_name }</span> <span class="price">${vo.p_price }원</span>
									</a>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- content -->
