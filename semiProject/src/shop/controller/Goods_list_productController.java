package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import admin.dao.Productdao;
import shop.vo.Product_vo;
@WebServlet("/shop/goods_list_product")
public class Goods_list_productController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String searchinput = req.getParameter("header_search_input");
		Productdao dao=Productdao.getinstance();
		req.setAttribute("list_product", dao.list_product(searchinput));
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content","/shop/goods_list_product.jsp" );
		req.setAttribute("footer", "/shop/footer.jsp");
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	
}
