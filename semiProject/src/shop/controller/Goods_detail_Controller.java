package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_vo;
@WebServlet("/shop/goods_detail")
public class Goods_detail_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		
		Productdao dao = Productdao.getinstance();
		 Product_vo vo= dao.getinfo(p_num);
		 req.setAttribute("vo", vo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_detail.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}
}
