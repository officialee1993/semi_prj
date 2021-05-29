	/*헤더 드롭다운 */

	document.getElementById("header_menu").addEventListener('mouseover',function(){
		document.getElementById("menu_dropdown").style.display='flex';
	});
	document.getElementById("menu_dropdown").addEventListener('mouseleave',function(){
		menu_dropdown.style.display='none';
	});

	/*문의게시판 작성 팝업 */
  	
	document.getElementById('question_write').addEventListener('click',function(){
	document.getElementById('question_modal').focus();
	});