package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.dao.Productdao;
import shop.vo.Product_vo;
@WebServlet("/admin/goods_insert")
public class Admin_GoodsInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/goods_insert.jsp");

		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String saveDir = getServletContext().getRealPath("/shop/productimgs");
		MultipartRequest mr = new MultipartRequest(req, 
				saveDir, 
				1024 * 1024 * 5, 
				"utf-8", 
				new DefaultFileRenamePolicy()
		);
		System.out.println("저장소 경로" + saveDir);
		
		//int p_num = Integer.parseInt(mr.getParameter("p_num"));
		String p_name = mr.getParameter("p_name");
		int p_count =  Integer.parseInt(mr.getParameter("p_count"));
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_id = Integer.parseInt(mr.getParameter("p_id"));
		String cg_name = mr.getParameter("cg_name"); 
		String orgfileName = mr.getOriginalFileName("p_file");
		String savefileName = mr.getFilesystemName("p_file");
		
		System.out.println("goodinsertcontroller: "+p_name+" "+ p_count+" "+p_id+" "+ p_price+" "+ cg_name +" "+orgfileName+" "+ savefileName );
		Productdao dao = Productdao.getinstance();
		
		int cg_id = dao.cg_idgetinfo(p_id , cg_name);
		
		
		  Product_vo vo = new Product_vo(0, p_name, p_count, p_price, 0, null,
		 orgfileName, savefileName, cg_id); 
		  
		 
		 int n = dao.insert(vo); 
		 
		 if(n>0) { 
			 System.out.println("상품등록 성공 ");
		 resp.sendRedirect(req.getContextPath()+"/admin/goods_insert"); } 
		 else {
			 System.out.println("상품 등록 실패 ");
		 }
	}
}
