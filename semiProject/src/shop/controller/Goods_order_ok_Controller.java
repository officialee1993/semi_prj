package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.vo.BasketList_vo;
import shop_dao.OrderDao;
import shop_dao.Salesdao;
@WebServlet("/shop/goods_order_ok")
public class Goods_order_ok_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	int b_num_max = Integer.parseInt(req.getParameter("b_num_max"));//占쏙옙袂占쏙옙球占싫�
	int p_num = Integer.parseInt(req.getParameter("p_num"));//占쏙옙품占쏙옙호
	int ALL_SUM_PRICE = Integer.parseInt(req.getParameter("ALL_SUM_PRICE"));// 占싼금억옙 
	String rec_name = req.getParameter("rec_name"); //占쏙옙占쏙옙占쏙옙 占싱몌옙
	String rec_phone = req.getParameter("rec_phone"); // 占쏙옙占쏙옙占쏙옙 占쏙옙화占쏙옙호
	String rec_addr = req.getParameter("rec_addr"); // 占쏙옙占쏙옙占쏙옙 占쌍쇽옙 
	String payname = req.getParameter("payname"); //占쏙옙占쏙옙占쏙옙
	int p_count = Integer.parseInt(req.getParameter("p_count"));
	String O_STATE = "주문완료";
	
	
	HttpSession session = req.getSession();
	String id =(String)session.getAttribute("id");
	
	//System.out.println(b_num_max+" "+p_num+" "+rec_name+" "+rec_phone+" "+rec_addr+" "+payname+" "+ALL_SUM_PRICE);
	
	OrderDao orderdao = OrderDao.getinstance();
	int n = orderdao.goodorder_insert(rec_name, rec_phone, rec_addr, ALL_SUM_PRICE, payname, O_STATE, id, p_num, b_num_max);
	Salesdao salesdao = Salesdao.getinstance();
	int m  = salesdao.Sales_stats_insert(ALL_SUM_PRICE, p_num,p_count);
	
	if(m>0) {
		System.out.println("성공");
		
	}else {
		System.out.println("실패");
	}
	
	req.setAttribute("top", "/shop/header.jsp");
	req.setAttribute("content", "/shop/goods_order_ok.jsp");
	req.setAttribute("footer", "/shop/footer.jsp");

	req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
}
}
