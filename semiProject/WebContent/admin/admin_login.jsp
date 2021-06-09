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

    <h1 class="h3 mb-3 fw-normal"><img src="images/logo_org_white.png" style="width:60px"></h1>
    <div class="form-floating">
      <input name="id" type="text" class="form-control" id="adminId" placeholder="name@example.com">
      <label for="">ID</label>
    </div>
    <div class="form-floating">
      <input name="pwd" type="password" class="form-control" id="adminPwd" placeholder="Password">
      <label for="">Password</label>
    </div>
		<div style="display:flex;justify-content: space-between;">
		<button onclick="adminLogin()" class="w-100 btn btn-lg btn-primary" type="button" style="background-color:white;border:1px solid white;color:#e66465">Login</button>
		</div>

</main>

<script>
function adminLogin(){
	var adminId=document.getElementById("adminId").value;
	var adminPwd=document.getElementById("adminPwd").value;

	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
	if(xhr.readyState==4 && xhr.status==200){


	let xml=xhr.responseXML;
	let result=xml.getElementsByTagName("result")[0].textContent;
	if(result=='success'){
		location.href='${cp}/admin/index';
	}else if(result=='fail'){
		alert("정보가 맞지 않습니다");
	}
	
	}
	};
	xhr.open('post','${pageContext.request.contextPath }/admin/login',true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+adminId+"&pwd="+adminPwd);
}

</script>


</body>
</html>