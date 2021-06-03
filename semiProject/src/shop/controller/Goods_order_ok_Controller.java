package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop_dao.OrderDao;
@WebServlet("/shop/goods_order_ok")
public class Goods_order_ok_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	int b_num_max = Integer.parseInt(req.getParameter("b_num_max"));//장바구니번호
	int p_num = Integer.parseInt(req.getParameter("p_num"));//상품번호
	int ALL_SUM_PRICE = Integer.parseInt(req.getParameter("ALL_SUM_PRICE"));// 총금액 
	String rec_name = req.getParameter("rec_name"); //수령인 이름
	String rec_phone = req.getParameter("rec_phone"); // 수령인 전화번호
	String rec_addr = req.getParameter("rec_addr"); // 수령인 주소 
	String payname = req.getParameter("payname"); //결재방법
	String O_STATE = "주문완료";
	HttpSession session = req.getSession();
	String id =(String)session.getAttribute("id");
	
	//System.out.println(b_num_max+" "+p_num+" "+rec_name+" "+rec_phone+" "+rec_addr+" "+payname+" "+ALL_SUM_PRICE);
	
	OrderDao orderdao = OrderDao.getinstance();
	int n = orderdao.goodorder_insert(rec_name, rec_phone, rec_addr, ALL_SUM_PRICE, payname, O_STATE, id, p_num, b_num_max);
	if(n>0) {
		System.out.println("주문 성공");
		
	}else {
		System.out.println("주문 실패");
	}
	
	req.setAttribute("top", "/shop/header.jsp");
	req.setAttribute("content", "/shop/goods_order_ok.jsp");
	req.setAttribute("footer", "/shop/footer.jsp");

	req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
}
}
