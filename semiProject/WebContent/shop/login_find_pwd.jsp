<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="content">
		<div class="my_row">
			<div class="login_box">
				<h3 class="form_title" id="form_title1">비밀번호 찾기</h3>
				
				<div id ="find_pwd">
				<div class="mb-3">
				  <label for="" class=""></label>
				  <input name="id" type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요">
				  <label for="" class=""></label>
				  <input name="email" type="email" class="form-control" id="email" placeholder="이메일을 입력해주세요">
				  <span id="not_found"></span>
				</div>
				<button onclick="pwdfind()" class="btn btn-dark">찾기</button>
				
			</div>
		</div>
	</div>
</div>
	
<script type="text/javascript">
	function pwdfind(){
			var id=document.getElementById("id").value;
			var email=document.getElementById("email").value;
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					
					let xml=xhr.responseXML;
					let result=xml.getElementsByTagName("result")[0].textContent;
					
					if(result!=""){
					
						let p=document.createElement("p");
						p.innerHTML=result;
						document.getElementById("form_title1").innerHTML="비밀번호 찾기 성공";
						document.getElementById("find_pwd").innerHTML="<br><br><br><br><br><br> 찾는 아이디 : "+result;
					
						

					}else{
						document.getElementById("not_found").innerHTML="정보를 찾을수 없습니다."
						
					
					}
				}
			};
			xhr.open('post','${pageContext.request.contextPath }/shop/login_find_ajax/Ajax_findpwd.jsp',true);
			//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			let params="id="+id+"&email="+email;
			xhr.send(params);
	}

</script>