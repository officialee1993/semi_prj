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
@WebServlet("/shop/goods_list_pro")
public class Goods_list_pro_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int p_id = Integer.parseInt(req.getParameter("p_id")) ;
		String order = req.getParameter("order");
		ArrayList<Product_vo> new_list_all = new ArrayList<Product_vo>();
		ArrayList<Product_vo> low_list_all = new ArrayList<Product_vo>();
		ArrayList<Product_vo> high_list_all = new ArrayList<Product_vo>();
//		System.out.println(order);
//		System.out.println(p_id);
		if(p_id == 1) {
			//System.out.println(p_id);
			//System.out.println(order);
			if(order==null) {
			Productdao dao=Productdao.getinstance();
			req.setAttribute("list_all", dao.list_all(1));
			//System.out.println(order);
			}else if(order.equals("1")) {
				
				Productdao productdao = Productdao.getinstance();
				new_list_all =productdao.new_list_all(1);
				req.setAttribute("new_list_all", new_list_all);
			}else if(order.equals("2")) {
				
				Productdao productdao = Productdao.getinstance();
				low_list_all =productdao.low_list_all(1);
				req.setAttribute("low_list_all", low_list_all);
			}else if(order.equals("3")) {
				
				Productdao productdao = Productdao.getinstance();
				high_list_all =productdao.high_list_all(1);
				req.setAttribute("high_list_all", high_list_all);
			}
		}else if(p_id == 2) {
			if(order==null) {
				Productdao dao=Productdao.getinstance();
				req.setAttribute("list_all", dao.list_all(2));
			}else if(order.equals("1")) {
				
				Productdao productdao = Productdao.getinstance();
				new_list_all =productdao.new_list_all(2);
				req.setAttribute("new_list_all", new_list_all);
			}else if(order.equals("2")) {
				
				Productdao productdao = Productdao.getinstance();
				low_list_all =productdao.low_list_all(2);
				req.setAttribute("low_list_all", low_list_all);
			}else if(order.equals("3")) {
				
				Productdao productdao = Productdao.getinstance();
				high_list_all =productdao.high_list_all(2);
				req.setAttribute("high_list_all", high_list_all);
			}
		}
		
		req.setAttribute("optionIndex", order);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content","/shop/goods_list_pro.jsp" );
		req.setAttribute("footer", "/shop/footer.jsp");
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);

		
	}
}
