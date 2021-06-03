package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.vo.CommentsVo;
import shop_dao.QuestionDao;
@WebServlet("/shop/question_detail")
public class QuestionDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//문의글 번호받기
		int qnum=Integer.parseInt(req.getParameter("qnum"));
		
		QuestionDao dao=QuestionDao.getinstance();
		CommentsVo vo=dao.questionDetail(qnum);
		
		req.setAttribute("vo", vo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/question_detail.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pwd=req.getParameter("pwd");
		int qnum=Integer.parseInt(req.getParameter("qnum"));
		QuestionDao dao=QuestionDao.getinstance();
		int n=dao.questionDetail_pwd(qnum, pwd);
		System.out.println(n);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		String result="";
		if(n==1) {
			result="success";
		}else {
			result="fail";
		}
		System.out.println(result);
		pw.print("<result>"+result+"</result>");
	}
}
