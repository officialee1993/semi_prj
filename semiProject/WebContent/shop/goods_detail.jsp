<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<script type="text/javascript">
function checkData(){
	
	//alert("checkData");
	var p_count=document.getElementsByName("p_count")[0];
	var p_size=document.getElementsByName("p_size")[0];
	if(p_count.value.length==0){
		alert("수량 체크하세요");
		p_count.focus();
		return false;	
	}
	
	if(p_size.value=='사이즈'){
		alert("사이즈 체크하세요");
		p_size.focus();
		return false;	
	}
	
}

//댓글리스트 등록클릭시 새로고침
	function list(status){		 		
var a_b_num=document.getElementsByClassName("a_b_num")[status].value;
var reply_wrap_box=document.getElementsByClassName("reply_wrap_box")[status];
document.getElementsByName("comments")[status].value='';


let xhr=new XMLHttpRequest();
xhr.onreadystatechange=function(){
if(xhr.readyState==4 && xhr.status==200){
	
	let childs=reply_wrap_box.childNodes;

	for(let i=childs.length-1;i>=1;i--){
		reply_wrap_box.removeChild(childs.item(i));
	}  
	
	let xml=xhr.responseXML;
	let comm=xml.getElementsByTagName("comm");
	for(let i=0;i<comm.length;i++){

		let content=comm[i].getElementsByTagName("content")[0].textContent;
		if(content!='null'){
			let reply_box=document.createElement("div");
			let reply_id=document.createElement("p");
			let reply_con=document.createElement("p");
			let reply_date=document.createElement("p");
			
			reply_box.className="reply_box";
			reply_id.className="reply_id";
			reply_con.className="reply_con";
			reply_date.className="reply_date";
			
			reply_box.appendChild(reply_id);
			reply_box.appendChild(reply_con);
			reply_box.appendChild(reply_date);
			
			let renum=comm[i].getElementsByTagName("renum")[0].textContent;
			let id=comm[i].getElementsByTagName("id")[0].textContent;
			let date=comm[i].getElementsByTagName("date")[0].textContent;
			let abnum=comm[i].getElementsByTagName("abnum")[0].textContent;
			
			reply_id.innerHTML=id;
			reply_con.innerHTML=content;
			reply_date.innerHTML=date;
							
			reply_wrap_box.appendChild(reply_box);

		}

		
	
		
	}
}
};
xhr.open('get','${pageContext.request.contextPath }/shop/commentlist?a_b_num='+a_b_num,true);
xhr.send();
}


</script>

	<div class="content">
		<div class="my_row">
		<!-- 상품설명 -->
			<div class="detail_box">
				<div class="left_box">
					<img src="${cp}/shop/productimgs/${vo.save_img_name}">
				</div>
				<form class="right_box" method="post" onsubmit="return checkData()">
				<div class="text_box">
					<h4>${vo.p_name}</h4>
					<h5 style="margin-top:50px;">가격</h5>
					<p>${vo.p_price}원</p>
					<input type="number" class="form-control" min="0" placeholder="수량" name="p_count" >
					<select name="p_size" class="form-select form-select-sm" aria-label=".form-select-sm example">
					  <option selected>사이즈</option>
					  <option value="M">M</option>
					  <option value="L">L</option>
					  <option value="XL">XL</option>
					</select>
				</div>
				<div class="btn_box">
					<input type="submit" formaction="${cp}/shop/goods_order?p_num=${vo.p_num}" class="btn btn-outline-dark" value="구매하기">
					<input type="submit" formaction="${cp}/shop/goods_cart?p_num=${vo.p_num}" class="btn btn-dark" style="margin-left:10px" value="장바구니">		
				</div>
				</form>
			</div>
		<!-- 상품설명 END -->
		
		
		
		
		<div class="board review_board">
		<h3>상품후기</h3>
		<div class="review_wrap">
		<c:forEach var="list" items="${rlist }" varStatus="status">
			<c:choose>			
				<c:when test="${not empty list.a_b_content }">
					<input class="a_b_num" id="a_b_num" type="hidden" value="${list.a_b_num }">
					<div class="review_box">
					<p class="review_id">${list.wr_id }</p>
					<p class="review_con">${list.a_b_content }</p>
					<p class="review_date">${list.wr_date }</p>
					<div class="reply_wrap" id="reply_wrap" class="reply_wrap">
					<div class="mb-3">
  						<label for="" class="form-label"></label>
						<textarea name="comments" id="comments" class="form-control" rows="1"></textarea>
						<button onclick="addComments(${list.a_b_num },${status.index });list(${status.index });" type="button" class="btn btn-outline-secondary">등록</button>
					</div>
					</div>
					<div class="reply_wrap_box">

					</div>
					<div class=""></div>
					</div>
						<script>
						/*페이지 접속시 댓글 노출*/
					 	function listAllReply(){
						 	//var a_b_num=document.getElementById("a_b_num").value;
							//var reply_wrap=document.getElementById("reply_wrap");
							
							var a_b_num=document.getElementsByClassName("a_b_num")[${status.index }].value;
							var reply_wrap_box=document.getElementsByClassName("reply_wrap_box")[${status.index }];
							
							let xhr=new XMLHttpRequest();
							xhr.onreadystatechange=function(){
							if(xhr.readyState==4 && xhr.status==200){
								
								let childs=reply_wrap_box.childNodes;

								for(let i=childs.length-1;i>=1;i--){
									reply_wrap_box.removeChild(childs.item(i));
								}  
								
								let xml=xhr.responseXML;
								let comm=xml.getElementsByTagName("comm");
								for(let i=0;i<comm.length;i++){
									
									/*<div class="reply_box">
									<p class="reply_id">댓글아이디</p>
									<p class="reply_con">댓글내용</p>
									<p class="reply_date">댓글날짜</p>
									</div> */
									let content=comm[i].getElementsByTagName("content")[0].textContent;
									if(content!='null'){
										let reply_box=document.createElement("div");
										let reply_id=document.createElement("p");
										let reply_con=document.createElement("p");
										let reply_date=document.createElement("p");
										
										reply_box.className="reply_box";
										reply_id.className="reply_id";
										reply_con.className="reply_con";
										reply_date.className="reply_date";
										
										reply_box.appendChild(reply_id);
										reply_box.appendChild(reply_con);
										reply_box.appendChild(reply_date);
										
										let renum=comm[i].getElementsByTagName("renum")[0].textContent;
										let id=comm[i].getElementsByTagName("id")[0].textContent;
										let date=comm[i].getElementsByTagName("date")[0].textContent;
										let abnum=comm[i].getElementsByTagName("abnum")[0].textContent;
										
										reply_id.innerHTML=id;
										reply_con.innerHTML=content;
										reply_date.innerHTML=date;
														
										reply_wrap_box.appendChild(reply_box);
									}
									
									
								
									
								}
							}
						};
						xhr.open('get','${pageContext.request.contextPath }/shop/commentlist?a_b_num='+a_b_num,true);
						xhr.send();
					}listAllReply();
						</script>
				</c:when>
			</c:choose>
		</c:forEach>
		

							


	 	<script>

	 	
	 	
	 	//댓글추가..
	 	function addComments(a_b_num,status){
	 		
	 		if(${sessionScope.id==null}){
	 			alert("로그인해주세요");
	 			return;
	 		}
	 		
	 		//var comments=document.getElementById("comments").value;
	 		var comments=document.getElementsByName("comments")[status].value;
	 		

	 		
	 		let xhr=new XMLHttpRequest();
	 		xhr.onreadystatechange=function(){
	 			if(xhr.readyState==4 && xhr.status==200){
	 				let xml=xhr.responseXML;
	 				let result=xml.getElementsByTagName("code")[0].textContent;
	 				listAllReply();
	 			}
	 		};
	 		xhr.open('post','${pageContext.request.contextPath }/shop/comments.do',true);
	 		//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
	 		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	 		let params="a_b_num="+a_b_num+"&comments="+comments;
	 		xhr.send(params);
	 	}
	 	</script>

		</div>
		</div>
	
		<!-- 문의 게시판 -->
		<div class="board question_board">
			<h3>문의게시판</h3>
			<table id="question_table" class="table table-striped table-hover" style="font-size:14px;">
			<tr style="text-align:center;border-bottom:1px solid #222;">
				<th scope="col" style="width:10%;">분류</th>
				<th scope="col" style="width:15%;">작성자</th>
				<th scope="col" style="width:55%;">제목</th>
				<th scope="col" style="width:20%;">작성일</th>
			</tr>
				
			</table>
			<!-- 문의 게시판 페이징 번호 -->
			<div class="board_page question_board_page">

		<c:if test="${startPageNum>10}">
				<a href="${cp }/shop/goods_detail?pageNum=${startPageNum-1 }&p_num=${vo.p_num}">이전페이지</a>
		</c:if>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }"><%--현재 페이지인경우 --%>
				<span style="color:black">[${i }]</span>
			</c:when>
		<c:otherwise>
				<a href="${cp }/shop/goods_detail?pageNum=${i }&p_num=${vo.p_num}" style="color:grey">[${i }]</a>
		</c:otherwise>
				</c:choose>
		</c:forEach>
		<c:if test="${endPageNum<pageCount}">
				<a href="${cp }/shop/goods_detail?pageNum=${endPageNum+1 }&p_num=${vo.p_num}">다음페이지</a>
		</c:if>
			
			
			
			
			
			
			
			
			<!-- 로그인해야만 작성하기 가능 -->
			<c:choose>
        	<c:when test="${not empty sessionScope.id }">
        		<button class="btn btn-dark" id="question_write" data-bs-toggle="modal" data-bs-target="#question_modal" type="button">작성하기</button>
        	</c:when>
        	<c:otherwise>
        		<button onclick="questionLoginMsg()" class="btn btn-dark" id="question_write" data-bs-toggle="" data-bs-target="" type="button">작성하기</button>
        	</c:otherwise>
        	</c:choose>
			</div>
		</div>
		<!-- 문의 게시판 END -->
		</div>
		<!-- my_row end -->
	</div>
	
	
	
	
	
	
	
	<!-- 문의글 쓰기 폼 -->
		<div id="qustionForm">
		<input id="p_num" name="p_num" type="hidden" value="${vo.p_num}">
		<div class="modal fade" id="question_modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
    	<div class="modal-content">
      	<div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">상품문의</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      	</div>
      	<div class="modal-body">
      	<select id="category" name="category" class="form-select form-select-sm" aria-label=".form-select-sm example">
  		<option selected>문의유형</option>
  		<option value="상품문의">상품문의</option>
  		<option value="배송문의">배송문의</option>
  		<option value="기타문의">기타문의</option>
		</select>
		<div class="mb-3">
  		<label for="" class="form-label"></label>
  		<input id="title" name="title" type="text" class="form-control" id="" placeholder="제목을 입력해주세요">
		</div>
		<div class="mb-3">
  		<label for="" class="form-label"></label>
  		<input id="pwd" name="pwd" type="password" class="form-control" id="" placeholder="비밀번호를 입력해주세요">
		</div>
		<div class="mb-3">
  		<label for="" class="form-label"></label>
  		<textarea id="content" name="content" class="form-control" id="" rows="10"></textarea>
		</div>
      	</div>
      	<!-- 문의글 쓰기 버튼영역 -->
      	<div class="modal-footer">
        <button id="closeBtn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button onclick="questionA()" type="button" class="btn btn-primary">등록</button>
      	</div>
    	</div>
 		</div>
		</div>
		</div>

	
<script type="text/javascript">

	function questionList(){
 	var question_table=document.getElementById("question_table");
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			
			let childs=question_table.childNodes;

			for(let i=childs.length-1;i>=2;i--){
				question_table.removeChild(childs.item(i));
			}  
			
			let xml=xhr.responseXML;
			let comm=xml.getElementsByTagName("comm");
			var category=document.getElementById("category");

			document.getElementById("title").value='';
			document.getElementById("pwd").value='';
			document.getElementById("content").value='';

			for(let i=0;i<comm.length;i++){
				let qnum=comm[i].getElementsByTagName("q_num")[0].textContent;
				let id=comm[i].getElementsByTagName("id")[0].textContent;
				let category=comm[i].getElementsByTagName("category")[0].textContent;
				let qtitle=comm[i].getElementsByTagName("qtitle")[0].textContent;
				let qcontent=comm[i].getElementsByTagName("qcontent")[0].textContent;
				let qdate=comm[i].getElementsByTagName("qdate")[0].textContent;
				let atitle=comm[i].getElementsByTagName("atitle")[0].textContent;
				let acontent=comm[i].getElementsByTagName("acontent")[0].textContent;
				let adate=comm[i].getElementsByTagName("adate")[0].textContent;
				
				var tr=document.createElement("tr");//제목행 tr 생성
				tr.style.textAlign="center";
				tr.style.borderBottom="1px solid #ddd";
				var td1=document.createElement("td");//분류 td
				var td2=document.createElement("td");//아이디 td
				var td3=document.createElement("td");//제목 td
				var a=document.createElement("a");//제목 열에 들어갈 a태그
				var div=document.createElement("div");//내용영역, 댓글창 wrapper
				var p=document.createElement("p");//문의게시판 내용영역
				div.className="question_content";
				div.appendChild(p);//div에 p를 삽입
				td3.appendChild(a);
				a.innerHTML=qtitle;
				a.style.fontSize="bold";
				a.style.cursor="pointer";
				a.onclick=function(){
					if('${sessionScope.id}'==id){
						this.href="${cp }/shop/question_detail?qnum="+qnum+"&p_num=${vo.p_num}";
					}else{
						alert("작성자만 조회가능합니다");
					}
				}


				p.innerHTML=qcontent;

				
				
				td3.appendChild(div);
				var td4=document.createElement("td");
				td1.innerHTML=category;
				td2.innerHTML=id;
				td4.innerHTML=qdate;
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				
				question_table.appendChild(tr);
				
				//문자열 변수는 따옴표로 묶어줘야하는데, 따옴표끼리 겹치는 경우가 발생한다
				/* 이럴때는 아래처럼 코드를 작성한다..*역슬러시를 사용하자
				let a='aaa';
				div.innerHTML="작성자:" + id +"<br>" + "내용"	+ comments +"<br>" +
						"<a href=\"javascript:delComments('" + a + "')\"> 삭제</a>"; */
				
				
			}
		}
	};
	xhr.open('get','${pageContext.request.contextPath }/shop/question.do?p_num=${vo.p_num}',true);
	xhr.send();
} questionList();



//로그인 메세지
function questionLoginMsg(){
	alert("로그인하세요");
}
//문의글 추가
function questionA(id){
	//파라미터 넘길 값

	var p_num=document.getElementById("p_num").value;
	var category=document.getElementById("category").value;
	var title=document.getElementById("title").value;
	var pwd=document.getElementById("pwd").value;
	var content=document.getElementById("content").value;

	if(category=='문의유형'){
		alert("문의유형을 선택하세요")
		return;
	}
	if(title==''){
		alert("제목을 입력하세요")
		return;
	}
	if(pwd==''){
		alert("비밀번호를 입력하세요")
		return;
	}
	if(content==''){
		alert("내용을 입력하세요")
		return;
	}
	
	var question_table=document.getElementById("question_table");
	
	let xhr=new XMLHttpRequest();
	
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){

			let result=xhr.responseText;

			let json=JSON.parse(result);

			
			if(json.result==true){
				document.getElementById("closeBtn").click();

				questionList();

			}else{
				alert("문의글 등록 실패");
			}
		}
	};
	xhr.open('post','${pageContext.request.contextPath }/shop/question.do',true);
	//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let params="category="+category+"&title="+title+"&content="+content+"&pwd="+pwd+"&p_num="+p_num;
	xhr.send(params);
}
</script>
	
	
	