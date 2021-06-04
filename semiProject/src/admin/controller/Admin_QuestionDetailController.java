package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.QuestionDao;
import shop.vo.Q_board_vo;
@WebServlet("/admin/question_detail")
public class Admin_QuestionDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int qnum=Integer.parseInt(req.getParameter("qnum"));
		QuestionDao dao=QuestionDao.getinstance();
		Q_board_vo vo=dao.adminQDetail(qnum);
		
		req.setAttribute("vo", vo);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/question_detail.jsp");

		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String answer=req.getParameter("answer");
		int qnum=Integer.parseInt(req.getParameter("qnum"));
		
		QuestionDao dao=QuestionDao.getinstance();
		int n=dao.adminAnswer(qnum, answer);
		System.out.println(n);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/admin/question_list");
		}else {
			resp.sendRedirect(req.getContextPath()+"/admin/question_list");
		}
	}
}











