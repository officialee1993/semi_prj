package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.vo.Orders_vo;
import shop.vo.Product_Orderlist_vo;
import shop_dao.OrderDao;

@WebServlet("/shop/mypage_orderlist")
public class Mypage_orderlist_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Product_Orderlist_vo> list = new ArrayList<Product_Orderlist_vo>();
		OrderDao orderdao = OrderDao.getinstance();
		
		HttpSession session = req.getSession();
		String id =(String)session.getAttribute("id");
		list = orderdao.ordervo_list_info(id);
		if(list !=null) {
			System.out.println("장바구니 모든 주문list 불러오기 성공");
		}else {
			System.out.println("장바구니 모든 주문list 불러오기 실패 ");
		}
		
		req.setAttribute("list", list);
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("sidemenu", "/shop/mypage_sidemenu.jsp");
		req.setAttribute("content", "/shop/mypage_orderlist.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
