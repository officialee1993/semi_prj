//package shop.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import admin.dao.Productdao;
//import shop.vo.Product_vo;
//@WebServlet("/shop/goods_list_women_under")
//public class Goods_list_women_under_Controller extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int cg_id = Integer.parseInt(req.getParameter("cg_id")) ;
//		//System.out.println(cg_id);
//		
//		Productdao dao=Productdao.getinstance();
//		
//		ArrayList<Product_vo> wo_pro_vo = dao.pro_list(cg_id);
//		
//		if(wo_pro_vo != null) {
//			req.setAttribute("wo_pro_vo", wo_pro_vo);
//			System.out.println("리스트 불러오기 성공 ");
//		}else {
//			System.out.println("리스트 불러오기 실패 ");
//		}
//		
//		
//		
//		req.setAttribute("top", "/shop/header.jsp");
//		
//		if(cg_id == 3) {
//			req.setAttribute("content", "/shop/goods_list_wtop.jsp");
//		}else if(cg_id == 4) {
//			req.setAttribute("content", "/shop/goods_list_wbottom.jsp");
//		}else if(cg_id == 5) {
//			req.setAttribute("content", "/shop/goods_list_wshoes.jsp");
//		}
//		
//		req.setAttribute("footer", "/shop/footer.jsp");
//		
//		
//		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
//	}
//}
