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
					<span class="sales_result" id = "all_sum">총 주문금액 : ${all_sum}</span>
					
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
				<div class="goods_pagenum">
				<span><a href="">1</a></span>
				</div>
				
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
		
		
		function kal_send(str){
			
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
					
					
					let xml = xhr.responseXML;
					let comm=xml.getElementsByTagName("comm");
					
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
					let sum=0;
						for(let i=0;i<comm.length;i++){
						
						
						let o_date=comm[i].getElementsByTagName("o_date")[0].textContent;
						let all_sales=comm[i].getElementsByTagName("all_sales")[0].textContent;
						let p_count=comm[i].getElementsByTagName("p_count")[0].textContent;
						let p_num=comm[i].getElementsByTagName("p_num")[0].textContent;
						sum = sum + parseInt(all_sales);
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
						all_sum.innerHTML= "총 주문금액 : "+sum;
				}
			};
			
			xhr.open('post','${pageContext.request.contextPath}/admin/sales_search_list',true)
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			let params = "beforekal=" + beforekal + "&afterkal=" + afterkal+ "&todays=" + todays + "&months=" + months+ "&years=" + years;
			xhr.send(params);
		}

		
		</script>
		
	</div>
    