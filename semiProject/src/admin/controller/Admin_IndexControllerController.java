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

@WebServlet("/admin/index")
public class Admin_IndexControllerController extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String sidemenu=(String)req.getAttribute("sidemenu");
	String content=(String)req.getAttribute("content");
	
	ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
	Productdao prodductdao = Productdao.getinstance();
	list = prodductdao.pro_cate_list();
	
	if(sidemenu==null) {
		sidemenu="/admin/sidemenu.jsp";
	}
	if(content==null) {
		content="/admin/goods_list.jsp";
	}
	
	String cp=req.getContextPath();
	ServletContext application=getServletContext();
	application.setAttribute("cp", cp);
	
	req.setAttribute("list", list);
	req.setAttribute("sidemenu", sidemenu);
	req.setAttribute("content", content);

	req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	
	}
}
