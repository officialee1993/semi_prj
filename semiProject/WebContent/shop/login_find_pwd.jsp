<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="content">
		<div class="my_row">
			<div class="login_box">
				<h3 class="form_title" id="form_title">비밀번호 찾기</h3>
				<div id="find_pwd_lch" style="text-align:center;"></div>
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
						document.getElementById("find_pwd").style.display="none";
						let p=document.createElement("p");
						let a=document.createElement("a");
						p.innerHTML=result;
						p.style.textAlign="center";
						p.style.marginTop="100px";
						document.getElementById("form_title").innerHTML="비밀번호 찾기 성공";
						document.getElementById("find_pwd_lch").appendChild(p);
						document.getElementById("find_pwd_lch").appendChild(a);
						a.className="find_success";
						a.innerHTML="로그인";
						a.href="${pageContext.request.contextPath }/shop/login";
						
						
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