package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin/goods_modify")
public class Admin_GoodsModifyController extends HttpServlet{

	
	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String p_num = req.getParameter("p_num");
	
	req.setAttribute("p_num", p_num);
	req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
	req.setAttribute("content", "/admin/goods_modify.jsp");

	req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	
}
}
