package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_vo;
@WebServlet("/shop/goods_cart")
public class Goods_cart_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int p_num = Integer.parseInt(req.getParameter("p_num"));
	 int p_count = Integer.parseInt(req.getParameter("p_count"));
	 String p_size = req.getParameter("p_size");
	 
	
	 Productdao dao = Productdao.getinstance();
	 Product_vo vo =  dao.getinfo(p_num);
	 int price = vo.getP_price();
	 	req.setAttribute("p_count", p_count);
	 	req.setAttribute("p_size", p_size);
	 	req.setAttribute("price", price);
	 	req.setAttribute("vo", vo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_cart.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
}
}
