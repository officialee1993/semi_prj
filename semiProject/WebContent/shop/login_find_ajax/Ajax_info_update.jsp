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
	String pwd=request.getParameter("pwd");
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	String email=request.getParameter("email");
	String phone=request.getParameter("phone");
	
	Connection con=null;
	PreparedStatement pstmt=null;

	System.out.println(name);
	System.out.println(email);
	
	String result="";
	try{
		con=MyDBCP.getConnection();
		String sql="update members set pwd=?, name=?, address=?, email=?, phone=? where id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,pwd);
		pstmt.setString(2,name);
		pstmt.setString(3,addr);
		pstmt.setString(4,email);
		pstmt.setString(5,phone);
		pstmt.setString(6,id);
		int n=pstmt.executeUpdate();
		if(n>0){
			result="success";
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		MyDBCP.close(con,pstmt,null);
	}
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result>"+result+"</result>");
%>