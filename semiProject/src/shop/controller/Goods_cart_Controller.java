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
import shop.vo.Product_vo;
import shop_dao.Basketdao;
@WebServlet("/shop/goods_cart")
public class Goods_cart_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		int p_count = Integer.parseInt(req.getParameter("p_count")); // 수량 
		String p_size = req.getParameter("p_size"); // 사이즈 
		ArrayList<BasketList_vo> basketlistvo = new ArrayList<BasketList_vo>();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		Productdao dao = Productdao.getinstance();
		Product_vo vo =  dao.getinfo(p_num);
	 
	 	int price = vo.getP_price();
	 	
	 	Basketdao basketdao = Basketdao.getinstance();
	 	basketdao.insert(p_count, p_num, id, p_size);
	 	
	 	basketlistvo= basketdao.basketlist(id);
	 
	 	req.setAttribute("basketlistvo", basketlistvo);
//	 	req.setAttribute("p_count", p_count);
//	 	req.setAttribute("p_size", p_size);
//	 	req.setAttribute("price", price);
//	 	req.setAttribute("vo", vo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_cart.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	
		
}
}
