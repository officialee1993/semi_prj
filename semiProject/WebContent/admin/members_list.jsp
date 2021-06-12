<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>회원관리</h3>
		</div>
		<div class="admin_content_box">
		<form method="post" action="${cp }/admin/members_list">
			<div class="admin_goods_menu">
				<ul>
					<!-- 카테고리 -->
					<li class="category">
						<select name="field" class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option value="id" <c:if test="${field=='id' }">selected="selected"</c:if>>아이디</option>
						  <option value="name" <c:if test="${field=='name' }">selected="selected"</c:if>>이름</option>
						  <option value="phone" <c:if test="${field=='phone' }">selected="selected"</c:if>>연락처</option>
						  <option value="email" <c:if test="${field=='email' }">selected="selected"</c:if>>이메일</option>
						</select>
						<input name="keyword" value="${keyword }" class="form-control form-control-sm" type="text" placeholder="" aria-label=".form-control-sm example">
					<!-- 검색버튼 -->
						<button type="submit" class="btn btn-outline-dark catrgory_btn">검색</button>
					</li>
					<li>
						<p><a href="${cp }/admin/members_list">[전체목록보기]</a></p>
					</li>
				</ul>
			</div>
		</form>
		
			<div class="admin_goods_list admin_order_list">
			<table>
			<!-- 제목 -->
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>주소</th>
					<th></th>
				</tr>
				<!-- 반복문 실행 -->
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.id }</td>
						<td>${vo.name }</td>
						<td>${vo.phone }</td>
						<td>${vo.email }</td>
						<td>${vo.address }</td>
						<td><button onclick="if(confirm('삭제하시겠습니까?')){location.href='${cp}/admin/members_delete?pageNum=${pageNum }&id=${vo.id }';}else{return false;}" type="button" class="btn btn-outline-dark">삭제</button></td>
					</tr>
				</c:forEach>
			</table>
			
			<div class="goods_pagenum">
				<c:if test="${startPageNum>10 }">
					<a href="${cp }/admin/members_list?pageNum=${startPageNum-1 }&field=${field }&keyword=${keyword }">이전페이지</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<c:choose>
						<c:when test="${i==pageNum }">
							<a href="${cp }/admin/members_list?pageNum=${i }&field=${field }&keyword=${keyword }">
							<span style="color:black">[${i }]</span></a>
						</c:when>
						<c:otherwise>
							<a href="${cp }/admin/members_list?pageNum=${i }&field=${field }&keyword=${keyword }">
							<span style="color:grey">[${i }]</span></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount }">
					<a href="${cp }/admin/members_list?pageNum=${endPageNum+1 }&field=${field }&keyword=${keyword }">다음페이지</a>
				</c:if>
			</div>
			
			</div>

		</div>
	</div>