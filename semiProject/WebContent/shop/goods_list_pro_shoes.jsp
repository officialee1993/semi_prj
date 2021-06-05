<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- content -->
<div class="content">
	<div class="my_row">
		<div class="goods_list">
			<c:choose>
				<c:when test="${param.cg_id eq 8 }">
					<h3>남성</h3>
					<div class="goods_list_box">
						<ul class="goods_list_box_category">
							<li><a href="${cp }/shop/goods_list_pro_top?p_id=1&cg_id=6">상의</a></li>
							<li><a href="${cp }/shop/goods_list_pro_bottom?p_id=1&cg_id=7">하의</a></li>
							<li><a href="${cp }/shop/goods_list_pro_shoes?p_id=1&cg_id=8">신발</a></li>
							<li><select class="form-select form-select-sm"
								aria-label=".form-select-sm example"
								onchange="if(this.value) location.href=(this.value);">
									<option disabled selected values>-- 정렬 --</option>
									<option value="${cp }/shop/goods_list_pro_shoes?cg_id=8&order=1">신상품순</option>
									<option value="${cp }/shop/goods_list_pro_shoes?cg_id=8&order=2">낮은
										가격순</option>
									<option value="${cp }/shop/goods_list_pro_shoes?cg_id=8&order=3">높은
										가격순</option>
							</select></li>
						</ul>
						<div class="goods_list_imgbox_wrap">
							<c:choose>
								<c:when test="${param.order eq 1 }">
									<c:forEach var="vo" items="${pro_order_new_date}">
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
									<c:forEach var="vo" items="${pro_order_low_price}">
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
									<c:forEach var="vo" items="${pro_order_high_price}">
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
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:when>
				<c:when test="${param.cg_id eq 5 }">
					<h3>여성</h3>
					<div class="goods_list_box">
						<ul class="goods_list_box_category">
							<li><a href="${cp }/shop/goods_list_pro_top?p_id=2&cg_id=3">상의</a></li>
							<li><a href="${cp }/shop/goods_list_pro_bottom?p_id=2&cg_id=4">하의</a></li>
							<li><a href="${cp }/shop/goods_list_pro_shoes?p_id=2&cg_id=5">신발</a></li>
							<li><select class="form-select form-select-sm"
								aria-label=".form-select-sm example"
								onchange="if(this.value) location.href=(this.value);">
									<option disabled selected values>-- 정렬 --</option>
									<option value="${cp }/shop/goods_list_pro_shoes?p_id=2&cg_id=5&order=1">신상품순</option>
									<option value="${cp }/shop/goods_list_pro_shoes?p_id=2&cg_id=5&order=2">낮은
										가격순</option>
									<option value="${cp }/shop/goods_list_pro_shoes?p_id=2&cg_id=5&order=3">높은
										가격순</option>
							</select></li>
						</ul>
						<div class="goods_list_imgbox_wrap">
							<c:choose>
								<c:when test="${param.order eq 1 }">
									<c:forEach var="vo" items="${pro_order_new_date}">
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
									<c:forEach var="vo" items="${pro_order_low_price}">
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
									<c:forEach var="vo" items="${pro_order_high_price}">
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
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>
<!-- content -->
