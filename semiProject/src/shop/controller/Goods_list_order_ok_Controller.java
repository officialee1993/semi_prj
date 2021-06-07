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
@WebServlet("/shop/goods_list_order_ok")
public class Goods_list_order_ok_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		ArrayList<Basket_sum_price_vo> list = new ArrayList<Basket_sum_price_vo>();

		OrderDao orderdao = OrderDao.getinstance();
		
		
		
	
		String rec_name = req.getParameter("rec_name"); //������ �̸�
		String rec_phone = req.getParameter("rec_phone"); // ������ ��ȭ��ȣ
		String rec_addr = req.getParameter("rec_addr"); // ������ �ּ� 
		String payname = req.getParameter("payname"); //������
		String O_STATE = "�ֹ��Ϸ�";
		
		HttpSession session = req.getSession();
		String id =(String)session.getAttribute("id");
		
		//System.out.println(b_num_max+" "+p_num+" "+rec_name+" "+rec_phone+" "+rec_addr+" "+payname+" "+ALL_SUM_PRICE);
		
		Basketdao basketdao = Basketdao.getinstance();
		list = basketdao.basket_sum_price(id);
		if(list != null) {
	System.out.println("��ٱ��� sum_price ���� list ���� ");
		}else {
	System.out.println("��ٱ��� sum_price ���� list ���� ");
		}
		list.forEach((Basket_sum_price_vo t) -> {
			
//			System.out.println(t.getB_num());
//			System.out.println(t.getAll_sum_price());
//			System.out.println(t.getP_num());
			int n = orderdao.goodorder_insert(rec_name, rec_phone, rec_addr, t.getAll_sum_price(), payname, O_STATE, id, t.getP_num(), t.getB_num());
			if(n>0) {
				System.out.println("�ֹ� ����");
				
			}else {
				System.out.println("�ֹ� ����");
			}
		});
		
		
		

		
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/goods_order_ok.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");

		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
}
