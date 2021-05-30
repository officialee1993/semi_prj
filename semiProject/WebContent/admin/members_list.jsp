<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- 관리자 페이지 콘텐츠 영역 -->
	<div class="admin_content_wrap">
		<div class="title_wrap">
			<h3>회원관리</h3>
		</div>
		<div class="admin_content_box">
				<form>
			<div class="admin_goods_menu">
				<ul>
					<!-- 카테고리 -->
					<li class="category">
						<select class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option selected>아이디</option>
						  <option value="1">이름</option>
						</select>
						<input class="form-control form-control-sm" type="text" placeholder="" aria-label=".form-control-sm example">
					<!-- 검색버튼 -->
						<button type="button" onclick="" class="btn btn-outline-dark catrgory_btn">검색</button>
					</li>
				</ul>
			</div>
		</form>
		
			<div class="admin_goods_list admin_order_list">
			<table>
			<!-- 제목 -->
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>주소</th>
					<th></th>
				</tr>
				<!-- 반복문 실행 -->
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>
				<tr>
					<td>test</td>
					<td>홍길동</td>
					<td>010-1234-1234</td>
					<td>asd@asd.com</td>
					<td>서울</td>
					<td><button type="button" class="btn btn-outline-dark">삭제</button></td>
				</tr>

				
			</table>
			
			<div class="goods_pagenum">
				
				<span><a href="">1</a></span>
				
			</div>
			
			</div>

		</div>
	</div>