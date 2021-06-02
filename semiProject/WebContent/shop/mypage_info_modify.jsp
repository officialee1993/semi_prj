<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content">
	<div class="my_row">
		<div class="mypage">
			<!-- 사이드메뉴 -->
			<div class="mypage_sidemenu">
				<h3>마이페이지</h3>
				<jsp:include page="${sidemenu }"/>
			</div>
			<!-- 프로필 수정 -->
			<div class="mypage_orderlist">
				<h3>개인정보수정</h3>
					<p id="update_success"></p>
					<!-- 비밀번호 확인 -->
					<div class="mypage_password_check" id="mypage_password_check">
					<div class="mb-3">
					  <label for="" class="form-label"></label>
					  <input id="pwdFind" type="password" class="form-control" placeholder="비밀번호를 입력해주세요">
					</div>
					<button onclick="pwdCheck()" class="btn btn-outline-dark">확인</button>
					</div>
					<!-- 회원정보 수정(비밀번호 인증시 보임) -->
					<div class="mypage_info_modify" id="mypage_info_modify" style="display:none">

					<div class="mb-3">
	  				<label for="" class="form-label">아이디</label>
	  				<input id="form_id" type="text" class="form-control" readonly/>
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">비밀번호</label>
	  				<input id="form_pwd" type="password" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">이름</label>
	  				<input id="form_name" type="text" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">주소</label>
	  				<input id="form_addr" type="text" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">이메일</label>
	  				<input id="form_email" type="email" class="form-control">
	  				</div>
	  				<div class="mb-3">
	  				<label for="" class="form-label">전화번호</label>
	  				<input id="form_phone" type="text" class="form-control">
	  				</div>
	  				<div class="btn_wrap">
	  				<button onclick="info_update()" class="btn btn-outline-dark">수정</button>
	  				</div>

					</div>
			</div>
		</div>
	</div>
</div>

<script>
function pwdCheck(){
	var pwdFind=document.getElementById("pwdFind").value;
	var pwdChk=document.getElementById("mypage_password_check");
	var modifyForm=document.getElementById("mypage_info_modify");
	

	
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			let result=xhr.responseText;
			let json=JSON.parse(result);
/* 			var resultId=xml.getElementsByTagName("id")[0].textContent;
			var resultPwd=xml.getElementsByTagName("pwd")[0].textContent;
			var resultName=xml.getElementsByTagName("name")[0].textContent;
			var resultPhone=xml.getElementsByTagName("phone")[0].textContent;
			var resultEmail=xml.getElementsByTagName("email")[0].textContent;
			var resultAddress=xml.getElementsByTagName("addr")[0].textContent; */
			
			if(json.result!=""){
				pwdChk.style.display="none";
				modifyForm.style.display="block";
				
				document.getElementById("form_id").value=json.id;
				document.getElementById("form_pwd").value=json.pwd;
				document.getElementById("form_name").value=json.name;
				document.getElementById("form_addr").value=json.addr;
				document.getElementById("form_email").value=json.email;
				document.getElementById("form_phone").value=json.phone;

				
				
			}else{
				alert("정보가 일치하지 않습니다")
			}

		}
	};
	xhr.open('post','${pageContext.request.contextPath }/shop/login_find_ajax/Ajax_info_modify.jsp',true);
	//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("pwd="+pwdFind);
}


function info_update(){
	
	var modifyForm=document.getElementById("mypage_info_modify");
	
	var form_id=document.getElementById("form_id").value;
	var form_pwd=document.getElementById("form_pwd").value;
	var form_name=document.getElementById("form_name").value;
	var form_addr=document.getElementById("form_addr").value;
	var form_email=document.getElementById("form_email").value;
	var form_phone=document.getElementById("form_phone").value;
	
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			
			let xml=xhr.responseXML;
			let result=xml.getElementsByTagName("result")[0].textContent;
			if(result!=""){
				document.getElementById("mypage_info_modify").style.display="none";
				var update_success=document.getElementById("update_success");
				update_success.innerHTML="수정완료";
				update_success.style.textAlign="center";
				update_success.style.marginTop="100px";
				update_success.style.fontSize="20px";
				
				
				
			}else{
				alert("수정실패");
			}
		}
	};
	xhr.open('post','${pageContext.request.contextPath }/shop/login_find_ajax/Ajax_info_update.jsp',true);
	//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let params="id="+form_id+"&pwd="+form_pwd+"&name="+form_name+"&addr="+form_addr+"&email="+form_email+"&phone="+form_phone;
	xhr.send(params);
}
</script>

