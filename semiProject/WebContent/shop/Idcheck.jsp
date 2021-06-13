<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.83.1">
<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<title>Insert title here</title>

</head>
  <body class="text-center">
<main class="form-signin">


    <div class="form-floating">
      <input type="text" class="form-control" id="c_id" placeholder="아이디 입력하세요">
      <label for="">ID</label>
    </div>
    <div id="result" style="color:red; font-size:20px"></div>

		<div style="display:flex;justify-content: space-between;">
		<input class="w-100 btn btn-lg btn-primary" type="button" id ="btn1" style="background-color:white;border:1px solid white;color:#e66465" value="확인">
		<input  class="w-100 btn btn-lg btn-primary" type="button" id ="btn2" style="background-color:white;border:1px solid white;color:#e66465" value="사용" >
		</div>

</main>

<script>
window.onload=function(e){
	
	var pid = window.opener.document.getElementById("id");
	var cid = document.getElementById("c_id");
	cid.value=pid.value; 
	
	var btn1=document.getElementById("btn1");  
	var btn2=document.getElementById("btn2"); 
	var result=document.getElementById("result");
	
	btn1.addEventListener('click', function(e) {
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				let xml = xhr.responseXML; //ajax로 가져오기 
				let code = xml.getElementsByTagName("code")[0].textContent;

				if (code == 'success') {
					
					result.innerHTML="사용가능한 아이디입니다.";
					btn2.disabled=false;
				} else {
				
					result.innerHTML="사용중인 아이디입니다.";
					btn2.disabled=true; 
				}
				
			}
		};
		xhr.open('get', '${pageContext.request.contextPath}/shop/idcheck?cid='+ cid.value , true);
		xhr.send(); 

		
		
	});
	btn2.addEventListener('click', function(e) {
		
		pid.value=cid.value;  
		self.close(); 
	});
}



</script>


</body>
</html>