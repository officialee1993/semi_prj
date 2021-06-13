<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="shop.db.MyDBCP"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String email=request.getParameter("email");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	System.out.println(id);
	System.out.println(email);
	
	String pwd="";
	try{
		con=MyDBCP.getConnection();
		String sql="select rpad(substr(pwd,1,length(pwd)/2),length(pwd),'*') pwd from members where id=? and email=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,email);
		rs=pstmt.executeQuery();
		if(rs.next()){
			pwd=rs.getString("pwd");
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		MyDBCP.close(con,pstmt,rs);
	}
	
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result>"+pwd+"</result>");
%>