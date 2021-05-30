<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>index.jsp</title>
</head>
<body>
<!-- header -->
<jsp:include page="${top }"/>


<!-- content -->
<jsp:include page="${content }"/>


<!-- footer -->
<jsp:include page="${footer }"/>





<script type="text/javascript">
/*헤더 드롭다운*/
document.getElementById("header_menu").addEventListener('mouseover',function(){
document.getElementById("menu_dropdown").style.display='flex';
});
document.getElementById("menu_dropdown").addEventListener('mouseleave',function(){
menu_dropdown.style.display='none';
});
/*마이페이지 드롭다운*/
/* document.getElementById("header_mypage").addEventListener('click',function(){
document.getElementById("header_mypage_menu").style.display='block';
});
 */
/*문의글 등록*/
document.getElementById('question_write').addEventListener('click',function(){
document.getElementById('question_modal').focus();
});	

</script>
<!--<script type="text/javascript" src="js/main.js"></script>  -->
</body>
</html>







