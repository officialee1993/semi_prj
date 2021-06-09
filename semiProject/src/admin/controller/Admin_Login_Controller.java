package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Membersdao;
import shop.vo.Members_vo;

@WebServlet("/admin/login")
public class Admin_Login_Controller extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		Membersdao dao=Membersdao.getinstance();
		Members_vo vo=dao.adminLogin(id, pwd);
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/xml;charset=utf-8");
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		String result="";
		if(vo!=null) {
			System.out.println("Admin Login Success");
			result="success";
		}else if(vo==null) {
			System.out.println("Admin Login Fail");
			result="fail";
		}
		pw.print("<result>"+result+"</result>");
		
	}
}
