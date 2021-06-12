<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="my_row">
		<div class="mypage">
			<!-- 사이드메뉴 -->
			<div class="mypage_sidemenu">
				<h3>마이페이지</h3>
				<jsp:include page="${sidemenu }"/>
			</div>
			<!-- 문의내역 -->
			<div class="mypage_orderlist">
					<h3>문의내역</h3>
					<div class="mypage_reviewlist_wrap">
						<table>
							<tr>
								<th width="25%">제목</th>
								<th width="50%">내용</th>
								<th width="15%">날짜</th>
								<th width="10%">답변상태</th>
							</tr>

							<c:forEach var="questionList" items="${list }">
							<c:choose>
							<c:when test="${questionList.q_b_state=='답변대기' }">

								<tr>
								<td><a href="${cp }/shop/mypage_questionlist_detail?qnum=${questionList.q_b_num }">${questionList.q_b_title }</a></td>
								<td style="color:#aaa" class="content">${questionList.q_b_content }</td>
								<td>${questionList.wr_date }</td>
								<td style="color:#ddd">${questionList.q_b_state }</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
								<td><a href="${cp }/shop/mypage_questionlist_detail?qnum=${questionList.q_b_num }">${questionList.q_b_title }</a></td>
								<td style="color:#aaa" class="content">${questionList.q_b_content }</td>
								<td>${questionList.wr_date }</td>
								<td style="color:#14aaff">${questionList.q_b_state }</td>
								</tr>
							</c:otherwise>
							</c:choose>
							</c:forEach>

						</table>
					</div>
				<div style="margin-top:30px;text-align:center;">
				<c:if test="${startPageNum>10}">
				<a href="${cp }/shop/mypage_questionlist?pageNum=${startPageNum-1 }">이전페이지</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${pageNum==i }"><%--현재 페이지인경우 --%>
						<span style="color:black">[${i }]</span>
					</c:when>
				<c:otherwise>
						<a href="${cp }/shop/mypage_questionlist?pageNum=${i }" style="color:grey">[${i }]</a>
				</c:otherwise>
						</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount}">
						<a href="${cp }/shop/mypage_questionlist?pageNum=${endPageNum+1 }">다음페이지</a>
				</c:if>
				</div>
				</div>


		</div>

	</div>
</div>							