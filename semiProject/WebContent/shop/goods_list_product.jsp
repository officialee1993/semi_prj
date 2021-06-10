<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- content -->
<div class="banner_goods">
		<img src="images/banner_new.png">
</div>


<div class="content">
	<div class="my_row">
		<div class="goods_list">
			<div class="goods_list_box">
				<div class="goods_list_imgbox_wrap">
					<!-- 반복문에 들어갈 엘리먼트 -->
					<c:forEach var="vo" items="${list_product }">
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
				</div>
			</div>
		</div>
	</div>
</div>
<!-- content -->

