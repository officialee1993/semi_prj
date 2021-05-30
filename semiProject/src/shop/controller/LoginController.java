package shop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.db.MyDBCP;
import shop_dao.Membersdao;


@WebServlet("/shop/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/login.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String id = req.getParameter("id");
		
			String pwd = req.getParameter("pwd");
	
			Membersdao dao = Membersdao.getinstance();
			boolean find =  dao.isMember(id, pwd);
			if(find) {
				HttpSession session = req.getSession();
				session.setAttribute("id", id);
				resp.sendRedirect(req.getContextPath()+"/shop/index");
			}else {
				resp.sendRedirect(req.getContextPath()+"/shop/login");
			}	
	}
}