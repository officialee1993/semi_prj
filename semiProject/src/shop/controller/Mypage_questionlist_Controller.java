package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.vo.Q_board_vo;
import shop_dao.QuestionDao;
@WebServlet("/shop/mypage_questionlist")
public class Mypage_questionlist_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String id=(String)session.getAttribute("id");
		String spageNum=req.getParameter("pageNum");
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;

		QuestionDao dao=QuestionDao.getinstance();
		ArrayList<Q_board_vo> list=new ArrayList<Q_board_vo>();
		list=dao.myqList(id,startRow,endRow);
		
		
		
		int pageCount=(int)Math.ceil(dao.getCountMyPage(id)/10.0);
		
		//시작페이지 번호
		int startPageNum=((pageNum-1)/10*10)+1;//(pageNum%10)*10+1;
		//끝페이지 번호 
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("list", list);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("sidemenu", "/shop/mypage_sidemenu.jsp");
		req.setAttribute("content", "/shop/mypage_questionlist.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}
}
