package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop_dao.Membersdao;

@WebServlet("/shop/login_find_id")
public class Login_find_id_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/login_find_id.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Membersdao dao= Membersdao.getinstance();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		String id = dao.find_id(name, email);
		if(id !=null) {
			req.setAttribute("id", id);
			req.getRequestDispatcher("/shop/login").forward(req, resp);
			System.out.println("���̵� : "+ id);
		}else {
			System.out.println("���̵� ����");
		}
	}
}
