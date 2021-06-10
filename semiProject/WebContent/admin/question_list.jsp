<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>문의관리</h3>
		</div>
		<div class="admin_content_box">
		<form>
			<div class="admin_goods_menu">
				<ul>
					<!-- 카테고리 -->
					<li class="category">
						<select onchange="search(this.value)" id="fieldCategory" name="fieldCategory" class="form-select form-select-sm" aria-label=".form-select-sm example" style="height:30px;">
						  <option selected>문의분류</option>
						  <option value="상품문의">상품문의</option>
						  <option value="배송문의">배송문의</option>
						  <option value="기타문의">기타문의</option>
						</select>
					</li>
				</ul>
			</div>
		</form>
		
			<div class="admin_goods_list admin_order_list">
			<table id="question_table">
			<!-- 제목 -->
				<tr>
					<th width="10%">문의유형</th>
					<th width="10%">아이디</th>
					<th>제목</th>
					<th width="20%">답변상태</th>
					<th width="15%">문의날짜</th>
				</tr>
				<!-- 반복문 실행 -->
				<c:forEach var="qList" items="${qList }">
					<c:choose>
						<c:when test="${qList.q_b_state=='답변대기' }">
						<tr>
							<td>${qList.q_b_category }</td>
							<td>${qList.id }</td>
							<td><a href="${cp }/admin/question_detail?qnum=${qList.q_b_num}">${qList.q_b_title }</a></td>
							<td style="color:orange">${qList.q_b_state }</td>
							<td>${qList.wr_date }</td>
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<td>${qList.q_b_category }</td>
							<td>${qList.id }</td>
							<td><a href="${cp }/admin/question_detail?qnum=${qList.q_b_num}">${qList.q_b_title }</a></td>
							<td style="font-weight:700">${qList.q_b_state }</td>
							<td>${qList.wr_date }</td>
						</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				

			</table>
			
			<div id="pagenum" class="goods_pagenum">
				<c:if test="${startPageNum>5}">
				<a href="${cp }/admin/question_list?pageNum=${startPageNum-1 }">이전페이지</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${pageNum==i }"><%--현재 페이지인경우 --%>
						<span style="color:black;font-weight:700">[${i }]</span>
					</c:when>
				<c:otherwise>
						<a href="${cp }/admin/question_list?pageNum=${i }" style="color:grey;font-weight:300;">[${i }]</a>
				</c:otherwise>
						</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount}">
						<a href="${cp }/admin/question_list?pageNum=${endPageNum+1 }">다음페이지</a>
				</c:if>
				
			</div>
			
			</div>

		</div>
	</div>
	
	
	<script>
	
		function search(str,pgNum){
			var question_table=document.getElementById("question_table");
			var pagenum=document.getElementById("pagenum");
			
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					
					let childs=question_table.childNodes;
					for(let i=childs.length-1;i>=1;i--){
						question_table.removeChild(childs.item(i));
					}  
					
					let pagenumchilds=pagenum.childNodes;
					for(let i=pagenumchilds.length-1;i>=1;i--){
						pagenum.removeChild(pagenumchilds.item(i));
					}  
					
					let xml=xhr.responseXML;
					let comm=xml.getElementsByTagName("comm");
					
					
					
					let pageCount=xml.getElementsByTagName("pageCount")[0].textContent;
					let startPageNum=xml.getElementsByTagName("startPageNum")[0].textContent;
					let endPageNum=xml.getElementsByTagName("endPageNum")[0].textContent;
					let pageNum=xml.getElementsByTagName("pageNum")[0].textContent;
					
					for(let i=startPageNum;i<=endPageNum;i++){
						if(pageNum==i){
							let span=document.createElement("span");
							span.innerHTML="["+i+"]";
							span.style.color="black";
							span.style.fontWeight="700";
							pagenum.appendChild(span);
						}else{
							let a=document.createElement("a");
							a.innerHTML="["+i+"]";
							a.style.color="grey";
							a.style.fontWeight="300";
							a.style.cursor="pointer";
							
							a.onclick=function(){
								search(str,i);
							}
							pagenum.appendChild(a);
						}
					}

					let trHead=document.createElement("tr");
					let th1=document.createElement("th");
					let th2=document.createElement("th");
					let th3=document.createElement("th");
					let th4=document.createElement("th");
					let th5=document.createElement("th");
					
					th1.innerHTML="문의유형";
					th1.style.width="10%";
					th2.innerHTML="아이디";
					th2.style.width="10%";
					th3.innerHTML="제목";
					th4.innerHTML="답변상태";
					th4.style.width="20%";
					th5.innerHTML="문의날짜";
					th5.style.width="15%";
					
					trHead.appendChild(th1);
					trHead.appendChild(th2);
					trHead.appendChild(th3);
					trHead.appendChild(th4);
					trHead.appendChild(th5);
					
					question_table.appendChild(trHead);

					for(let i=0;i<comm.length;i++){
						let q_b_num=comm[i].getElementsByTagName("q_b_num")[0].textContent;
						let id=comm[i].getElementsByTagName("id")[0].textContent;
						let q_b_category=comm[i].getElementsByTagName("q_b_category")[0].textContent;
						let q_b_title=comm[i].getElementsByTagName("q_b_title")[0].textContent;
						let q_b_content=comm[i].getElementsByTagName("q_b_content")[0].textContent;
						let q_b__pwd=comm[i].getElementsByTagName("q_b__pwd")[0].textContent;
						let wr_date=comm[i].getElementsByTagName("wr_date")[0].textContent;
						let q_b_state=comm[i].getElementsByTagName("q_b_state")[0].textContent;
						let p_num=comm[i].getElementsByTagName("p_num")[0].textContent;
						
						
						
						let tr=document.createElement("tr");
						let td1=document.createElement("td");
						let td2=document.createElement("td");
						let td3=document.createElement("td");
						let td4=document.createElement("td");
						let td5=document.createElement("td");
						let a=document.createElement("a");
						
						if(q_b_state=='답변대기'){
							td4.style.color="orange";
						}else{
							td4.style.fontWeight="700";
						} 
						
						td1.innerHTML=q_b_category;
						td2.innerHTML=id;
						a.innerHTML=q_b_title;
						a.href="${cp}/admin/question_detail?qnum="+q_b_num;
						td3.appendChild(a);
						td4.innerHTML=q_b_state;

						
						td5.innerHTML=wr_date;
						
						tr.appendChild(td1);
						tr.appendChild(td2);
						tr.appendChild(td3);
						tr.appendChild(td4);
						tr.appendChild(td5);
						
						question_table.appendChild(tr);
						
					}
				}
			};
			xhr.open('get','${pageContext.request.contextPath }/admin/question_list?',true);
			xhr.send();
			
			xhr.open('post','${pageContext.request.contextPath }/admin/question_list',true);
			//post방식으로 요청시 콘텐트타입에서 인코딩방식 설정하기 - 꼭 해줘야 함
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			let params="cmd=search&field="+str+"&pageNum="+pgNum;
			xhr.send(params);
		}
	</script>
	
	