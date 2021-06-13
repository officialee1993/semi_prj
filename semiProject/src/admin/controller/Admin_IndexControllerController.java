package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Product_category_vo;
import shop.vo.pro_cate_storage_list_vo;

@WebServlet("/admin/index")
public class Admin_IndexControllerController extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String sidemenu=(String)req.getAttribute("sidemenu");
	String content=(String)req.getAttribute("content");
	
	//ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
	ArrayList<pro_cate_storage_list_vo> list1 = new ArrayList<pro_cate_storage_list_vo>();
	Productdao prodductdao = Productdao.getinstance();
	
	String spageNum = req.getParameter("pageNum");  //현제 페이지(쪽수) 
	int pageNum = 1;
	if (spageNum != null) {
		pageNum = Integer.parseInt(spageNum);
	}
	int startRow = (pageNum - 1) * 9 + 1; 
	int endRow = startRow + 8;
	
	int pageCount = (int) Math.ceil(prodductdao.pro_cate_list_getCount() / 9.0);
	System.out.println(pageCount);
	int startPageNum = ((pageNum - 1) / 10 * 10) + 1; 
	int endPageNum = startPageNum + 9;
	if (endPageNum > pageCount) {
		
		endPageNum = pageCount;
		
	}
	
	//list = prodductdao.pro_cate_list(startRow, endRow);
	
	list1= prodductdao.pro_cate_storage_list(startRow, endRow);
	
	if(sidemenu==null) {
		sidemenu="/admin/sidemenu.jsp";
	}
	if(content==null) {
		content="/admin/goods_list.jsp";
	}
	 
	
	String cp=req.getContextPath();
	ServletContext application=getServletContext();
	application.setAttribute("cp", cp);
	
	
	
	req.setAttribute("pageCount", pageCount);
	req.setAttribute("startPageNum", startPageNum);
	req.setAttribute("endPageNum", endPageNum);
	req.setAttribute("pageNum", pageNum);
	req.setAttribute("list", list1);
	//req.setAttribute("list", list);
	req.setAttribute("sidemenu", sidemenu);
	req.setAttribute("content", content);

	req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	
	}
}