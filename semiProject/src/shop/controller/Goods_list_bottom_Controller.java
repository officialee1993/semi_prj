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
@WebServlet("/shop/goods_list_bottom")
public class Goods_list_bottom_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String order = req.getParameter("order");
		ArrayList<Product_vo> new_pro_list = new ArrayList<Product_vo>();
		ArrayList<Product_vo> low_pro_list = new ArrayList<Product_vo>();
		ArrayList<Product_vo> high_pro_list = new ArrayList<Product_vo>();
		int cg_id = Integer.parseInt(req.getParameter("cg_id"));
		int cg_id1 = Integer.parseInt(req.getParameter("cg_id1"));
		if(order==null) {
			//System.out.println(cg_id);
			//System.out.println(cg_id1);
			Productdao dao=Productdao.getinstance();
			req.setAttribute("pro_list", dao.pro_list(cg_id));
			req.setAttribute("pro_list1", dao.pro_list(cg_id1));
		}else if(order.equals("1")) {
			Productdao productdao = Productdao.getinstance();
			new_pro_list =productdao.new_pro_list(4,7);
			req.setAttribute("new_pro_list", new_pro_list);
		}else if(order.equals("2")) {
			Productdao productdao = Productdao.getinstance();
			low_pro_list =productdao.low_pro_list(4,7);
			req.setAttribute("low_pro_list", low_pro_list);
		}else if(order.equals("3")) {
			Productdao productdao = Productdao.getinstance();
			high_pro_list =productdao.high_pro_list(4,7);
			req.setAttribute("high_pro_list", high_pro_list);
		}
		
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_list_bottom.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");
		
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
