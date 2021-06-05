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
@WebServlet("/admin/goods_list")
public class Admin_GoodsListController extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
	Productdao prodductdao = Productdao.getinstance();
	list = prodductdao.pro_cate_list();
	if(list !=null) {
		System.out.println("상품 list 불러오기 성공");
	}else {
		System.out.println("상품 list 불러오기 실패 ");
	}
	req.setAttribute("list", list);
	req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
	req.setAttribute("content", "/admin/goods_list.jsp");
	req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	
	}
}
