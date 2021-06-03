package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
@WebServlet("/shop/goods_list")
public class Goods_list_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_list.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		Productdao dao=Productdao.getinstance();
		req.setAttribute("list", dao.list());
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
