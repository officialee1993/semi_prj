package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.StoragesDao;
import shop.vo.BasketList_vo;
import shop_dao.OrderDao;
import shop_dao.Salesdao;
@WebServlet("/shop/goods_order_ok")
public class Goods_order_ok_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	int b_num_max = Integer.parseInt(req.getParameter("b_num_max"));
	int p_num = Integer.parseInt(req.getParameter("p_num"));
	int ALL_SUM_PRICE = Integer.parseInt(req.getParameter("ALL_SUM_PRICE"));
	String rec_name = req.getParameter("rec_name"); 
	String rec_phone = req.getParameter("rec_phone"); 
	String rec_addr = req.getParameter("rec_addr"); 
	String payname = req.getParameter("payname"); 
	String p_size = req.getParameter("p_size"); 
	
	
	int p_count = Integer.parseInt(req.getParameter("p_count"));
	String O_STATE = "주문완료";
	
	
	HttpSession session = req.getSession();
	String id =(String)session.getAttribute("id");
	
	//System.out.println(b_num_max+" "+p_num+" "+rec_name+" "+rec_phone+" "+rec_addr+" "+payname+" "+ALL_SUM_PRICE);
	StoragesDao storagedao = StoragesDao.getinstance();
	OrderDao orderdao = OrderDao.getinstance();
	Salesdao salesdao = Salesdao.getinstance();
	

		
		int n = orderdao.goodorder_insert(rec_name, rec_phone, rec_addr, ALL_SUM_PRICE, payname, O_STATE, id, p_num, b_num_max);
		
		
		int m  = salesdao.Sales_stats_insert(ALL_SUM_PRICE, p_num,p_count);
		
		
		int s = storagedao.Storages_update(p_count, p_num, p_size);
		
		if(m>0) {
			System.out.println("매출통계 테이블 입력 성공");
			
		}else {
			System.out.println("매출통계 테이블 입력 실패");
		}
		if(s>0) {
			System.out.println("재고 테이블 입력 성공");
			
		}else {
			System.out.println("재고 테이블 입력 실패");
		}
		req.setAttribute("content", "/shop/goods_order_ok.jsp");


	req.setAttribute("top", "/shop/header.jsp");
	
	req.setAttribute("footer", "/shop/footer.jsp");

	req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
}
}
