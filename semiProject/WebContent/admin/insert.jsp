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

��ǰ��ȣ<br>
<input type="text" name ="p_num"><br>
��ǰ�̸�<br>
<input type="text" name ="p_name"><br>
��ǰ����<br>
<input type="text" name ="p_count"><br>
��ǰ����<br>
<input type="text" name ="p_price"><br>
ī�װ���<br>
<input type="text" name ="cg_name"><br>
÷������<br>
<input type="file" name ="p_file"><br>

<input type="submit" value ="����">
</form>
</body>
</html>