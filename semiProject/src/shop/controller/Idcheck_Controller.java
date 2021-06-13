package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop_dao.Membersdao;
@WebServlet("/shop/idcheck")
public class Idcheck_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String cid= req.getParameter("cid");
	System.out.println(cid);
	Membersdao memberdao = Membersdao.getinstance();
	boolean find= memberdao.Idckeck(cid);
	System.out.println(find);
	
	resp.setContentType("text/xml;charset=utf-8");
	PrintWriter pw =resp.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	pw.print("<result>");
	if(find == true) {
	pw.print("<code>fail</code>");	
	}else {
		pw.print("<code>success</code>");
	}
		pw.print("</result>");
	}

}

