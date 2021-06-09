package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_category_vo;
@WebServlet("/admin/goods_list")
public class Admin_GoodsListController extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	Productdao prodductdao = Productdao.getinstance();
	String spageNum = req.getParameter("pageNum");  //현제 페이지(쪽수) 
	int pageNum = 1;
	if (spageNum != null) {
		pageNum = Integer.parseInt(spageNum);
	}
	int startRow = (pageNum - 1) * 8 + 1; 
	int endRow = startRow + 7;
	
	int pageCount = (int) Math.ceil(prodductdao.pro_cate_list_getCount() / 8.0);
	System.out.println(pageCount);
	int startPageNum = ((pageNum - 1) / 10 * 10) + 1; 
	int endPageNum = startPageNum + 9;
	if (endPageNum > pageCount) {
		
		endPageNum = pageCount;
		
	}

	ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
	
	list = prodductdao.pro_cate_list(startRow, endRow);
	
	req.setAttribute("pageCount", pageCount);
	req.setAttribute("startPageNum", startPageNum);
	req.setAttribute("endPageNum", endPageNum);
	req.setAttribute("pageNum", pageNum);

	
	req.setAttribute("list", list);
	req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
	req.setAttribute("content", "/admin/goods_list.jsp");
	req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	
	
	
	}
}
