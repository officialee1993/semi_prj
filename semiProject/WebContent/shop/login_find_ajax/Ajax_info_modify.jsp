<%@page import="org.json.JSONObject"%>
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
	String pwd=request.getParameter("pwd");

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String id=(String)session.getAttribute("id");
	
	String getId="";
	String getPwd="";
	String getName="";
	String getPhone="";
	String getEmail="";
	String getAddress="";
	String result="";
	try{
		con=MyDBCP.getConnection();
		String sql="select * from members where id=? and pwd=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pwd);
		rs=pstmt.executeQuery();
		if(rs.next()){
			result="success";
			getId=rs.getString("id");
			getPwd=rs.getString("pwd");
			getName=rs.getString("name");
			getPhone=rs.getString("phone");
			getEmail=rs.getString("email");
			getAddress=rs.getString("address");
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		MyDBCP.close(con,pstmt,rs);
	}
	
	JSONObject json=new JSONObject();
	
	System.out.println("----------");
	System.out.println(getId);
	System.out.println(getPwd);
	System.out.println(getName);
	System.out.println(getPhone);
	System.out.println(getEmail);
	System.out.println(getAddress);
	
	json.put("id",getId);
	json.put("pwd",getPwd);
	json.put("name",getName);
	json.put("phone",getPhone);
	json.put("email",getEmail);
	json.put("addr",getAddress);
	json.put("result",result);
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	
	pw.print(json);


%>