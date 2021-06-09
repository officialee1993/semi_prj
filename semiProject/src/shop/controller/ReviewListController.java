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
@WebServlet("/admin/review_list.do")
public class ReviewListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd=req.getParameter("cmd");
		
		if(cmd==null) {
			cmd="list";
			list(req,resp);
		}
	}
	
	private void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/x-json; charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		int p_num=Integer.parseInt(req.getParameter("p_num"));
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
		
		ReviewDao rdao=ReviewDao.getinstance();
		ArrayList<A_board_vo> list=rdao.goodsReviewList(p_num,startRow,endRow);

		int pageCount=(int)Math.ceil(rdao.getCount(p_num)/5.0);
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
			pw.print("<a_b_content>"+vo.getA_b_content()+"</a_b_content>");
			pw.print("<wr_id>"+vo.getWr_id()+"</wr_id>");
			pw.print("<a_b_num>"+vo.getA_b_num()+"</a_b_num>");
			pw.print("<wr_date>"+vo.getWr_date()+"</wr_date>");
			pw.print("</comm>");
		}
		pw.print("<pageCount>"+pageCount+"</pageCount>");
		pw.print("<startPageNum>"+startPageNum+"</startPageNum>");
		pw.print("<endPageNum>"+endPageNum+"</endPageNum>");
		pw.print("<pageNum>"+pageNum+"</pageNum>");
		
		pw.print("</result>");
		
	}
	
}
