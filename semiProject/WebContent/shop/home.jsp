<%@page import="admin.dao.Productdao"%>
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
				<div class="slide_wrapper">
				
				<ul class="slides">
				<c:forEach var="vo" items="${list}">
				
					<li>
						<a href="${cp}/shop/goods_detail?p_num=${vo.p_num}">
						<img src="${cp}/shop/productimgs/${vo.save_img_name}">
						</a>
						<div class="text_box">

					
						<a href="${cp}/shop/goods_detail?p_num=${vo.p_num}" class="price">${vo.p_name}</a>
						<p class="price">${vo.p_price}¿ø</p>
						</div>
					</li> 


				</c:forEach>
					
				</ul>

				</div>
				<p class="controls">
					<span class="prev"></span>
					<span class="next"></span>
				</p>
			</div>
		</div>
	</div>
	<div class="adminLogin">
		<a target="blank" href="${cp}/admin/admin_login.jsp"><img src="images/logo_a.png" style="width:60px"></a>
	</div>
	<script>
		var slides=document.querySelector('.slides'),
			slide=document.querySelectorAll('.slides li'),
			currentIdx=0,
			slideCount=slide.length,
			prevBtn = document.querySelector('.prev'),
			slideWidth = 340,
			slideMargin = 15,
			nextBtn = document.querySelector('.next');
			
			slides.style.width=(slideWidth+slideMargin)*slideCount-slideMargin + 'px';
		
			function moveSlide(num){
				slides.style.left=-num*360+15+'px';
				currentIdx=num;
			}
			nextBtn.addEventListener('click',function(){
				if(currentIdx<slideCount-3){
					 moveSlide(currentIdx+1);
				}else{
					moveSlide(0);
				}
				
			});
			prevBtn.addEventListener('click',function(){
				if(currentIdx>0){
					 moveSlide(currentIdx-1);
				}else{
					moveSlide(slideCount-3);
				}
				
			});
	</script>