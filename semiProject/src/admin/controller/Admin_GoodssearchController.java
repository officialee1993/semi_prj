package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_vo;

@WebServlet("/admin/goods_search")

public class Admin_GoodssearchController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String sex = req.getParameter("sex");
		Productdao dao = Productdao.getinstance();
		ArrayList<Product_vo> list = new ArrayList<Product_vo>();
		if(sex != null) {
			
			list = dao.admin_sex_product_list(sex);
			req.setAttribute("list", list);
			
		}else {
			search(req, resp);
		}
		
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/goods_list.jsp");

		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
		
	}
	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		
		String ct_gory = req.getParameter("ct_gory");
		String search = req.getParameter("search");
		
		ArrayList<Product_vo> list = new ArrayList<Product_vo>();
		Productdao productdao = Productdao.getinstance();
		
		if(ct_gory.equals("ALL")) {
			list = productdao.admin_all_product_select(search);
			
		}else {
			
			list = productdao.admin_product_select(ct_gory, search);
		}
		if(list != null) {
			
			System.out.println("카테고리 검색에 따른 상품 출력 성공 ");
			
		}else {
			System.out.println("카테고리 검색에 따른 상품 출력 실패 ");
		}
		
		req.setAttribute("list", list);
	}
	
	
}
