package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.vo.A_board_vo;
import shop_dao.ReviewDao;
@WebServlet("/shop/commentlist")
public class CommentListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/x-json; charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		int a_b_num=Integer.parseInt(req.getParameter("a_b_num"));
		ReviewDao dao=ReviewDao.getinstance();
		ArrayList<A_board_vo> list=dao.replyList(a_b_num);
		System.out.println("댓글리스트"+list);
		System.out.println("댓글불러오기");
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/xml;charset=utf-8");
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.print("<result>");
		
		for(A_board_vo vo:list){
			pw.print("<comm>");
			pw.print("<renum>"+vo.getA_r_no()+"</renum>");
			pw.print("<id>"+vo.getRe_wr_id()+"</id>");
			pw.print("<content>"+vo.getA_r_content()+"</content>");
			pw.print("<date>"+vo.getRe_wr_date()+"</date>");
			pw.print("<abnum>"+vo.getRe_a_b_num()+"</abnum>");
			pw.print("</comm>");
		}
		pw.print("</result>");
	}

}
