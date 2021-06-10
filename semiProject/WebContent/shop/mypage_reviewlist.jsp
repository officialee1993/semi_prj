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
								<input type="hidden" name="a_b_num" value="${list.a_b_num }">
								<tr>
								<td><a style="font-weight:700" href="${cp }/shop/mypage_reviewlist_detail?cmd=list&a_b_num=${list.a_b_num }">${list.a_b_title }</a></td>
								<td>${list.a_b_content }</td>
								<td>${list.wr_date }</td>
								</tr>
								</c:when>
							</c:choose>
							</c:forEach>
						</table>
					</div>
					
				<div style="margin-top:30px;text-align:center;">
				<c:if test="${startPageNum>10}">
				<a href="${cp }/shop/mypage_reviewlist?pageNum=${startPageNum-1 }">이전페이지</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${pageNum==i }"><%--현재 페이지인경우 --%>
						<span style="color:black">[${i }]</span>
					</c:when>
				<c:otherwise>
						<a href="${cp }/shop/mypage_reviewlist?pageNum=${i }" style="color:grey">[${i }]</a>
				</c:otherwise>
						</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount}">
						<a href="${cp }/shop/mypage_reviewlist?pageNum=${endPageNum+1 }">다음페이지</a>
				</c:if>
				</div>

				</div>
		</div>
	</div>
</div>
