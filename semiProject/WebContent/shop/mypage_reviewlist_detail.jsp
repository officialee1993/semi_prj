<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="my_row">
		<div class="mypage">
			<!-- 사이드메뉴 -->
			<div class="mypage_sidemenu">
				<h3>마이페이지</h3>
				<jsp:include page="${sidemenu }"/>
			</div>
			<!-- 문의내역 자세히 보기 -->
			<div id="mypage_orderlist" class="mypage_orderlist">
					<h3>구매후기</h3>
						<table class="goods_info">
						<tr>
							<th colspan="3">후기상품정보</th>
						</tr>
						<tr>
							<td></td>
							<td>상품명</td>
							<td>상품가격</td>
						</tr>
						<tr>
							<td><img src="${cp}/shop/productimgs/${vo.save_img_name}" style="width:100px"></td>
							<td><a href="${cp}/shop/goods_detail?p_num=${vo.p_num}">${vo.p_name }</a></td>
							<td>${vo.p_price }</td>
						</tr>
					</table>
						<form class="mypage_questionlist_detail">
						<div class="mb-3">
 						<label for="" class="form-label"></label>
  						<input value="${vo.a_b_title }" type="text" readonly class="form-control-plaintext" id="">
						</div>
						<div class="mb-3">
						<label for="" class="form-label"></label>
						<textarea readonly class="form-control-plaintext" id="" rows="5">${vo.a_b_content }</textarea>
						</div>
						<div class="btn_wrap" style="text-align:right;">
						<button type="button" class="btn btn-outline-dark" style="font-size:14px;" data-bs-toggle="modal" data-bs-target="#delete_modal">삭제</button>
						</div>
					</form>
				<div id="mypage_orderlist_reviewBox" class="mypage_orderlist_reviewBox">
				
				</div>
				</div>
		</div>
	</div>
</div>
<div class="modal fade" tabindex="-1" id="delete_modal">
  <div class="modal-dialog modal-dialog-centered" style="width:300px">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p style="text-align:center">후기를 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button style="font-size:12px;" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <button style="background-color:#222;font-size:12px" onclick="location.href='${cp}/shop/mypage_reviewlist_detail?cmd=delete&a_b_num=${vo.a_b_num}'" type="button" class="btn btn-primary">삭제</button>
      </div>
    </div>
  </div>
</div>


<script>
function replyList(pgNum){
	var mypage_orderlist=document.getElementById("mypage_orderlist");
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
	
			let xml=xhr.responseXML;
			let comm=xml.getElementsByTagName("comm");
			
			let pageCount=xml.getElementsByTagName("pageCount")[0].textContent;
			let startPageNum=xml.getElementsByTagName("startPageNum")[0].textContent;
			let endPageNum=xml.getElementsByTagName("endPageNum")[0].textContent;
			let pageNum=xml.getElementsByTagName("pageNum")[0].textContent;
			
			let replyPgNum=document.createElement("div");
			replyPgNum.style.marginTop="16px";
			replyPgNum.style.textAlign="center";
			
			let childs=mypage_orderlist_reviewBox.childNodes;
			for(let i=childs.length-1;i>=1;i--){
				mypage_orderlist_reviewBox.removeChild(childs.item(i));
			}  

			let pagenumchilds=replyPgNum.childNodes;
			for(let i=pagenumchilds.length-1;i>=1;i--){
				replyPgNum.removeChild(pagenumchilds.item(i));
			}  

			for(let i=startPageNum;i<=endPageNum;i++){
				if(pageNum==i){
					let span=document.createElement("span");
					span.innerHTML="["+i+"]";
					span.style.color="black";
					span.style.fontWeight="700";
					replyPgNum.appendChild(span);
				}else{
					let a=document.createElement("a");
					a.innerHTML="["+i+"]";
					a.style.color="grey";
					a.style.fontWeight="300";
					a.style.cursor="pointer";
					a.onclick=function(){
						replyList(i);
					}
					replyPgNum.appendChild(a);
				}
			}
			
			

			for(let i=0;i<comm.length;i++){
				let a_r_no=comm[i].getElementsByTagName("a_r_no")[0].textContent;
				let re_wr_id=comm[i].getElementsByTagName("re_wr_id")[0].textContent;
				let a_r_content=comm[i].getElementsByTagName("a_r_content")[0].textContent;
				let re_wr_date=comm[i].getElementsByTagName("re_wr_date")[0].textContent;
				let re_a_b_num=comm[i].getElementsByTagName("re_a_b_num")[0].textContent;
				
				let replyBox=document.createElement("div");
				replyBox.className="mypage_questionlist_detail_reply";
				let replyId=document.createElement("span");
				let replyContent=document.createElement("p");
				let replyDate=document.createElement("span");
				replyId.style.fontWeight="700";
				replyDate.style.fontSize="12px";
				
				replyBox.appendChild(replyId);
				replyBox.appendChild(replyContent);
				replyBox.appendChild(replyDate);
				
				replyId.innerHTML=re_wr_id;
				replyContent.innerHTML=a_r_content;
				replyDate.innerHTML=re_wr_date;
				
				mypage_orderlist_reviewBox.appendChild(replyBox);
				if(endPageNum>=2){
					mypage_orderlist_reviewBox.appendChild(replyPgNum);
				}
			}
		}
	};
	xhr.open('get','${pageContext.request.contextPath }/shop/mypage_reviewlist_detail?cmd=replylist&a_b_num=${vo.a_b_num }&pageNum='+pgNum,true);
	xhr.send();
}replyList();


function deleteOk(){
	
}





</script>


