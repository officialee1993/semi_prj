<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>상품목록</h3>
		</div>
		
		<script type="text/javascript">
		function checkData(){
			
			var ct_gory = document.getElementsByName("ct_gory")[0];
			var search = document.getElementsByName("search")[0];
			if(ct_gory.value == "카테고리"){
				alert("카테고리 체크하세요");
				ct_gory.focus();
				return false;
			}
			if(search.value.length == 0){
				alert("검색어 입력하세요");
				search.focus();
				return false;
			}
			return;
		}
		
		</script>
		<div class="admin_content_box">
			<div class="admin_goods_menu">
				<ul>
					<li><a class="menu_btn" href="${pageContext.request.contextPath}/admin/goods_search?sex=${1}">남성</a></li>
					<li><a class="menu_btn" href="${pageContext.request.contextPath}/admin/goods_search?sex=${2}">여성</a></li>
					
					
					
					<li class="category">
					
					<form action="${pageContext.request.contextPath}/admin/goods_search" method="post" onsubmit="return checkData();">
					<div>
						<select class="form-select form-select-sm" aria-label=".form-select-sm example" name="ct_gory">
						
						<option selected>카테고리</option>
						<option value="ALL">ALL</option>
						<option value="상의">상의</option>
						<option value="하의">하의</option>
						<option value="신발">신발</option>
						  
						</select>
					
						<input id="search" class="form-control form-control-sm" type="text" placeholder="검색어를 입력해주세요" aria-label=".form-control-sm example" name = "search" >						
					
						<input type="submit" value="검색">
					</div>
					
					</form>
					
					 </li>
					
					
				</ul>
			</div>
			<div class="admin_goods_list">
			<table>
				<tr>
					<th><!-- 상품이미지 열 --></th>
					<th>상품명</th>
					<th>가격</th>
					<th>재고</th>
					<th>사이즈</th>
					<th>생성일</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
		<c:forEach var="vo" items="${list}">
		
				<tr>
					<td><img src="${cp}/shop/productimgs/${vo.save_img_name}" width="80px" height="80px" style="vertical-aling:middle"></td>
					<td>${vo.p_name}</td>
					<td>${vo.p_price}원</td>
					<td>${vo.s_count}</td>
					<td>${vo.p_size}</td>
					<td>${vo.p_date}</td>
					<td><button onclick="location.href='${cp}/admin/goods_modify?p_num=${vo.p_num}&p_size=${vo.p_size}&s_count=${vo.s_count}'" type="button" class="btn btn-outline-dark">수정</button></td>
					<td><button onclick="location.href='${cp}/admin/goods_delete?p_num=${vo.p_num}'" type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				
		</c:forEach>
			</table>
			
			<div class="goods_pagenum">
				
				<c:choose>
				<c:when test="${sex=='1' }">
					<c:if test="${startPageNum>10 }">
					
							<a href="${cp }/admin/goods_search?sex=${1}&pageNum=${startPageNum-1 }">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
							<c:choose>
								<c:when test="${i==pageNum }">
									<a href="${cp }/admin/goods_search?sex=${1}&pageNum=${i}">
									<span style="color:black">[${i }]</span></a>
								</c:when>
								<c:otherwise>
									<a href="${cp }/admin/goods_search?sex=${1}&pageNum=${i}">
									<span style="color:gray">[${i }]</span></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>	
						<c:if test="${endPageNum<pageCount }">
							<a href="${cp }/admin/goods_search?sex=${1}&pageNum=${endPageNum+1 }">[다음]</a>
						</c:if>
						
					</c:when>
				<c:when test="${sex=='2' }">
					<c:if test="${startPageNum>10 }">
					
							<a href="${cp }/admin/goods_search?sex=${2}&pageNum=${startPageNum-1 }">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
							<c:choose>
								<c:when test="${i==pageNum }">
									<a href="${cp }/admin/goods_search?sex=${2}&pageNum=${i}">
									<span style="color:black">[${i }]</span></a>
								</c:when>
								<c:otherwise>
									<a href="${cp }/admin/goods_search?sex=${2}&pageNum=${i}">
									<span style="color:gray">[${i }]</span></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>	
						<c:if test="${endPageNum<pageCount }">
							<a href="${cp }/admin/goods_search?sex=${2}&pageNum=${endPageNum+1 }">[다음]</a>
						</c:if>
						
					</c:when>
					
					<c:when test="${all=='1' }">
					<c:if test="${startPageNum>10 }">
					
							<a href="${cp }/admin/goods_search?ct_gory=${ct_gory}&search=${search}&pageNum=${startPageNum-1 }">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
							<c:choose>
								<c:when test="${i==pageNum }">
									<a href="${cp }/admin/goods_search?ct_gory=${ct_gory}&search=${search}&pageNum=${i}">
									<span style="color:black">[${i }]</span></a>
								</c:when>
								<c:otherwise>
									<a href="${cp }/admin/goods_search?ct_gory=${ct_gory}&search=${search}&pageNum=${i}">
									<span style="color:gray">[${i }]</span></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>	
						<c:if test="${endPageNum<pageCount }">
							<a href="${cp }/admin/goods_search?ct_gory=${ct_gory}&search=${search}&pageNum=${endPageNum+1 }">[다음]</a>
						</c:if>
						
					</c:when>
					
					<c:otherwise>
					<c:if test="${startPageNum>10 }">
							<a href="${cp }/admin/goods_list?pageNum=${startPageNum-1 }">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
							<c:choose>
								<c:when test="${i==pageNum }">
									<a href="${cp }/admin/goods_list?pageNum=${i}">
									<span style="color:black">[${i }]</span></a>
								</c:when>
								<c:otherwise>
									<a href="${cp }/admin/goods_list?pageNum=${i}">
									<span style="color:gray">[${i }]</span></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>	
						<c:if test="${endPageNum<pageCount }">
							<a href="${cp }/admin/goods_list?pageNum=${endPageNum+1 }">[다음]</a>
						</c:if>
					</c:otherwise>
				</c:choose>
				
						

			</div>
			
			</div>

		</div>
	</div>
<script>

</script>