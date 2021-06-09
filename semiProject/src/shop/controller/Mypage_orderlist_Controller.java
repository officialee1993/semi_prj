package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.vo.Orders_vo;
import shop.vo.Product_Orderlist_vo;
import shop_dao.OrderDao;

@WebServlet("/shop/mypage_orderlist")
public class Mypage_orderlist_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String id =(String)session.getAttribute("id");
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		
		OrderDao orderdao = OrderDao.getinstance();
		ArrayList<Product_Orderlist_vo> myOrderlist=orderdao.mypage_orderList(id,startRow,endRow);
		
		int pageCount=(int)Math.ceil(orderdao.getCountMyOrder(id)/10.0);
		
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
		req.setAttribute("myOrderlist", myOrderlist);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("sidemenu", "/shop/mypage_sidemenu.jsp");
		req.setAttribute("content", "/shop/mypage_orderlist.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
