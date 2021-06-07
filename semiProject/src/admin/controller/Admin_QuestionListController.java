package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.OrderDao;
import admin.dao.QuestionDao;
import shop.vo.A_board_vo;
import shop.vo.Orders_vo;
import shop.vo.Q_board_vo;
@WebServlet("/admin/question_list")
public class Admin_QuestionListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd=req.getParameter("cmd");
		
		if(cmd==null) {
			cmd="list";
		}
		if(cmd.equals("list")) {
			list(req,resp);
		}else if(cmd.equals("search")) {
			search(req,resp);
		}
	}
	
	private void search(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/x-json; charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String fieldCategory=req.getParameter("field");
		String spageNum=req.getParameter("pageNum");
		
		if(spageNum.equals("undefined")) {
			spageNum=null;
		}
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		
		int startRow=(pageNum-1)*8+1;
		int endRow=startRow+7;
		
		QuestionDao dao=QuestionDao.getinstance();
		ArrayList<Q_board_vo> list=new ArrayList<Q_board_vo>();
		list=dao.adminQList(fieldCategory,startRow,endRow);
		
		int pageCount=(int)Math.ceil(dao.getCount(fieldCategory)/8.0);
		int startPageNum=((pageNum-1)/5*5)+1;
		int endPageNum=startPageNum+4;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/xml;charset=utf-8");
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.print("<result>");
		
		for(Q_board_vo vo:list){
			pw.print("<comm>");
			pw.print("<q_b_num>"+vo.getQ_b_num()+"</q_b_num>");
			pw.print("<id>"+vo.getId()+"</id>");
			pw.print("<q_b_category>"+vo.getQ_b_category()+"</q_b_category>");
			pw.print("<q_b_title>"+vo.getQ_b_title()+"</q_b_title>");
			pw.print("<q_b_content>"+vo.getQ_b_content()+"</q_b_content>");
			pw.print("<q_b__pwd>"+vo.getQ_b__pwd()+"</q_b__pwd>");
			pw.print("<wr_date>"+vo.getWr_date()+"</wr_date>");
			pw.print("<q_b_state>"+vo.getQ_b_state()+"</q_b_state>");
			pw.print("<p_num>"+vo.getP_num()+"</p_num>");
			pw.print("</comm>");
		}
		pw.print("<pageCount>"+pageCount+"</pageCount>");
		pw.print("<startPageNum>"+startPageNum+"</startPageNum>");
		pw.print("<endPageNum>"+endPageNum+"</endPageNum>");
		pw.print("<pageNum>"+pageNum+"</pageNum>");
		
		
		pw.print("</result>");
		
		
	}
	
	private void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*8+1;
		int endRow=startRow+7;
		
		QuestionDao dao=QuestionDao.getinstance();
		ArrayList<Q_board_vo> list=new ArrayList<Q_board_vo>();
		list=dao.adminQList(null,startRow,endRow);
		
		int pageCount=(int)Math.ceil(dao.getCount(null)/8.0);
		int startPageNum=((pageNum-1)/5*5)+1;
		int endPageNum=startPageNum+4;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		req.setAttribute("qList", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/question_list.jsp");
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
