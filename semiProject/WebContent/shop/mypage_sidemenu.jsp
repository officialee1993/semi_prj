<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<li><a href="${cp }/shop/mypage_orderlist">주문내역</a></li>
	<li><a href="${cp }/shop/mypage_reviewlist">구매후기</a></li>
	<li><a href="${cp }/shop/mypage_questionlist">문의내역</a></li>
	<li><a href="${cp }/shop/mypage_info_modify">개인정보수정</a></li>
</ul>
	<!-- a태그를 post방식으로 보낼 폼 -->
<%--  <form name="userId">
   	<input type="hidden" name="loginId" value="${sessionScope.id }">
</form> 
    
<script>
    // loginId 를 인수로 받아 form 태그로 전송하는 함수
    function questionPage(loginId = 0) {
      // name이 userId인 태그
      var f = document.userId;
      // form 태그의 하위 태그 값 매개 변수로 대입
      f.loginId.value = loginId;
      // input태그의 값들을 전송하는 주소
      f.action = "${cp }/shop/mypage_questionlist";

      // 전송 방식 : post
      f.method = "post"
      f.submit();
    };
</script> --%>