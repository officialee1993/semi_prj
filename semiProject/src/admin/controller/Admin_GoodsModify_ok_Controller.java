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
import shop.vo.Product_vo;
import shop_dao.Categorydao;


@WebServlet("/admin/goods_modify_ok")
public class Admin_GoodsModify_ok_Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		int p_id =0; 
		int p_num= Integer.parseInt(req.getParameter("p_num")) ;
		String str_p_id= req.getParameter("str_p_id") ;
		System.out.println("####################"+str_p_id);
		if(str_p_id.equals("남성")  ) {
			p_id = 1 ; 
		}else if(str_p_id.equals("여성") ) {
			p_id = 2; 
		}
		String cg_name= req.getParameter("cg_name");
		String p_name= req.getParameter("p_name");
		int p_price= Integer.parseInt(req.getParameter("p_price")) ;
		int p_count= Integer.parseInt(req.getParameter("p_count")) ;
		String save_img_name= req.getParameter("save_img_name");
		
		System.out.println(p_num +" "+p_id +" " + p_name +" "+ cg_name+" "+p_price+" "+p_count+" "+save_img_name);
		
		Categorydao categorydao = Categorydao.getinstance();
		Productdao productdao = Productdao.getinstance();
		int cg_id =categorydao.cg_id_select(cg_name,p_id);
		
		System.out.println("카테고리"+cg_id);
		

		if( save_img_name.length() ==0) {
			System.out.println("첨부파일 없는 경우 .");
			int n =productdao.product_not_img_update(p_num, p_name, p_price, p_count,  cg_id);
			System.out.println("첨부파일 없는 수정완료");
		}else {
			
			int n =productdao.productupdate(p_num, p_name, p_price, p_count, save_img_name, cg_id);
			if(n>0) {
				System.out.println("상품 수정 완료");
			}else {
				System.out.println("상품 수정 실패 ");
			}
			
		}
		
		
		ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
		Productdao prodductdao = Productdao.getinstance();
		list = prodductdao.pro_cate_list();
		
		req.setAttribute("list", list);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/goods_list.jsp");
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
