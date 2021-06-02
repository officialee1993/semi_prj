<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	

	<div class="content">
		<div class="my_row" style="width:800px;margin:auto;">
			<div class="mypage questionDetail_pwdWrapper" id="questionDetail_pwdWrapper">
			<!-- 프로필 수정 -->
			<div class="mypage_orderlist questionDetail_pwdBox">
				<h3 style="text-align:center;">비밀번호 확인</h3>
					<!-- 비밀번호 확인 -->
					<div class="mypage_password_check" id="mypage_password_check">
					<div class="mb-3">
					  <label for="" class="form-label"></label>
					  <input id="pwdFind" type="password" class="form-control" placeholder="비밀번호를 입력해주세요">
					</div>
					<button onclick="pwdCheck()" class="btn btn-outline-dark">확인</button>
					</div>
			</div>
		</div>
		
			<div class="question_detail" id="question_detail" style="display:none">
			<h3>문의사항</h3>
			<form method="post" action="write">
				<div class="input_wrapper">
					<input name="writer" type="text" readonly class="form-control-plaintext"
						id="" value="${vo.category }" readonly />
				</div>
				<div class="input_wrapper">
					<input name="email" type="text" readonly class="form-control-plaintext"
						id="" value="${vo.id }" readonly />
				</div>

				<div class="input_wrapper">
					<input name="title" type="text" readonly class="form-control-plaintext"
						id="" value="${vo.q_title }" readonly />
				</div>
				<div class="input_wrapper">
					<textarea name="content" readonly class="form-control-plaintext" rows="10"
						id="" rows="3" readonly>${vo.q_content }</textarea>
				</div>
			</form>
			<div class="question_answer">
			  	<div class="admin_wrapper">
				  <label for="" class="form-label">관리자 답변</label>
				  <textarea readonly class="form-control-plaintext" id="" rows="3">${vo.a_content }</textarea>
				</div>
			</div>
			<div class="btnWrap" style="text-align:center;margin-top:20px">
				<button onclick="location.href='${cp }/shop/goods_detail?p_num=${param.p_num }'" class="btn btn-outline-dark">목록으로</button>
			</div>
			</div>


		</div>
	</div>
	
	<script>
		
	function pwdCheck(){
		var pwdFind=document.getElementById("pwdFind").value;
		var questionDetailPwdWrapper=document.getElementById("questionDetail_pwdWrapper");
		var questionDetail=document.getElementById("question_detail");
		console.log(pwdFind);
		console.log("${vo.q_num}");
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let xml=xhr.responseXML;
				let result=xml.getElementsByTagName("result")[0].textContent;
				if(result=='success'){
					questionDetailPwdWrapper.style.display="none";
					questionDetail.style.display="block";
				}else{
					alert("정보가 일치하지 않습니다");
				}
			}
		};
		xhr.open('post','${pageContext.request.contextPath }/shop/question_detail',true);
		//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send("pwd="+pwdFind+"&qnum=${vo.q_num}");
	}
	
	</script>
