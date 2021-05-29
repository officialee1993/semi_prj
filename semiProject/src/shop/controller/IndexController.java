package shop.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shop/index")
public class IndexController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String top=(String)req.getAttribute("top");
		String footer=(String)req.getAttribute("footer");
		if(top==null) {
			top="/shop/header.jsp";
		}
		if(footer==null) {
			footer="/shop/footer.jsp";
		}
		
		
		String cp=req.getContextPath();
		ServletContext application=getServletContext();
		application.setAttribute("cp", cp);
		req.setAttribute("top", top);
		req.setAttribute("footer", footer);
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}