package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/product/upload")
public class ProductuploadController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir = getServletContext().getRealPath("/shop/images");
		MultipartRequest mr = new MultipartRequest(req, // request 객체
				saveDir, // 업로드할 디렉토리 경로
				1024 * 1024 * 5, // 최대 업로드 크기(바이트)
				"utf-8", // 인코딩 방식
				new DefaultFileRenamePolicy()// 동일한 파일명이 존재할시 파일명뒤에 일련번호(1,2,3,)을 붙여서 파일 생성
		);
		System.out.println("업로드 경로:" + saveDir);
		
		String p_num = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_count = mr.getParameter("p_count");
		String p_price = mr.getParameter("p_price");
		String cg_name = mr.getParameter("cg_name");
		String orgfileName = mr.getOriginalFileName("p_file");
		String savefileName = mr.getFilesystemName("p_file");
		
		
		
	}
}
