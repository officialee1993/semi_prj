package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop_dao.Membersdao;
@WebServlet("/shop/login_find_pwd")
public class Login_find_pwd_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/login_find_pwd.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Membersdao dao= Membersdao.getinstance();
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		
		String pwd = dao.find_pwd(id, email);
		if(pwd !=null) {
			req.setAttribute("pwd", pwd);
			req.getRequestDispatcher("/shop/login").forward(req, resp);
			System.out.println("비밀번호 : "+ pwd);
		}else {
			System.out.println("아이디 없음");
		}
		
		
		
		
	}
}

