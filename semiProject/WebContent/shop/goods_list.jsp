<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- content -->
<div class="content">
	<div class="my_row">
		<div class="goods_list">
			<h3>남성</h3>
			<div class="goods_list_box">
				<ul class="goods_list_box_category">
					<li><a href="${cp }/shop/goods_detail">상의</a></li>
					<li><a href="${cp }/shop/goods_detail">하의</a></li>
					<li><a href="${cp }/shop/goods_detail">신발</a></li>
					<li>
					<select class="form-select form-select-sm" aria-label=".form-select-sm example">
					  <option selected>신상품순</option>
					  <option value="1">낮은 가격순</option>
					  <option value="2">높은 가격순</option>
					</select>
					</li>
				</ul>
				<div class="goods_list_imgbox_wrap">
					<!-- 반복문에 들어갈 엘리먼트 -->
					<div class="goods_list_imgbox">
						<div><a href="${cp }/shop/goods_detail"><img src="images/ex01.jpg"></a></div>
						<a href="${cp }/shop/goods_detail" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>

					<div class="goods_list_imgbox">
						<div><a href="${cp }/shop/goods_detail"><img src="images/ex01.jpg"></a></div>
						<a href="${cp }/shop/goods_detail" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>					<div class="goods_list_imgbox">
						<div><a href="${cp }/shop/goods_detail"><img src="images/ex01.jpg"></a></div>
						<a href="${cp }/shop/goods_detail" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>					<div class="goods_list_imgbox">
						<div><a href="${cp }/shop/goods_detail"><img src="images/ex01.jpg"></a></div>
						<a href="${cp }/shop/goods_detail" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>					<div class="goods_list_imgbox">
						<div><a href="${cp }/shop/goods_detail"><img src="images/ex01.jpg"></a></div>
						<a href="${cp }/shop/goods_detail" class="textbox">
						<span class="title">남성 반팔</span>
						<span class="price">50,000원</span>
						</a>
					</div>


				</div>
			</div>
		</div>
	</div>
</div>
<!-- content -->
