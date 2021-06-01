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
		MultipartRequest mr = new MultipartRequest(req, // request 占쏙옙체
				saveDir, // 占쏙옙占싸듸옙占쏙옙 占쏙옙占썰리 占쏙옙占�
				1024 * 1024 * 5, // 占쌍댐옙 占쏙옙占싸듸옙 크占쏙옙(占쏙옙占쏙옙트)
				"utf-8", // 占쏙옙占쌘듸옙 占쏙옙占�
				new DefaultFileRenamePolicy()// 占쏙옙占쏙옙占쏙옙 占쏙옙占싹몌옙占쏙옙 占쏙옙占쏙옙占쌀쏙옙 占쏙옙占싹몌옙悶占� 占싹련뱄옙호(1,2,3,)占쏙옙 占쌕울옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
		);
		System.out.println("저장소 경로" + saveDir);
		
		//int p_num = Integer.parseInt(mr.getParameter("p_num"));
		String p_name = mr.getParameter("p_name");
		int p_count =  Integer.parseInt(mr.getParameter("p_count"));
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int cgb_num = Integer.parseInt(mr.getParameter("cgb_num"));// 占쏙옙占쏙옙 占쏙옙占쏙옙..
		String cgs_name = mr.getParameter("cgs_name"); // 占쏙옙占쏙옙 占쏙옙占쏙옙...
		String orgfileName = mr.getOriginalFileName("p_file");
		String savefileName = mr.getFilesystemName("p_file");
		
		//System.out.println(p_name+" "+ p_count+" "+ p_price+" "+ cgs_name +" "+orgfileName+" "+ savefileName );
		Productdao dao = Productdao.getinstance();
		
		int cg_id = dao.cg_idgetinfo(cgb_num , cgs_name);
		
		
		  Product_vo vo = new Product_vo(0, p_name, p_count, p_price, 0, null,
		 orgfileName, savefileName, cg_id); 
		  
		 
		 int n = dao.insert(vo); 
		 
		 if(n>0) { 
			
		 resp.sendRedirect(req.getContextPath()+"/admin/goods_insert"); } 
	
	}
}
