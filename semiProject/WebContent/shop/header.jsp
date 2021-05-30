<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="header">
	<div class="my_row">
		<div class="header_box">
			<div class="logo">
			<a href="${cp }/shop/index"><img onmouseover="this.src='images/logo_a.png'" onmouseout="this.src='images/logo_org.png'" style="width:60px;height:61px;" src="images/logo_org.png"/></a>
			</div>
			<div class="header_menu" id="header_menu">
			<ul>
				<li><a href="${cp }/shop/goods_list">신상품</a></li>
				<li><a href="${cp }/shop/goods_list">남성</a></li>
				<li><a href="${cp }/shop/goods_list">여성</a></li>
			</ul>
			</div>
		<div class="btn_wrap">
			<c:choose>
			
			<c:when test="${empty sessionScope.id}">
			<a href="${cp}/shop/login">로그인</a>
			<a href="${cp}/shop/join">회원가입</a>
			</c:when>
			
			<c:otherwise>
			<a href="${cp}/shop/logout">로그아웃</a>
			<a href="${cp}/shop/mypage_orderlist" class="header_mypage" id="header_mypage">마이페이지
			</a>
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
					<ul>
					<li><a href="${cp }/shop/goods_list">신상품</a></li>
					</ul>
					<ul>
					<li><a href="${cp }/shop/goods_list">상의</a></li>
					<li><a href="${cp }/shop/goods_list">하의</a></li>
					<li><a href="${cp }/shop/goods_list">신발</a></li>
					</ul>
					<ul>
					<li><a href="${cp }/shop/goods_list">상의</a></li>
					<li><a href="${cp }/shop/goods_list">하의</a></li>
					<li><a href="${cp }/shop/goods_list">신발</a></li>
					</ul>
					
			</div>
	</div>