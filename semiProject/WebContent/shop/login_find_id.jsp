<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="content">
		<div class="my_row">
			<div class="login_box" id="login_box">
				<h3 class="form_title" id="form_title">아이디 찾기</h3>
				<div id="find_id_lch"></div>
				<form class="login_insert" id="login_insert" action="">
				<div class="mb-3">
				  <label for="" class=""></label>
				  <input name="name" type="text" class="form-control" id="name" placeholder="이름을 입력해주세요">
				  <label for="" class=""></label>
				  <input name="email" type="email" class="form-control" id="email" placeholder="이메일을 입력해주세요">
				  <span id="not_found"></span>
				</div>
				<button onclick="idfind()" class="btn btn-dark">찾기</button>
				</form>
			</div>
		</div>
	</div>


<script type="text/javascript">
	function idfind(){
			var name=document.getElementById("name").value;
			var email=document.getElementById("email").value;
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					let xml=xhr.responseXML;
					let result=xml.getElementsByTagName("result")[0].textContent;
					if(result!=""){
						
						let p=document.createElement("p");
						p.innerHTML=result;
						p.style.textAlign="center";
						document.getElementById("login_insert").style.display="none";
						document.getElementById("form_title").innerHTML="아이디 찾기 성공";
						document.getElementById("find_id_lch").appendChild(p);
						alert(result);

					}else{
						document.getElementById("not_found").innerHTML="정보를 찾을수 없습니다."

					//	alert("정보가 없습니다");
					}
				}
			};
			xhr.open('post','${pageContext.request.contextPath }/shop/login_find_ajax/findid.jsp',true);
			//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			let params="name="+name+"&email="+email;
			xhr.send(params);
	}

</script>