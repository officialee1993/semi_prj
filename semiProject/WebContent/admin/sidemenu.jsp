<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
	<div class="admin_content_menu_wrap">
		<div class="logo_wrap"><img src="images/logo_org_white.png"></div>
		<div class="admin_content_menu">
		<div class="admin_content_menu_list"><a href="${cp }/admin/goods_list" id="admin_goods">상품관리</a>
		<ul class="dropdown_menu" id="dropdown_menu">
				<li><a href="${cp }/admin/goods_list">상품목록</a></li>
				<li><a href="${cp }/admin/goods_insert">상품등록</a></li>
			</ul> 
		</div>
		<div class="admin_content_menu_list"><a href="${cp }/admin/order_list">주문관리</a></div>
		<div class="admin_content_menu_list"><a href="${cp }/admin/question_list">문의관리</a></div>
				<div class="admin_content_menu_list"><a href="${cp }/admin/members_list">회원관리</a></div>
		<div class="admin_content_menu_list"><a href="${cp }/admin/sales">매출통계</a></div>
		</div>
	</div>

<script type="text/javascript">
	document.getElementById("admin_goods").addEventListener('mouseover',function(){
		document.getElementById("dropdown_menu").style.display='block';
	})
	document.getElementById("dropdown_menu").addEventListener('mouseleave',function(){
		document.getElementById("dropdown_menu").style.display='none';
	})
</script>