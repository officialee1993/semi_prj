package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/shop/mypage_orderlist_review")
public class Mypage_orderlist_review_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("sidemenu", "/shop/mypage_sidemenu.jsp");
		req.setAttribute("content", "/shop/mypage_orderlist_review.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
