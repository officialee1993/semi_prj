package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.vo.A_board_vo;
import shop_dao.ReviewDao;
@WebServlet("/shop/mypage_reviewlist_detail")
public class Mypage_reviewlist_detail_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//int a_b_num=Integer.parseInt(req.getParameter("a_b_num"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
/*		ReviewDao dao=ReviewDao.getinstance();
		ArrayList<A_board_vo> list=new ArrayList<A_board_vo>();*/
		//list=dao.myReviewDetail(a_b_num);
		//req.setAttribute("myReviewDetail", list);
		
		req.setAttribute("reviewTitle", title);
		req.setAttribute("reviewContent", content);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("sidemenu", "/shop/mypage_sidemenu.jsp");
		req.setAttribute("content", "/shop/mypage_reviewlist_detail.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
