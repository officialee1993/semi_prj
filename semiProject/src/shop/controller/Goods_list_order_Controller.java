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
import admin.dao.StoragesDao;
import shop.vo.BasketList_vo;
import shop.vo.Basket_add_storae_list_vo;
import shop.vo.Basket_vo;
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
		//ArrayList<Basket_vo> basket_all_list_vo = new ArrayList<Basket_vo>();
		ArrayList<Basket_add_storae_list_vo> basket_add_storae_list_vo = new ArrayList<Basket_add_storae_list_vo>();
		String[] str = req.getParameterValues("c1"); // 장바구니 번호 
		
//		for(int i=0; i<str.length; i++) {
//			System.out.println(str[i]);
//		}
		OrderDao orderdao = OrderDao.getinstance();
		Orders_vo ordervo = orderdao.ordervoinfo();
		StoragesDao storagesDao = StoragesDao.getinstance();

		
		
		int all_sum_price = 0;
		if (str != null) {
			if (ordervo == null) {

				for (int i = 0; i < str.length; i++) {
					int b_num = Integer.parseInt(str[i]);
					Basket_add_storae_list_vo vo = basketdao.notorder_checked_add_storage_basketlistvo(id, b_num);
					all_sum_price += vo.getP_price()*vo.getP_count();
					basket_add_storae_list_vo.add(vo);

					}
				} 
				else {
				for (int i = 0; i < str.length; i++) {
					int b_num = Integer.parseInt(str[i]);
					Basket_add_storae_list_vo vo = basketdao.checked_basketlist(id, b_num);
					all_sum_price += vo.getP_price()*vo.getP_count();
					basket_add_storae_list_vo.add(vo);
				}
			}

		} else {
			
			all_sum_price = basketdao.basket_nucheck_all_sum_price(id);
			
			
			if (ordervo == null) {
				basket_add_storae_list_vo = basketdao.notorder_add_storage_basketlist(id);
			} else {
				basket_add_storae_list_vo = basketdao.basket_all_list(id);
			}
			
		}
		req.setAttribute("all_sum_price", all_sum_price);
		req.setAttribute("basketlistvo", basket_add_storae_list_vo);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_list_order.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);

	}
}
