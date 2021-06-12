package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.QuestionDao;
import shop.vo.A_board_vo;
import shop.vo.Q_board_vo;
import shop_dao.ReviewDao;
@WebServlet("/shop/mypage_reviewlist_detail")
public class Mypage_reviewlist_detail_Controller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd=req.getParameter("cmd");
		
		if(cmd.equals("list")) {
			list(req,resp);
		}else if(cmd.equals("replylist")) {
			replylist(req,resp);
		}else if(cmd.equals("delete")) {
			delete(req,resp);
		}
	}
	
	private void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int a_b_num=Integer.parseInt(req.getParameter("a_b_num"));

		ReviewDao dao=ReviewDao.getinstance();

		int n=dao.deleteReivew(a_b_num);
		
		System.out.println("삭제결과:"+n);
		resp.sendRedirect(req.getContextPath()+"/shop/mypage_reviewlist");
	}
	
	private void replylist(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/x-json; charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		int a_b_num=Integer.parseInt(req.getParameter("a_b_num"));
		String spageNum=req.getParameter("pageNum");
		
		if(spageNum.equals("undefined")) {
			spageNum=null;
		}
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*5+1;
		int endRow=startRow+4;

		ReviewDao dao=ReviewDao.getinstance();
		ArrayList<A_board_vo> list=dao.myReviewDetail(a_b_num,startRow,endRow);
		
		int pageCount=(int)Math.ceil(dao.getCountReply(a_b_num)/5.0);
		int startPageNum=((pageNum-1)/5*5)+1;
		int endPageNum=startPageNum+4;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}

		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/xml;charset=utf-8");
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.print("<result>");
		for(A_board_vo vo:list){
			pw.print("<comm>");
			pw.print("<a_r_no>"+vo.getA_r_no()+"</a_r_no>");
			pw.print("<re_wr_id>"+vo.getRe_wr_id()+"</re_wr_id>");
			pw.print("<a_r_content>"+vo.getA_r_content()+"</a_r_content>");
			pw.print("<re_wr_date>"+vo.getRe_wr_date()+"</re_wr_date>");
			pw.print("<re_a_b_num>"+vo.getRe_a_b_num()+"</re_a_b_num>");
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
		int a_b_num=Integer.parseInt(req.getParameter("a_b_num"));

		ReviewDao dao=ReviewDao.getinstance();

		A_board_vo vo=dao.getMyReview(a_b_num);
		
		req.setAttribute("vo", vo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("sidemenu", "/shop/mypage_sidemenu.jsp");
		req.setAttribute("content", "/shop/mypage_reviewlist_detail.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	
	
}
