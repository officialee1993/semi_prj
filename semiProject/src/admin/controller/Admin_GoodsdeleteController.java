package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import admin.dao.StoragesDao;
import shop.vo.Product_category_vo;
@WebServlet("/admin/goods_delete")
public class Admin_GoodsdeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		String p_size = req.getParameter("p_size");
		
		Productdao productdao = Productdao.getinstance();
		StoragesDao storagesdao = StoragesDao.getinstance();
		
		int n = productdao.product_storages_delete(p_num,p_size);
		int count = storagesdao.Storages_p_num_count(p_num);
		if(count ==0) {
			 productdao.product_delete(p_num);
		}
		ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
		Productdao prodductdao = Productdao.getinstance();
		list = prodductdao.pro_cate_list();
		
		req.setAttribute("list", list);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/goods_list");
		
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
