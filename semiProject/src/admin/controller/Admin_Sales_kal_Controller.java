package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/sales_kal")
public class Admin_Sales_kal_Controller extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String beforekal = req.getParameter("beforekal");
	String afterkal = req.getParameter("afterkal");
	
	
	System.out.println(beforekal+" "+ afterkal);
}
}
