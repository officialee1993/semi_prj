package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_category_vo;
@WebServlet("/admin/goods_delete")
public class Admin_GoodsdeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		
		Productdao productdao = Productdao.getinstance();
		int n = productdao.product_delete(p_num);
		
		if(n>0) {
			System.out.println("admin 包府磊 惑前 昏力 己傍");
		}else {
			System.out.println("admin 包府磊 惑前 昏力 角菩");
		}
		
		ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
		Productdao prodductdao = Productdao.getinstance();
		list = prodductdao.pro_cate_list();
		
		req.setAttribute("list", list);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/goods_list");
		
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
