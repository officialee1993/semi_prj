package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.Productdao;
import shop.vo.BasketList_vo;
import shop.vo.Orders_vo;
import shop.vo.Product_vo;
import shop_dao.Basketdao;
import shop_dao.OrderDao;

@WebServlet("/shop/goods_list_order")
public class Goods_list_order_Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		Basketdao basketdao = Basketdao.getinstance();
		ArrayList<BasketList_vo> basketlistvo = new ArrayList<BasketList_vo>();
		String[] str = req.getParameterValues("c1");
		OrderDao orderdao = OrderDao.getinstance();
		Orders_vo ordervo = orderdao.ordervoinfo();
		int all_sum_price = 0;
		if (str != null) {
			if (ordervo == null) {

				for (int i = 0; i < str.length; i++) {
					int b_num = Integer.parseInt(str[i]);
					BasketList_vo vo = basketdao.notorder_checked_basketlistvo(id, b_num);
					all_sum_price += vo.getP_price()*vo.getP_count();
					basketlistvo.add(vo);

					}
				} else {
				for (int i = 0; i < str.length; i++) {
					int b_num = Integer.parseInt(str[i]);
					BasketList_vo vo = basketdao.checked_basketlist(id, b_num);
					all_sum_price += vo.getP_price()*vo.getP_count();
					basketlistvo.add(vo);
				}
			}

		} else {
			all_sum_price = basketdao.basket_all_sum_price(id);
			if (ordervo == null) {
				basketlistvo = basketdao.notorder_basketlist(id);
			} else {
				basketlistvo = basketdao.basketlist(id);
			}
		}
		req.setAttribute("all_sum_price", all_sum_price);
		req.setAttribute("basketlistvo", basketlistvo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_list_order.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);

	}
}
