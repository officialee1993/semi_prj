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
			<!-- 문의내역 자세히 보기 -->
			<div class="mypage_orderlist">
					<h3>문의내역</h3>
					<form class="mypage_questionlist_detail">
						<div class="mb-3">
 						<label for="" class="form-label"></label>
  						<input value="${vo.q_b_title }" type="text" readonly class="form-control-plaintext" id="" readonly/>
						</div>
						<div class="mb-3">
						<label for="" class="form-label"></label>
						<textarea readonly class="form-control-plaintext" id="" rows="5">${vo.q_b_content }</textarea>
						</div>
						<div class="btn_wrap" style="text-align:right;">
						<button onclick="" type="button" class="btn btn-outline-dark" style="font-size:14px;">삭제</button>
						</div>
					</form>
					<div class="mypage_questionlist_detail_reply">
						<c:choose>
							<c:when test="${not empty vo.q_a_content }">
							<span>관리자</span>
							<p>${vo.q_a_content }</p>
							</c:when>
							<c:otherwise>
							<span>등록된 답변이 없습니다</span>
							</c:otherwise>
						</c:choose>
					</div>
					</div>
					</div>
				</div>
			</div>
