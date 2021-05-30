<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>insert.jsp</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/product/upload" enctype="multipart/form-data">

상품번호<br>
<input type="text" name ="p_num"><br>
상품이름<br>
<input type="text" name ="p_name"><br>
상품수량<br>
<input type="text" name ="p_count"><br>
상품가격<br>
<input type="text" name ="p_price"><br>
카테고리명<br>
<input type="text" name ="cg_name"><br>
첨부파일<br>
<input type="file" name ="p_file"><br>

<input type="submit" value ="전송">
</form>
</body>
</html>