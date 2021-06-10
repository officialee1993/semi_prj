<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="my_row">
		<div class="mypage">
				<div class="mypage_sidemenu">
					<h3>마이페이지</h3>
					<jsp:include page="${sidemenu }"/>
				</div>
				<div class="mypage_orderlist">
					<h3>주문내역</h3>
					<form action="${cp}/shop/mypage_orderlist" method="post" onsubmit="return dateCheck()">
					<div style="margin-top:20px;display:flex;" class="orderDateWrap">
					<input value="${startDateStr }" type="date" id="startDate" name="startDate" value="${startDateStr }"><span style="padding:10px">~</span><input id="endDate" value="${endDateStr }" type="date" name="endDate" value="${endDateStr }">
					<button type="submit" class="btn btn-outline-dark" style="font-size:14px;margin-left:10px">검색</button>
					</div>
					</form>
					<script>
						function dateCheck(){
							var startDate=document.getElementById("startDate").value;
							var endDate=document.getElementById("endDate").value;
							if(startDate=='' || endDate==''){
								alert("시작일과 종료일을 모두 지정해주세요");
								return false;
							}else{
								return true;
							}
						}
					</script>

					<div class="mypage_orderlist_wrap">
						<table>
							<tr>
								<th></th>
								<th>상품명</th>
								<th>주문금액</th>
								<th>주문일자</th>
								<th>주문번호</th>
								<th>주문상태</th>
								<th></th>
							</tr>
							
							<c:forEach var="orderList" items="${requestScope.myOrderlist}">
								<c:choose>
									<c:when test="${orderList.o_state=='주문완료' }">
										<tr>
											<td><img src="${cp}/shop/productimgs/${orderList.save_img_name}"></td>
											<td>${orderList.p_name}</td>
											<td>${orderList.all_sum_price}원</td>
											<td>${orderList.o_date}</td>
											<td>${orderList.o_num}</td>
											<td style="color:#81d4fa">${orderList.o_state}</td>
											<td></td>
										</tr>
									</c:when>
									<c:when test="${orderList.o_state=='배송완료' }">
										<tr>
											<td><img src="${cp}/shop/productimgs/${orderList.save_img_name}"></td>
											<td>${orderList.p_name}</td>
											<td>${orderList.all_sum_price}원</td>
											<td>${orderList.o_date}</td>
											<td>${orderList.o_num}</td>
											<td style="font-weight:700">${orderList.o_state}</td>
											<c:choose>
												<c:when test="${orderList.a_b_content!=null }">
												<td><span style="font-size:14px;">후기작성완료</span></td>
												</c:when>
												<c:otherwise>
												<td><button onclick="location.href='${cp}/shop/mypage_orderlist_review?o_num=${orderList.o_num}'" type="button" class="btn btn-outline-dark" style="font-size:12px">후기작성</button></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</table>
					</div>
					
				<div style="margin-top:30px;text-align:center;">
				<c:if test="${startPageNum>10}">
				<a href="${cp }/shop/mypage_orderlist?pageNum=${startPageNum-1 }">이전페이지</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${pageNum==i }"><%--현재 페이지인경우 --%>
						<span style="color:black">[${i }]</span>
					</c:when>
				<c:otherwise>
						<a href="${cp }/shop/mypage_orderlist?pageNum=${i }&startDate=${startDateStr}&endDate=${endDateStr}" style="color:grey">[${i }]</a>
				</c:otherwise>
						</c:choose>
				</c:forEach>
				<c:if test="${endPageNum<pageCount}">
						<a href="${cp }/shop/mypage_orderlist?pageNum=${endPageNum+1 }">다음페이지</a>
				</c:if>
				</div>
					
				</div>
			</div>
		</div>
</div>
