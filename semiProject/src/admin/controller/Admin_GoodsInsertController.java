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
		MultipartRequest mr = new MultipartRequest(req, // request 객체
				saveDir, // 업로드할 디렉토리 경로
				1024 * 1024 * 5, // 최대 업로드 크기(바이트)
				"utf-8", // 인코딩 방식
				new DefaultFileRenamePolicy()// 동일한 파일명이 존재할시 파일명뒤에 일련번호(1,2,3,)을 붙여서 파일 생성
		);
		System.out.println("업로드 경로:" + saveDir);
		
		//int p_num = Integer.parseInt(mr.getParameter("p_num"));
		String p_name = mr.getParameter("p_name");
		int p_count =  Integer.parseInt(mr.getParameter("p_count"));
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int cgb_num = Integer.parseInt(mr.getParameter("cgb_num"));// 남성 여성..
		String cgs_name = mr.getParameter("cgs_name"); // 상의 하의...
		String orgfileName = mr.getOriginalFileName("p_file");
		String savefileName = mr.getFilesystemName("p_file");
		
		System.out.println(p_name+" "+ p_count+" "+ p_price+" "+ cgs_name +" "+orgfileName+" "+ savefileName );
		Productdao dao = Productdao.getinstance();
		
		int cg_id = dao.cg_idgetinfo(cgb_num , cgs_name);
		
		
		  Product_vo vo = new Product_vo(0, p_name, p_count, p_price, 0, null,
		 orgfileName, savefileName, cg_id); 
		  
		 
		 int n = dao.insert(vo); 
		 
		 if(n>0) { 
			 System.out.println("성공");
		 resp.sendRedirect(req.getContextPath()+"/admin/goods_insert"); } 
		 else {
		 System.out.println("실패"); 
	 }
		 
		 
	}
}
