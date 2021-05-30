<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>상품목록</h3>
		</div>
		<div class="admin_content_box">
			<div class="admin_goods_menu">
				<ul>
					<li><a class="menu_btn" href="">남성</a></li>
					<li><a class="menu_btn" href="">여성</a></li>
					<!-- ajax로 ? -->
					<li class="category">
						<select class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option selected>카테고리</option>
						  <option value="1">ALL</option>
						  <option value="2">상의</option>
						  <option value="3">하의</option>
						  <option value="4">신발</option>
						</select>
						<input id="" class="form-control form-control-sm" type="text" placeholder="검색어를 입력해주세요" aria-label=".form-control-sm example">
						<button type="button" onclick="" class="btn btn-outline-dark catrgory_btn">검색</button>
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
					<th>생성일</th>
					<th>조회수</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><button onclick="location.href='${cp }/admin/goods_modify'" type="button" class="btn btn-outline-dark">수정</button></td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>

				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><button onclick="location.href='${cp }/admin/goods_modify'" type="button" class="btn btn-outline-dark">수정</button></td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><button onclick="location.href='${cp }/admin/goods_modify'" type="button" class="btn btn-outline-dark">수정</button></td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><button onclick="location.href='${cp }/admin/goods_modify'" type="button" class="btn btn-outline-dark">수정</button></td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				
				<tr>
					<td><img src="images/ex01.jpg" width="80px;" style="vertical-aling:middle"></td>
					<td>반팔</td>
					<td>5,000원</td>
					<td>10</td>
					<td>2021-05-05</td>
					<td>100</td>
					<td><button onclick="location.href='${cp }/admin/goods_modify'" type="button" class="btn btn-outline-dark">수정</button></td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				
			</table>
			
			<div class="goods_pagenum">
				
				<span><a href="">1</a></span>
				
			</div>
			
			</div>

		</div>
	</div>
<script>

</script>