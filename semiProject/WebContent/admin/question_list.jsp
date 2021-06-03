<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>문의관리</h3>
		</div>
		<div class="admin_content_box">
				<form>
			<div class="admin_goods_menu">
				<ul>
					<!-- 카테고리 -->
					<li class="category">
						<select class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option selected>분류</option>
						  <option value="1">상품문의</option>
						  <option value="1">배송문의</option>
						  <option value="1">기타문의</option>
						</select>
						<input class="form-control form-control-sm" type="text" placeholder="" aria-label=".form-control-sm example">
					<!-- 검색버튼 -->
						<button type="button" onclick="" class="btn btn-outline-dark catrgory_btn">검색</button>
					</li>
				</ul>
			</div>
		</form>
		
			<div class="admin_goods_list admin_order_list">
			<table>
			<!-- 제목 -->
				<tr>
					<th width="10%">문의유형</th>
					<th width="10%">아이디</th>
					<th>제목</th>
					<th width="20%">답변상태</th>
					<th width="15%">문의날짜</th>
				</tr>
				<!-- 반복문 실행 -->
				<c:forEach var="qList" items="${qList }">
					<c:choose>
						<c:when test="${qList.q_b_state=='답변대기' }">
						<tr>
							<td>${qList.q_b_category }</td>
							<td>${qList.id }</td>
							<td><a href="${cp }/admin/question_detail?qnum=${qList.q_b_num}">${qList.q_b_title }</a></td>
							<td style="color:orange">${qList.q_b_state }</td>
							<td>${qList.wr_date }</td>
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<td>${qList.q_b_category }</td>
							<td>${qList.id }</td>
							<td><a href="${cp }/admin/question_detail?qnum=${qList.q_b_num}">${qList.q_b_title }</a></td>
							<td style="font-weight:700">${qList.q_b_state }</td>
							<td>${qList.wr_date }</td>
						</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				

			</table>
			
			<div class="goods_pagenum">
				
				<span><a href="">1</a></span>
				
			</div>
			
			</div>

		</div>
	</div>