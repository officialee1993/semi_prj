package admin.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/index")
public class Admin_IndexControllerController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sidemenu=(String)req.getAttribute("sidemenu");
		String content=(String)req.getAttribute("content");
		
		if(sidemenu==null) {
			sidemenu="/admin/sidemenu.jsp";
		}
		if(content==null) {
			content="/admin/goods_list.jsp";
		}
		
		String cp=req.getContextPath();
		ServletContext application=getServletContext();
		application.setAttribute("cp", cp);

		req.setAttribute("sidemenu", sidemenu);
		req.setAttribute("content", content);

		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
