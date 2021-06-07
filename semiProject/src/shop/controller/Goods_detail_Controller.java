package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.A_board_vo;
import shop.vo.CommentsVo;
import shop.vo.Product_vo;
import shop_dao.QuestionDao;
import shop_dao.ReviewDao;
@WebServlet("/shop/goods_detail")
public class Goods_detail_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		String spageNum=req.getParameter("pageNum");

		//후기목록 불러오기
		ReviewDao rdao=ReviewDao.getinstance();
		ArrayList<A_board_vo> rlist=rdao.goodsReviewList(p_num);
		System.out.println("test4"+rlist);
		
		//문의사항 페이징처리
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		
		//문의사항 글목록 불러오기
		QuestionDao qdao=QuestionDao.getinstance();
		ArrayList<CommentsVo> list=qdao.questionList(p_num,startRow,endRow);
		

		int pageCount=(int)Math.ceil(qdao.getCount(p_num)/10.0);

		int startPageNum=((pageNum-1)/10*10)+1;//(pageNum%10)*10+1;
		
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		Productdao dao = Productdao.getinstance();
		Product_vo vo= dao.getinfo(p_num);
		
		req.setAttribute("rlist", rlist);
		req.setAttribute("qlist", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("vo", vo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_detail.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}
}
