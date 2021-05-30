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
		MultipartRequest mr = new MultipartRequest(req, // request ��ü
				saveDir, // ���ε��� ���丮 ���
				1024 * 1024 * 5, // �ִ� ���ε� ũ��(����Ʈ)
				"utf-8", // ���ڵ� ���
				new DefaultFileRenamePolicy()// ������ ���ϸ��� �����ҽ� ���ϸ�ڿ� �Ϸù�ȣ(1,2,3,)�� �ٿ��� ���� ����
		);
		System.out.println("���ε� ���:" + saveDir);
		
		String p_num = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_count = mr.getParameter("p_count");
		String p_price = mr.getParameter("p_price");
		String cg_name = mr.getParameter("cg_name");
		String orgfileName = mr.getOriginalFileName("p_file");
		String savefileName = mr.getFilesystemName("p_file");
		
		
		
	}
}
