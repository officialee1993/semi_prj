package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import admin.dao.Productdao;
import shop.vo.Product_vo;
@WebServlet("/shop/goods_list")
public class Goods_list_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String order = req.getParameter("order");
		ArrayList<Product_vo> order_new_date = new ArrayList<Product_vo>();
		ArrayList<Product_vo> order_low_price = new ArrayList<Product_vo>();
		ArrayList<Product_vo> order_high_price = new ArrayList<Product_vo>();
		
		if(order==null) {
			Productdao dao=Productdao.getinstance();
			req.setAttribute("list", dao.list());
		}else if(order.equals("1")) {
			
			Productdao productdao = Productdao.getinstance();
			order_new_date =productdao.order_new_date();
			
			req.setAttribute("order_new_date", order_new_date);
		}else if(order.equals("2")) {
			
			Productdao productdao = Productdao.getinstance();
			order_low_price =productdao.order_low_price();
			
			req.setAttribute("order_low_price", order_low_price);
		}else if(order.equals("3")) {
			
			Productdao productdao = Productdao.getinstance();
			order_high_price =productdao.order_high_price();
			
			req.setAttribute("order_high_price", order_high_price);
		}

		System.out.println(order);

		req.setAttribute("optionIndex", order);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content","/shop/goods_list.jsp" );
		req.setAttribute("footer", "/shop/footer.jsp");
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	
}

