package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.OrderDao;
import shop.vo.Orders_vo;
@WebServlet("/admin/order_detail")
public class Admin_OrderDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int o_num=Integer.parseInt(req.getParameter("onum"));
		OrderDao dao=OrderDao.getinstance();
		Orders_vo vo=dao.orderDetail(o_num);
		
		
		req.setAttribute("vo", vo);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/order_detail.jsp");

		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
