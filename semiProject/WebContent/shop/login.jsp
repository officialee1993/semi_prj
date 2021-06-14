<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="content">
		<div class="my_row">
			<div class="login_box">
				<h3 class="form_title">로그인</h3>
				
				
				<%-- <form class="login_insert" method="post" action="${cp}/shop/login" "> --%>
				<div class="mb-3">
				
				  <label for="" class=""></label>
				  <input name="id" type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요">
				
				  <label for="" class=""></label>
				  <input name="pwd" type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력해주세요">
				</div>
			
				<div class="login_search_box">
					<a href="${cp}/shop/login_find_id">아이디 찾기</a>
					<a href="${cp}/shop/login_find_pwd">비밀번호 찾기</a>
				</div>
				<div style="text-align: center; " ><span id="not_found" style="color: red;"></span></div>
				
				<button type="button" class="btn btn-dark" onclick="logincheck()">로그인</button>
				<!-- </form> -->
				
				<script type="text/javascript">
			
				function logincheck() {
				
				var id = document.getElementById("id").value;
				var id1 = document.getElementById("id");
				var pwd = document.getElementById("pwd").value;
				var pwd1 = document.getElementById("pwd");
				var loginchecked = document.getElementById("not_found");
				
				if(id.length ==0){
					alert("ID 입력하세요.");
					id1.focus();

				}else if(pwd.length==0){
					alert("PWD 입력하세요.");
					pwd1.focus();
				}else{
					let xhr=new XMLHttpRequest();
					xhr.onreadystatechange=function(){
						if(xhr.readyState==4 && xhr.status==200){
							
							let xml=xhr.responseXML;
							
							let result=xml.getElementsByTagName("result")[0].textContent;
							if(result =="true"){
								
								window.location.replace("${pageContext.request.contextPath}/shop/index");
								
							}else{
								not_found.innerHTML="<br><br>아이디 혹은 비밀번호가 맞지 않습니다."
								
							}
							
						
						}
						
					};
					xhr.open('post','${pageContext.request.contextPath}/shop/login',true);
					xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					let params="id="+id +"&pwd="+pwd;
					xhr.send(params);
					
				}
				

				
			}
			
			
			</script>
			
				<button type="button" onclick="location.href='${pageContext.request.contextPath }/shop/join'" class="btn btn-light">회원가입</button>
				
			</div>
			
			
		</div>
	</div>