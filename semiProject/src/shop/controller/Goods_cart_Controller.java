package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import admin.dao.Productdao;
import shop.vo.BasketList_vo;
import shop.vo.Basket_vo;
import shop.vo.Orders_vo;
import shop.vo.Product_vo;
import shop_dao.Basketdao;
import shop_dao.OrderDao;
@WebServlet("/shop/goods_cart")
public class Goods_cart_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BasketList_vo> basketlistvo = new ArrayList<BasketList_vo>();
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		Basketdao basketdao = Basketdao.getinstance();
		
		OrderDao orderdao = OrderDao.getinstance();
	 	Orders_vo  ordervo = orderdao.ordervoinfo();
	 	
	 	//페이징 처리 부분 
	 
		
		String spageNum = req.getParameter("pageNum");
	 	int pageNum =1; 
	 	if(spageNum != null) {
	 		pageNum = Integer.parseInt(spageNum);
	 	}
		int startRow = (pageNum - 1) * 5 + 1; 
		int endRow = startRow + 4;
		int startPageNum = ((pageNum - 1) / 5 * 5) + 1; 
		int endPageNum = startPageNum + 4;
		
	 	if(ordervo ==null) {
	 		
	 		basketlistvo= basketdao.notorder_basketlist(id,startRow,endRow);
	 		
	 		int pageCount = (int)Math.ceil(basketdao.notorder_basketlist_getCount(id)/ 5.0);
	 		System.out.println("pageCount "+pageCount);

			if (endPageNum > pageCount) {
				
				endPageNum = pageCount;
				
			}
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("endPageNum", endPageNum);
	 	}else {
	 		
	 		basketlistvo= basketdao.basketlist(id,startRow,endRow);
	 		
	 		int pageCount =(int)Math.ceil(basketdao.basketlist_getCount(id)/ 5.0);
	 		System.out.println("pageCount "+pageCount);

			if (endPageNum > pageCount) {
				
				endPageNum = pageCount;
				
			}
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("endPageNum", endPageNum);
	 	}
	 	
	 	
		
		
		req.setAttribute("startPageNum", startPageNum);
		
		req.setAttribute("pageNum", pageNum);
		System.out.println("startRow "+startRow +" endRow "+endRow+" startPageNum "+startPageNum+" endPageNum "+endPageNum);

	 	req.setAttribute("basketlistvo", basketlistvo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_cart.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		int p_count = Integer.parseInt(req.getParameter("p_count")); // ���� 
		String p_size = req.getParameter("p_size"); // ������ 
		ArrayList<BasketList_vo> basketlistvo = new ArrayList<BasketList_vo>();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		// 페이징 처리 부분 
		
		String spageNum = req.getParameter("pageNum");
	 	int pageNum =1; 
	 	if(spageNum != null) {
	 		pageNum = Integer.parseInt(spageNum);
	 	}
	 	
		int startRow = (pageNum - 1) * 5 + 1; 
		int endRow = startRow + 4;
		int startPageNum = ((pageNum - 1) / 5 * 5) + 1; 
		int endPageNum = startPageNum + 4;
	
		
	 	Basketdao basketdao = Basketdao.getinstance();
	 	int n = basketdao.insert(p_count, p_num, id, p_size);
	 
	 	
	 	OrderDao orderdao = OrderDao.getinstance();
	 	Orders_vo  ordervo = orderdao.ordervoinfo();
	 	if(ordervo ==null) {
	 		
	 		basketlistvo= basketdao.notorder_basketlist(id,startRow,endRow );
	 		int pageCount = (int) Math.ceil(basketdao.notorder_basketlist_getCount(id)/ 5.0);
	 		if (endPageNum > pageCount) {
				
				endPageNum = pageCount;
				
			}
	 		req.setAttribute("endPageNum", endPageNum);
	 		req.setAttribute("pageCount", pageCount);
	 	}else {
	 		
	 		basketlistvo= basketdao.basketlist(id,startRow,endRow);
	 		int n1 = basketdao.basketlist_getCount(id);
	 		System.out.println("게시글 개수 "+ n1);
	 		int pageCount =(int)Math.ceil(basketdao.basketlist_getCount(id)/ 5.0);
	 		
	 		if (endPageNum > pageCount) {
				
				endPageNum = pageCount;
				
			}
	 		req.setAttribute("pageCount", pageCount);
	 		req.setAttribute("endPageNum", endPageNum);
	 	}
	 	
	 	req.setAttribute("startPageNum", startPageNum);
		
		req.setAttribute("pageNum", pageNum);
	 	
		
		
	 	req.setAttribute("basketlistvo", basketlistvo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_cart.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
		}

}
