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
@WebServlet("/shop/goods_list_women")
public class Goods_list_women_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_list_women.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		Productdao dao=Productdao.getinstance();
		req.setAttribute("wo_list_all", dao.wo_list_all());
		
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
