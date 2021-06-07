package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop_dao.ReviewDao;
@WebServlet("/shop/mypage_orderlist_review")
public class Mypage_orderlist_review_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int o_num=Integer.parseInt(req.getParameter("o_num"));
		
		req.setAttribute("o_num", o_num);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("sidemenu", "/shop/mypage_sidemenu.jsp");
		req.setAttribute("content", "/shop/mypage_orderlist_review.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int o_num=Integer.parseInt(req.getParameter("o_num"));
		String reviewTitle=req.getParameter("reviewTitle");
		String reviewContent=req.getParameter("reviewContent");

		HttpSession session=req.getSession();
		session.getAttribute("id");
		
		ReviewDao dao=ReviewDao.getinstance();
		int n=dao.reviewInsert(reviewTitle, reviewContent, o_num);
		
		System.out.println("리뷰등록결과:"+n);
		resp.sendRedirect(req.getContextPath()+"/shop/mypage_reviewlist");
		//req.getRequestDispatcher("/shop/mypage_reviewlist").forward(req, resp);
	}
}
