<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="my_row">
		<div class="mypage">
			<!-- 사이드메뉴 -->
			<div class="mypage_sidemenu">
				<h3>마이페이지</h3>
				<jsp:include page="${sidemenu }"/>
			</div>
			<!-- 상품후기내역 -->
			<div class="mypage_orderlist">
					<h3>구매후기</h3>
					<div class="mypage_reviewlist_wrap mypage_reviewlist_wrap2">
						<table>
							<tr>
								<th width="30%">제목</th>
								<th width="55%">내용</th>
								<th width="15%">날짜</th>
							</tr>
							<c:forEach var="list" items="${myReviewList }">
							<c:choose>
								<c:when test="${not empty list.a_b_content }">
								<tr>
								<td>${list.a_b_title }</td>
								<td class="content"><a href="${cp }/shop/mypage_reviewlist_detail?title=${list.a_b_title }&content=${list.a_b_content }">${list.a_b_content }</a></td>
								<td>${list.wr_date }</td>
								</tr>
								</c:when>
							</c:choose>
							</c:forEach>
						</table>
					</div>
				</div>
		</div>
	</div>
</div>
