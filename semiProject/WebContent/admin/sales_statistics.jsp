<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>매출통계</h3>
		</div>
		
		
		<div class="admin_content_box">
			<div class="admin_goods_list admin_order_detail">
			<div class="order_info">
				<h5>매출 통계</h5>
				<div class="sales_date" >
				
					<button type="button" class="btn btn-outline-dark" onclick="kal_send(this.value)" value="1" name ="todays">오늘</button>
					<button type="button" class="btn btn-outline-dark" onclick="kal_send(this.value)" value="2" name ="months">이번달</button>
					<button type="button" class="btn btn-outline-dark" onclick="kal_send(this.value)" value="3" name ="years">올해</button>
					
					<!-- 날짜선택 -->
					<input type="date" name ="beforekal" ><span>~</span><input type="date" name = "afterkal">
					<button type="button" class="btn btn-outline-dark" onclick="kal_send()">검색</button>
					<span class="sales_result" id = "all_sum">총 주문금액 : ${all_sum} 원</span>
					
				</div>
				
			<script type="text/javascript">
		
			</script>
			
			
				<table id= "searchlist">
		
				<tr>
					<th width="10%">주문날짜</th>
					<th width="10%">총금액</th>
					<th width="10%">수량</th>
					<th width="10%">상품번호</th>
				</tr>
			
				<c:forEach var="vo" items="${requestScope.list}">
				<tr>
					<td>${vo.o_date}</td>
					<td>${vo.all_Sales}</td>
					<td>${vo.p_count}</td>
					<td>${vo.p_num}</td>
				</tr>
				</c:forEach>	
			
				</table>
			
				<!-- 페이지번호 -->
				<div id = "pagenum" class="goods_pagenum" >
					<c:if test="${startPageNum>10}">
					<a href="${cp}//admin/sales?pageNum=${startPageNum-1}">
					<span style="color: gray">[이전]</span>
					</a>
					</c:if>
					<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}">
					<c:choose>
					<c:when test="${i==pageNum}">
					<a href= "${cp}//admin/sales?pageNum=${i}">
					<span style="color: black">[${i}]</span></a>
					</c:when>
					<c:otherwise>
					<a href="${cp}//admin/sales?pageNum=${i}">
					<span style="color: gray">[${i}]</span>
					</a>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					<c:if test="${endPageNum<pageCount}">
					<a href="${cp}//admin/sales?pageNum=${endPageNum+1}">[다음]
					<span style="color: gray">[다음]</span></a>
					</c:if>
				</div>
				
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
		
		
		function kal_send(str,pgNum){
			
			var pagenum=document.getElementById("pagenum");
			let pgnum = pgNum;
			
			
			if(str == 1 ){
				var todays = document.getElementsByName("todays")[0].value;
			}else if(str ==2){
				var months = document.getElementsByName("months")[0].value;
			}else if(str ==3){
				var years = document.getElementsByName("years")[0].value;
			}
			
			var beforekal = document.getElementsByName("beforekal")[0].value;
			var afterkal = document.getElementsByName("afterkal")[0].value;
			
			var searchlist=document.getElementById("searchlist");
			
		
			let xhr = new XMLHttpRequest();
	
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					let all_sum = document.getElementById("all_sum");
					
					let childs=searchlist.childNodes;
					for(let i=childs.length-1;i>=1;i--){
						searchlist.removeChild(childs.item(i));
					}
					
					let pagenumchilds=pagenum.childNodes;
					for(let i=pagenumchilds.length-1;i>=1;i--){
						pagenum.removeChild(pagenumchilds.item(i));
					}  
					
					let xml = xhr.responseXML;
					let comm=xml.getElementsByTagName("comm");
					
					
					let pageCount=xml.getElementsByTagName("pageCount")[0].textContent;
					let startPageNum=xml.getElementsByTagName("startPageNum")[0].textContent;
					let endPageNum=xml.getElementsByTagName("endPageNum")[0].textContent;
					let pageNum=xml.getElementsByTagName("pageNum")[0].textContent;
					let choose=xml.getElementsByTagName("choose")[0].textContent;
					let all_sum1=xml.getElementsByTagName("all_sum")[0].textContent;
				
					
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
							a.style.color="gray";
							a.style.fontWeight="300";
							a.style.cursor="pointer"; 
							
							a.onclick=function(){
								kal_send(choose,i);
							}
							pagenum.appendChild(a);
						}
					}
					
					

					
					
					let trHead=document.createElement("tr");
					let th1=document.createElement("th");
					let th2=document.createElement("th");
					let th3=document.createElement("th");
					let th4=document.createElement("th");
				
					
					th1.innerHTML="주문날짜";
					th1.style.width="10%";
					th2.innerHTML="총금액";
					th2.style.width="10%";
					th3.innerHTML="수량";
					th3.style.width="10%";
					th4.innerHTML="상품번호";
					th4.style.width="20%";
					
					trHead.appendChild(th1);
					trHead.appendChild(th2);
					trHead.appendChild(th3);
					trHead.appendChild(th4);
					
					searchlist.appendChild(trHead);
					/* let sum=0; */
					
					
						for(let i=0;i<comm.length;i++){
						
						
						let o_date=comm[i].getElementsByTagName("o_date")[0].textContent;
						let all_sales=comm[i].getElementsByTagName("all_sales")[0].textContent;
						let p_count=comm[i].getElementsByTagName("p_count")[0].textContent;
						let p_num=comm[i].getElementsByTagName("p_num")[0].textContent;
						
						/* sum = sum + parseInt(all_sales); */
						
						let tr=document.createElement("tr");
						let td1=document.createElement("td");
						let td2=document.createElement("td");
						let td3=document.createElement("td");
						let td4=document.createElement("td");
						
						td1.innerHTML=o_date;
						td2.innerHTML=all_sales;
						td3.innerHTML=p_count;
						td4.innerHTML=p_num;
				
						tr.appendChild(td1);
						tr.appendChild(td2);
						tr.appendChild(td3);
						tr.appendChild(td4);
						
						searchlist.appendChild(tr);
						
					}
						all_sum.innerHTML= "총 주문금액 : "+all_sum1 +" 원";
				}
			};
		
			xhr.open('post','${pageContext.request.contextPath}/admin/sales_search_list',true)
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			let params = "beforekal=" + beforekal + "&afterkal=" + afterkal+ "&todays=" + todays + "&months=" + months+ "&years=" + years+ "&pageNum="+pgnum;
			xhr.send(params);
		}

		
		</script>
		
	</div>
    