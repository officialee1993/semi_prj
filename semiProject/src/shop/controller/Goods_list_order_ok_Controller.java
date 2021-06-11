package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.vo.Basket_sum_price_vo;
import shop_dao.Basketdao;
import shop_dao.OrderDao;
import shop_dao.Salesdao;
@WebServlet("/shop/goods_list_order_ok")
public class Goods_list_order_ok_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		ArrayList<Basket_sum_price_vo> list = new ArrayList<Basket_sum_price_vo>();

		OrderDao orderdao = OrderDao.getinstance();
		Salesdao salesdao = Salesdao.getinstance();
		
		String rec_name = req.getParameter("rec_name"); 
		String rec_phone = req.getParameter("rec_phone"); 
		String rec_addr = req.getParameter("rec_addr"); 
		String payname = req.getParameter("payname"); 
		String[] b_num =req.getParameterValues("b_num");
		
		
		String O_STATE = "주문완료";
		
		HttpSession session = req.getSession();
		String id =(String)session.getAttribute("id");
		
		Basketdao basketdao = Basketdao.getinstance();
		
		for(String s : b_num) {
			
			int reb_num = Integer.parseInt(s);
			
			list = basketdao.basket_sum_price(id,reb_num);
			
			list.forEach((Basket_sum_price_vo t) -> {
				
				int n = orderdao.goodorder_insert(rec_name, rec_phone, rec_addr, t.getAll_sum_price(), payname, O_STATE, id, t.getP_num(), t.getB_num());
				int m = salesdao.Sales_stats_insert(t.getAll_sum_price() ,t.getP_num() ,t.getP_count()); 
				
				if(m>0) {
				
					System.out.println("성공");
				
				}else {
				
					System.out.println("실패");
				
				}
				
			});
			
		}

		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_order_ok.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
