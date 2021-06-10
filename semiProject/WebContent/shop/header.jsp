<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="header">
	<div class="my_row">
		<div class="header_box">
			<div class="logo">
			<a href="${cp }/shop/index"><img onmouseover="this.src='images/logo_a.png'" onmouseout="this.src='images/logo_org.png'" style="width:60px;height:61px;" src="images/logo_org.png"/></a>
			</div>
		
			<c:choose>
			<c:when test="${empty sessionScope.id}">
			<div class="header_menu" id="header_menu" style="flex:1.22 1 0">
			<ul>
				<li><a href="${cp }/shop/goods_list?order=1">신상품</a></li>
				<li><a href="${cp }/shop/goods_list_pro?p_id=1">남성</a></li>
				<li><a href="${cp }/shop/goods_list_pro?p_id=2">여성</a></li>
			</ul>
			</div>
			</c:when>
			<c:otherwise>
			<div class="header_menu" id="header_menu">
			<ul>
				<li><a href="${cp }/shop/goods_list?order=1">신상품</a></li>
				<li><a href="${cp }/shop/goods_list_pro?p_id=1">남성</a></li>
				<li><a href="${cp }/shop/goods_list_pro?p_id=2">여성</a></li>
			</ul>
			</div>
			</c:otherwise>
			</c:choose>
			
		<div>
			
		</div>


		<div class="btn_wrap">
			<c:choose>
			
			<c:when test="${empty sessionScope.id}">
			<a href="${cp}/shop/login">로그인</a>
			<a href="${cp}/shop/join">회원가입</a>
			<span id="magnifying-glass" onclick="headerSearch()"></span>
			</c:when>
			
			<c:otherwise>
			<a href="${cp}/shop/logout">로그아웃</a>
			<a href="${cp}/shop/goods_cart" class="header_basket" id="header_basket">장바구니 </a>
			<a href="${cp}/shop/mypage_orderlist" class="header_mypage" id="header_mypage">마이페이지
			</a>
			<span id="magnifying-glass" onclick="headerSearch()"></span>
			<ul class="header_mypage_menu" id="header_mypage_menu">
			<li><a href="${cp }/shop/mypage_orderlist">주문내역</a></li>
			<li><a href="${cp }/shop/mypage_reviewlist">구매후기</a></li>
			<li><a href="${cp }/shop/mypage_questionlist">문의내역</a></li>
			<li><a href="${cp }/shop/mypage_info_modify">개인정보수정</a></li>
			</ul>
			</c:otherwise>
			</c:choose>
			
		</div>
		</div>
		</div>
		<div class="menu_dropdown" id="menu_dropdown">
					<ul style="margin-left:79px">
					<li><a href="${cp }/shop/goods_list_pro_top?p_id=1&cg_id=6">상의</a></li>
					<li><a href="${cp }/shop/goods_list_pro_bottom?p_id=1&cg_id=7">하의</a></li>
					<li><a href="${cp }/shop/goods_list_pro_shoes?p_id=1&cg_id=8">신발</a></li>
					</ul>
					<ul>
					<li><a href="${cp }/shop/goods_list_pro_top?p_id=2&cg_id=3">상의</a></li>
					<li><a href="${cp }/shop/goods_list_pro_bottom?p_id=2&cg_id=4">하의</a></li>
					<li><a href="${cp }/shop/goods_list_pro_shoes?p_id=2&cg_id=5">신발</a></li>
					</ul>
			</div>
	</div>
			<div id="searchWrap" class="searchWrap">
			<div class="mb-3">
			<form method="post" action="${cp}/shop/goods_list_product" accept-charset="utf-8">
			 	<label for="" class="form-label"></label>
  				<textarea id="header_search_input" name="header_search_input" class="form-control" id="" rows="1" placeholder="상품명을 입력해주세요"></textarea>
  				<button type="submit" class="btn btn-outline-light">검색</button>
  				<div id="mdiv" onclick=>
				  <div class="mdiv">
				    <div class="md"></div>
				  </div>
				</div>
			</form>
			</div>
			</div>
	<script>
	/*헤더 드롭다운*/
	document.getElementById("header_menu").addEventListener('mouseover',function(){
	document.getElementById("menu_dropdown").style.display='flex';
	});
	document.getElementById("menu_dropdown").addEventListener('mouseleave',function(){
	menu_dropdown.style.display='none';
	});
	
	
	var searchWrap = document.getElementById("searchWrap");
	var searchInput = document.getElementById("header_search_input");
	
	function headerSearch(){
		searchWrap.style.display="block";
		searchInput.focus();
	}
	document.getElementById("mdiv").addEventListener('click',function(){
		searchWrap.style.display="none";
	});

	</script>