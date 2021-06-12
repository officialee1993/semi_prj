<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="content">
		<div class="my_row">
			<div class="join_wrap">
			
			<script type="text/javascript">
			
			function checkData(){
				
				   
				   var idJ = /^[a-z0-9]{4,12}$/; 
				
				var id=document.getElementsByName("id")[0];
				if(id.value.length==0){
					alert("아이디 입력하세요");
					id.focus();
					return false;	
				}else if(!idJ.test(id.value)){
					alert("4~12자리 아이디 입력하세요.");
					id.focus();
					return false;
				}
				
				var pwd=document.getElementsByName("pwd")[0];
				 var pwJ = /^[A-Za-z0-9]{4,12}$/; 
				if(pwd.value.length==0){
					alert("비밀번호 입력하세요");
					pwd.focus();
					return false;	
				}else if(!pwJ.test(pwd.value)){
					alert("4~12자리 비밀번호 입력하세요.");
					pwd.focus();
					return false;
				}
				
				var name=document.getElementsByName("name")[0];
				 var nameJ =/^[가-힣a-zA-Z]+$/; 
				if(name.value.length==0){
					alert("이름 입력하세요");
					name.focus();
					return false;	
				}else if(!nameJ.test(name.value)){
					alert("한글과 열어로 이뤄진 이름을 입력하세요");
					name.focus();
					return false;
				}
				
				
				var address=document.getElementsByName("address")[0];
				
				if(address.value.length==0){
					alert("주소 입력하세요");
					address.focus();
					return false;	
				}
				
				
				var email=document.getElementsByName("email")[0];
				var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				if(email.value.length==0){
					alert("이메일 입력하세요");
					email.focus();
					return false;	
				}else if(!mailJ.test(email.value)){
					alert("홍길동@홍길동.com 형식으로 입력하세요.");
					email.focus();
					return false;	
				}
				
				
				var phone=document.getElementsByName("phone")[0];
				var phoneJ = /^\d{2,3}-\d{3,4}-\d{4}$/;
				if(phone.value.length==0){
					alert("전화번로 입력하세요");
					phone.focus();
					return false;	
				}else if(!phoneJ.test(phone.value)){
					alert("xxx-xxxx-xxxx 형식으로 입력하세요.");
					phone.focus();
					return false;	
				}
				return true;
				
			}
			
			
			
			</script>
			<div class="join_box">
				<h3 class="form_title">회원가입</h3>
				<form action="${cp}/shop/join" method="post" onsubmit="return checkData();">
				<div class="mb-3">
  				<label for="" class="form-label">아이디</label>
  				<input type="text" class="form-control" id="id" name="id" placeholder="4~12자 이상의 아이디로 입력해주세요.">
  				<input type="button" class="form-control" id="idcheck" value="중복검사" >
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">비밀번호</label>
  				<input type="password" class="form-control" name="pwd" placeholder="4~12자 이상의 비밀번호로 입력해주세요.">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">이름</label>
  				<input type="text" class="form-control" name="name" placeholder="한글과 열어로 이뤄진 이름으로 입력해주세요.">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">주소</label>
  				<input type="text" class="form-control" name="address" placeholder="주소를 입력해주세요.">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">이메일</label>
  				<input type="email" class="form-control" name="email" placeholder="xxx@xxx.com 형식으로 입력해주세요.">
  				</div>
  				<div class="mb-3">
  				<label for="" class="form-label">전화번호</label>
  				<input type="text" class="form-control" name="phone" placeholder="010-0101-1010 형식으로 입력해주세요.">
  				</div>
  				<div class="btn_wrap">
  				<button type="submit" class="btn btn-dark">가입하기</button>
  				</div>
				</form>
			</div>
			<script type="text/javascript">
			
				var idcheck=document.getElementById("idcheck");

				idcheck.addEventListener('click', function(e) {
					
					var idJ = /^[a-z0-9]{4,12}$/; 
					
					var id=document.getElementsByName("id")[0];
					if(id.value.length==0){
						alert("아이디 입력하세요");
						id.focus();
						btn2.disabled=false;	
					}else if(!idJ.test(id.value)){
						alert("4~12자리 아이디 입력하세요.");
						id.focus();
						btn2.disabled=false;	
					}
				
					window.open('Idcheck.jsp','_blank','width=300,height=200');

			});
			
			</script>
			</div>
		</div>
	</div>
