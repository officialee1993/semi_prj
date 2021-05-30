<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content">
	<div class="my_row">
		<div class="mypage">
			<!-- 사이드메뉴 -->
			<div class="mypage_sidemenu">
				<h3>마이페이지</h3>
				<ul>
					<li><a href="${cp }/shop/mypage_orderlist">주문내역</a></li>
					<li><a href="${cp }/shop/mypage_reviewlist">구매후기</a></li>
					<li><a href="${cp }/shop/mypage_questionlist">문의내역</a></li>
					<li><a href="${cp }/shop/mypage_info_modify">개인정보수정</a></li>
				</ul>
			</div>
			<!-- 문의내역 -->
			<div class="mypage_orderlist">
					<h3>문의내역</h3>
					<div class="mypage_reviewlist_wrap">
						<table>
							<tr>
								<th width="25%">제목</th>
								<th width="50%">내용</th>
								<th width="15%">날짜</th>
								<th width="10%">답변상태</th>
							</tr>
							<!-- 답변대기일때 -->
							<tr>
								<td>질문제목</td>
								<td class="content">가는 이상 간에 철환하였는가? 이는 이상 하는 가슴에 청춘 새 노년에게서 것이다. 풀이 그들은 되는 앞이 갑 미인을 때까지 노래하며 사랑의 피다. 속에 붙잡아 못할 길을 그들을 청춘은 우리 부패뿐이다. 우리의 얼마나 그들에게 황금시대의 어디 따뜻한 구하지 크고 것은 운다. 인생을 시들어 붙잡아 이것이다. 대중을 희망의 반짝이는 보라. 곳이 싶이 놀이 얼음이 대고, 피가 힘차게 위하여 위하여서. 가치를 보이는 살았으며, 안고, 이상의 곧 별과 그리하였는가? 영원히 옷을 동산에는 못할 영락과 피가 끝까지 끓는 별과 이것이다.
								</td>
								<td>2020.02.02</td>
								<td style="color:#ddd">답변대기</td>
							</tr>
							<!-- 답변완료일때 -->
							<tr>
								<td class="title">가는 이상 간에 철환하였는가? 이는 이상 하는 가슴에 청춘 새 노년에게서 것이다. 풀이 그들은 되는 앞이 갑 미인을 때까지 노래하며 사랑의 피다. 속에 붙잡아</td>
								<td class="content"><a href="${cp }/shop/mypage_questionlist_detail">질문드립니다</a></td>
								<td>2020.02.02</td>
								<td style="color:#14aaff">답변완료</td>
							</tr>
						</table>
						
					</div>
				</div>
		</div>
	</div>
</div>
