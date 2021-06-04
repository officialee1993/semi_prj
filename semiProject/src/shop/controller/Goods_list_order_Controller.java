package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.Productdao;
import shop.vo.BasketList_vo;
import shop.vo.Orders_vo;
import shop.vo.Product_vo;
import shop_dao.Basketdao;
import shop_dao.OrderDao;

@WebServlet("/shop/goods_list_order")
public class Goods_list_order_Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		Basketdao basketdao = Basketdao.getinstance();
		ArrayList<BasketList_vo> basketlistvo = new ArrayList<BasketList_vo>();
		
		int all_sum_price = basketdao.basket_all_sum_price(id);
		
		OrderDao orderdao = OrderDao.getinstance();
	 	Orders_vo  ordervo = orderdao.ordervoinfo();
	 	if(ordervo ==null) {
	 		
	 		basketlistvo= basketdao.notorder_basketlist(id);
	 		 
		 	if( basketlistvo !=null) {
		 		System.out.println("리스트 불러오기 성공");
		 	}else {
		 		System.out.println("리스트 불러오기 실패 ");
		 	}
	 	}else {
	 		
	 		basketlistvo= basketdao.basketlist(id);
	 		 
		 	if( basketlistvo !=null) {
		 		System.out.println("리스트 불러오기 성공");
		 	}else {
		 		System.out.println("리스트 불러오기 실패 ");
		 	}
		 	
	 	}
	 	
	 	req.setAttribute("all_sum_price", all_sum_price);
	 	req.setAttribute("basketlistvo", basketlistvo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_list_order.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}
}
