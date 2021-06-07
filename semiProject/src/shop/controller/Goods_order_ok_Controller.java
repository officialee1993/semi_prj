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
	int b_num_max = Integer.parseInt(req.getParameter("b_num_max"));//��ٱ��Ϲ�ȣ
	int p_num = Integer.parseInt(req.getParameter("p_num"));//��ǰ��ȣ
	int ALL_SUM_PRICE = Integer.parseInt(req.getParameter("ALL_SUM_PRICE"));// �ѱݾ� 
	String rec_name = req.getParameter("rec_name"); //������ �̸�
	String rec_phone = req.getParameter("rec_phone"); // ������ ��ȭ��ȣ
	String rec_addr = req.getParameter("rec_addr"); // ������ �ּ� 
	String payname = req.getParameter("payname"); //������
	String O_STATE = "주문완료";
	HttpSession session = req.getSession();
	String id =(String)session.getAttribute("id");
	
	//System.out.println(b_num_max+" "+p_num+" "+rec_name+" "+rec_phone+" "+rec_addr+" "+payname+" "+ALL_SUM_PRICE);
	
	OrderDao orderdao = OrderDao.getinstance();
	int n = orderdao.goodorder_insert(rec_name, rec_phone, rec_addr, ALL_SUM_PRICE, payname, O_STATE, id, p_num, b_num_max);
	if(n>0) {
		System.out.println("�ֹ� ����");
		
	}else {
		System.out.println("�ֹ� ����");
	}
	
	req.setAttribute("top", "/shop/header.jsp");
	req.setAttribute("content", "/shop/goods_order_ok.jsp");
	req.setAttribute("footer", "/shop/footer.jsp");

	req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
}
}
