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
		<!-- 후기 게시판 -->
		<div class="board review_board">
			<h3>상품후기</h3>
			<table class="table table-striped table-hover" style="font-size:14px;">
			<tr style="text-align:center;border-bottom:1px solid #222;">
				<th scope="col" style="width:10%;">분류</th>
				<th scope="col" style="width:15%;">작성자</th>
				<th scope="col" style="width:55%;">제목</th>
				<th scope="col" style="width:20%;">작성일</th>
			</tr>
			<!-- 반복문 시작 -->
			<tr style="text-align:center;">
				<td>후기</td>
				<td>이찬호</td>
				<td>
				<a id="review_title" href="">제목
				</a>
				<div class="board_content review_content"><p>시들어 이는 모래뿐일 관현악이며, 같은 원대하고, 봄바람이다. 영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. 꽃이 생생하며, 밝은 그들은 꽃 바이며, 낙원을 어디 것이다. 할지니, 청춘을 충분히 열락의 새가 힘차게 두기 방지하는 끓는다. 밝은 듣기만 구하지 가진 것이 없으면 끓는 용기가 동력은 사막이다. 들어 청춘에서만 인간이 타오르고 찾아 노래하며 끓는 것이다. 영락과 청춘을 보이는 뿐이다.</p>
				
				<div class="comment_list review_comment_list">
				<!-- 댓글입력시 추가될 div className -->
				<div class="comment_box">
				<p class="writer">작성자</p>
				<span class="content">영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. </span>
				</div>
				
				<div class="comment_box review_comment_box">
				<p class="writer">작성자</p>
				<span class="content">영락과 얼마나 넣는 장식하는 두손을 보이는 동산에는 아름다우냐? 못할 든 이상의 전인 것이다. 뜨거운지라, 공자는 그들은 운다. 용감하고 열락의 위하여서 것이다. </span>
				</div>
				<!-- 댓글입력시 추가될 div className 끝 -->
				</div>
				<!-- 댓글 입력폼 -->
				<div class="mb-3" style="display:flex">
  				<label for="" class="form-label"></label>
  				<textarea class="form-control" id="" rows="1"></textarea>
  				<button type="button" class="btn btn-secondary" style="width:70px;margin-left:10px;">등록</button>
				</div>
				<!-- 댓글 입력폼 끝 -->
				</div>
				</td>
				<td>2021-05-28</td>
				
			</tr>
			<!-- 반복문 종료 -->
			<tr style="text-align:center;">
				<td>후기</td>
				<td>이찬호</td>
				<td>
				<a id="review_title" href="">제목
				</a>
				<div class="review_content"></div>
				</td>
				<td>2021-05-28</td>
			</tr>
			</table>
			<!-- 후기 게시판 페이징 번호 -->
			<div class="board_page review_board_page">
			<span>이전</span>
			<span>1</span>
			<span>다음</span>
			</div>
		</div>
		<!-- 후기 게시판 END -->
		
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
			<!-- 반복문 시작 -->
				<c:forEach var="list" items="${qlist }">
					<tr style="text-align:center;">
					<td>${list.category }</td>
					<td>${list.id }</td>
					<td id="thirdTd">
					<c:choose>
						<c:when test="${sessionScope.id==list.id }">
							<a href="${cp }/shop/question_detail?qnum=${list.q_num}&p_num=${vo.p_num}" id="review_title">${list.q_title }
							</a>
						</c:when>
						<c:otherwise>
						<a href="javascript:void();" onclick="questionRead();" id="review_title">${list.q_title }
							</a>
						<script>
						function questionRead(){
							alert("작성자만 조회가능합니다");
						}
						</script>
						</c:otherwise>
					</c:choose>
					</td>
					<td>${list.q_date }</td>
				</tr>
				</c:forEach>
			<!-- 반복문 종료 -->
			
			
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
//리스트 불러오기 	function questionList(){
/* 	var question_table=document.getElementById("question_table");
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			

			//기존 댓글목록 지우기
			

			let xml=xhr.responseXML;
			let comm=xml.getElementsByTagName("comm");
			
			if(comm.length>0)//댓글이 1개이상 존재하면 내용이 존재하지 않는 문구 tr을 삭제함
				document.getElementById("noneContent").style.display="none";

			for(let i=0;i<comm.length;i++){
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
				이럴때는 아래처럼 코드를 작성한다..*역슬러시를 사용하자
				let a='aaa';
				div.innerHTML="작성자:" + id +"<br>" + "내용"	+ comments +"<br>" +
						"<a href=\"javascript:delComments('" + a + "')\"> 삭제</a>";
				
				
			}
		}
	};
	xhr.open('get','${pageContext.request.contextPath }/shop/question.do?p_num=${vo.p_num}',true);
	xhr.send();
} questionList();  */
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

	var question_table=document.getElementById("question_table");
	
	let xhr=new XMLHttpRequest();
	
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("1");
			let result=xhr.responseText;
			console.log("2");
			let json=JSON.parse(result);
			console.log("3");
			
			if(json.result==true){
				console.log("4");
				document.getElementById("closeBtn").click();
				title="";
				pwd="";
				content="";
				location.href="${pageContext.request.contextPath }/shop/goods_detail?p_num="+p_num;

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
	
	
	