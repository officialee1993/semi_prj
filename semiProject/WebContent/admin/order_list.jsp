<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>주문관리</h3>
		</div>
		<div class="admin_content_box">
		<form method="post" action="${cp }/admin/order_list">
			<div class="admin_goods_menu">
				<ul>
					<li class="category">
						<select name="field" class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option value="id" <c:if test="${field=='id'}">selected="selected"</c:if>>아이디</option>
						  <option value="rec_name" <c:if test="${field=='rec_name'}">selected="selected"</c:if>>주문자명</option>
						  <option value="o_state" <c:if test="${field=='o_state'}">selected="selected"</c:if>>주문상태</option>
						</select>
						<input name="keyword" value="${keyword }" class="form-control form-control-sm" type="text" placeholder="" aria-label=".form-control-sm example">
					<!-- 검색버튼 -->
						<button type="submit" class="btn btn-outline-dark catrgory_btn">검색</button>
					</li>
				</ul>
			</div>
		</form>

			<div class="admin_goods_list admin_order_list">
			<table>
			<!-- 제목 -->
				<tr>
					<th>주문번호</th>
					<th>아이디</th>
					<th>주문자명</th>
					<th>결제금액</th>
					<th>결제수단</th>
					<th>주문상태</th>
					<th></th>
				</tr>
				<c:forEach var="list" items="${orderList }" varStatus="status">
					<c:choose>
						<c:when test="${list.o_state=='주문완료' }">
							<tr>
							<td><a href="${cp }/admin/order_detail?onum=${list.o_num }">${list.o_num }</a></td>
							<td>${list.id }</td>
							<td>${list.rec_name }</td>
							<td>${list.all_sum_price }</td>
							<td>${list.payname }</td>
							<td>${list.o_state }</td>
							<td class="complete"><button onclick="oStateUpdate(${list.o_num },${status.index });" type="button" class="btn btn-outline-dark completeBtn">발송</button></td>
							</tr>
						</c:when>
						<c:when test="${list.o_state=='배송완료' }">
							<tr>
							<td><a href="${cp }/admin/order_detail?onum=${list.o_num }">${list.o_num }</a></td>
							<td>${list.id }</td>
							<td>${list.rec_name }</td>
							<td>${list.all_sum_price }</td>
							<td>${list.payname }</td>
							<td style="color:orange">${list.o_state }</td>
							<td></td>
							</tr>
						</c:when>
					</c:choose>
			</c:forEach>
			</table>
			
			<div class="goods_pagenum">
				<c:if test="${startPageNum>5}">
				<a href="${cp }/shop/admin/order_list?pageNum=${startPageNum-1 }">이전페이지</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${pageNum==i }"><%--현재 페이지인경우 --%>
						<span style="color:black">[${i }]</span>
					</c:when>
				<c:otherwise>
						<a href="${cp }/admin/order_list?pageNum=${i }" style="color:grey">[${i }]</a>
				</c:otherwise>
						</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount}">
						<a href="${cp }/admin/order_list?pageNum=${endPageNum+1 }">다음페이지</a>
				</c:if>
				
			</div>
			
			</div>

		</div>
	</div>
	
	<script>
		function oStateUpdate(onum,status){
			
			var complete=document.getElementsByClassName("complete")[status];
			var completeBtn=document.getElementsByClassName("completeBtn")[status];
			
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					
					let result=xhr.responseText;
					let json=JSON.parse(result);
					if(json.result!=''){
						completeBtn.style.display="none";
						complete.innerHTML="상품발송완료";
					}else{
						alert("배송실패");
					}
				}
			};
			xhr.open('post','${pageContext.request.contextPath }/admin/order_list?cmd=update',true);
			//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.send("o_num="+onum);
		}
	</script>
	
	
	