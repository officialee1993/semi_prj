package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_vo;
import shop.vo.product_add_p_size_vo;

@WebServlet("/admin/goods_search")

public class Admin_GoodssearchController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		Productdao dao = Productdao.getinstance();
		String sex = req.getParameter("sex");
		
		String spageNum = req.getParameter("pageNum");  //현제 페이지(쪽수) 
		int pageNum = 1;
		if (spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int startRow = (pageNum - 1) * 8 + 1; 
		int endRow = startRow + 7;
		int pageCount =0;
		int startPageNum=0;
		int endPageNum=0;
	
		
		ArrayList<product_add_p_size_vo> list = new ArrayList<product_add_p_size_vo>();
		if(sex != null) {
		
			list = dao.admin_sex_pro_size_list(sex,startRow,endRow);
			
			pageCount = (int) Math.ceil(dao.admin_sex_pro_size_list_getCount(sex) / 8.0);
			
			System.out.println(pageCount);
			
			
			startPageNum = ((pageNum - 1) / 10 * 10) + 1; 
			endPageNum = startPageNum + 9;
			if (endPageNum > pageCount) {
				
				endPageNum = pageCount;
				
			}
			req.setAttribute("list", list);
			if(sex.equals("1")) {
				req.setAttribute("sex", "1");
			}else {
				req.setAttribute("sex", "2");
			}
			
			
		}else {
			
			String ct_gory = req.getParameter("ct_gory");
			String search = req.getParameter("search");
			
			Productdao productdao = Productdao.getinstance();
			
			if(ct_gory.equals("ALL")) {
				
				pageCount = (int) Math.ceil(dao.admin_all_product_select_getCount(search) / 8.0);
				
				System.out.println(pageCount);
				
				
				startPageNum = ((pageNum - 1) / 10 * 10) + 1; 
				endPageNum = startPageNum + 9;
				if (endPageNum > pageCount) {
					
					endPageNum = pageCount;
					
				}
				
				list = productdao.admin_all_product_select(search,startRow,endRow);
				req.setAttribute("all", "1");
				req.setAttribute("ct_gory", ct_gory);
				req.setAttribute("search", search);
				
			}else {
				
				pageCount = (int) Math.ceil(dao.admin_product_select_getCount(ct_gory,search) / 8.0);
				
				System.out.println(pageCount);
				
				
				startPageNum = ((pageNum - 1) / 10 * 10) + 1; 
				endPageNum = startPageNum + 9;
				if (endPageNum > pageCount) {
					
					endPageNum = pageCount;
					
				}
				list = productdao.admin_product_select(ct_gory, search,startRow,endRow);
				req.setAttribute("all", "1");
				req.setAttribute("ct_gory", ct_gory);
				req.setAttribute("search", search);
			}
			
			
			req.setAttribute("list", list);
		}
		
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);

		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/goods_list.jsp");

		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
		
	}
	
}
