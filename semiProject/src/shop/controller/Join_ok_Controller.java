package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/shop/join_ok")
public class Join_ok_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/join_ok.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}

}
