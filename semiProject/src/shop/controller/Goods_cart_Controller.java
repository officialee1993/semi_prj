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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BasketList_vo> basketlistvo = new ArrayList<BasketList_vo>();
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		Basketdao basketdao = Basketdao.getinstance();
		basketlistvo= basketdao.basketlist(id);
		 
	 	if( basketlistvo !=null) {
	 		System.out.println("����Ʈ �ҷ����� ����");
	 	}else {
	 		System.out.println("����Ʈ �ҷ����� ���� ");
	 	}
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
		
	 	Basketdao basketdao = Basketdao.getinstance();
	 	int n = basketdao.insert(p_count, p_num, id, p_size);
	 	if(n>0) {
	 		System.out.println("��ٱ��� ���� ���� ");
	 	}else {
	 		System.out.println("��ٱ��� ���� ����");
	 	}
	 	
	 	basketlistvo= basketdao.basketlist(id);
	 
	 	if( basketlistvo !=null) {
	 		System.out.println("����Ʈ �ҷ����� ����");
	 	}else {
	 		System.out.println("����Ʈ �ҷ����� ���� ");
	 	}
	 	req.setAttribute("basketlistvo", basketlistvo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_cart.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
		}

}
