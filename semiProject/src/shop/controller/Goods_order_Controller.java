package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.Productdao;
import shop.vo.Product_vo;
import shop_dao.Basketdao;
@WebServlet("/shop/goods_order")
public class Goods_order_Controller extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int p_num = Integer.parseInt(req.getParameter("p_num")); // ��ǰ��ȣ
		int p_count = Integer.parseInt(req.getParameter("p_count")); // ���� 
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		String p_size = req.getParameter("p_size"); //������ 
		Basketdao basketdao = Basketdao.getinstance();
		
		int n = basketdao.insert(p_count, p_num, id, p_size);// ��ٱ��� ��� 
		System.out.println("장바구니 삽입:"+n);
		int b_num_max = basketdao.basket_b_num_max(); //�ֱ� �ֹ� ��ٱ��Ϲ�ȣ 
		//System.out.println(basket_b_num_max);
		
		Productdao dao = Productdao.getinstance();
		Product_vo vo= dao.getinfo(p_num); // ��ǰ��ȣ 
		
		req.setAttribute("b_num_max",b_num_max);
		req.setAttribute("vo", vo);
		req.setAttribute("p_count", p_count);
		req.setAttribute("p_size", p_size);
		
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_order.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	
}
