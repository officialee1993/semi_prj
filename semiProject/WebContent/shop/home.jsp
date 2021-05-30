<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="banner">
		<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
  		<div class="carousel-inner">
    	<div class="carousel-item active" data-bs-interval="10000">
     	 <img src="images/banner7.png" class="d-block w-100" alt="">
   		 </div>
   		 <div class="carousel-item" data-bs-interval="2000">
   		   <img src="images/banner8.png" class="d-block w-100" alt="">
   		 </div>
   		 <div class="carousel-item">
   		   <img src="images/banner9.png" class="d-block w-100" alt="">
  		  </div>
 		 </div>
  		<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
  		  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
  		  <span class="visually-hidden">Previous</span>
  		</button>
  		<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
  		  <span class="carousel-control-next-icon" aria-hidden="true"></span>
  		  <span class="visually-hidden">Next</span>
 		 </button>
		</div>
	</div>
	<div class="content">
		<div class="my_row">
			<div class="item_box">
				<div class="title">
					<p>New Product</p>
					
				</div>
				<ul>
				<c:forEach var="vo" items="${list}">
			
					<li>
						<a href="${cp}/shop/goods_detail">
						<img src="${cp}/shop/productimgs/${vo.save_img_name}">
						</a>
						<div class="text_box">
						<a href="${cp}/shop/goods_detail" class="price">[${vo.cg_name}]${vo.p_name}</a>
						<p class="price">${vo.p_price}</p>
						</div>
					</li>
				
				</c:forEach>
					
					
					
<%-- 					<li>
						<a href="${cp}/shop/goods_detail">
						<img src="images/ex01.jpg">
						</a>
						<div class="text_box">
						<a href="${cp}/shop/goods_detail" class="price">[巢己]寂明1</a>
						<p class="price">10,000盔</p>
						</div>
					</li>
					<li>
						<a href="${cp}/shop/goods_detail">
						<img src="images/ex01.jpg">
						</a>
						<div class="text_box">
						<a href="${cp}/shop/goods_detail" class="price">[巢己]寂明1</a>
						<p class="price">10,000盔</p>
						</div>
					</li>
					<li>
						<a href="${cp}/shop/goods_detail">
						<img src="images/ex01.jpg">
						</a>
						<div class="text_box">
						<a href="${cp}/shop/goods_detail" class="price">[巢己]寂明1</a>
						<p class="price">10,000盔</p>
						</div>
					</li> --%>
				</ul>
			</div>
		</div>
	</div>