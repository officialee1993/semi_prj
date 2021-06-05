package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_vo;
@WebServlet("/shop/goods_list_pro_shoes")
public class Goods_list_pro_shoes_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cg_id = Integer.parseInt(req.getParameter("cg_id"));
		String order = req.getParameter("order");
		ArrayList<Product_vo> pro_order_new_date = new ArrayList<Product_vo>();
		ArrayList<Product_vo> pro_order_low_price = new ArrayList<Product_vo>();
		ArrayList<Product_vo> pro_order_high_price = new ArrayList<Product_vo>();

		if(cg_id == 8) {
			if(order==null) {
				//System.out.println(cg_id);
				//System.out.println(cg_id1);
				Productdao dao=Productdao.getinstance();
				req.setAttribute("pro_list", dao.pro_list(8));
			}else if(order.equals("1")) {
				Productdao productdao = Productdao.getinstance();
				pro_order_new_date =productdao.pro_order_new_date(8);
				req.setAttribute("pro_order_new_date", pro_order_new_date);
			}else if(order.equals("2")) {
				Productdao productdao = Productdao.getinstance();
				pro_order_low_price =productdao.pro_order_low_price(8);
				req.setAttribute("pro_order_low_price", pro_order_low_price);
			}else if(order.equals("3")) {
				Productdao productdao = Productdao.getinstance();
				pro_order_high_price =productdao.pro_order_high_price(8);
				req.setAttribute("pro_order_high_price", pro_order_high_price);
			}
		}else if(cg_id == 5){
			if(order==null) {
				//System.out.println(cg_id);
				//System.out.println(cg_id1);
				Productdao dao=Productdao.getinstance();
				req.setAttribute("pro_list", dao.pro_list(5));
			}else if(order.equals("1")) {
				Productdao productdao = Productdao.getinstance();
				pro_order_new_date =productdao.pro_order_new_date(5);
				req.setAttribute("pro_order_new_date", pro_order_new_date);
			}else if(order.equals("2")) {
				Productdao productdao = Productdao.getinstance();
				pro_order_low_price =productdao.pro_order_low_price(5);
				req.setAttribute("pro_order_low_price", pro_order_low_price);
			}else if(order.equals("3")) {
				Productdao productdao = Productdao.getinstance();
				pro_order_high_price =productdao.pro_order_high_price(5);
				req.setAttribute("pro_order_high_price", pro_order_high_price);
			}
		}
		
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_list_pro_shoes.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");
		
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
