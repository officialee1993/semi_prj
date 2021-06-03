package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.QuestionDao;
import shop.vo.Q_board_vo;
@WebServlet("/admin/question_list")
public class Admin_QuestionListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QuestionDao dao=QuestionDao.getinstance();
		ArrayList<Q_board_vo> list=new ArrayList<Q_board_vo>();
		list=dao.adminQList();
		
		req.setAttribute("qList", list);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/question_list.jsp");
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
