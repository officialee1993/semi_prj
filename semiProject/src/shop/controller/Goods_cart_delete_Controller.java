package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop_dao.Basketdao;

@WebServlet("/shop/goods_cart_delete")
public class Goods_cart_delete_Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int b_num = Integer.parseInt(req.getParameter("b_num")) ;
	System.out.println(b_num);
	Basketdao dao = Basketdao.getinstance();
	int n =dao.basketdelete(b_num);
	
	if(n>0) {
		System.out.println("삭제 성공");
		resp.sendRedirect(req.getContextPath()+"/shop/goods_cart");
	}else {
		System.out.println("삭제 실패 ");
		resp.sendRedirect(req.getContextPath()+"/shop/goods_cart");
	}
	
	}
}
