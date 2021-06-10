package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.vo.Members_vo;
import shop_dao.Membersdao;

@WebServlet("/shop/join")
public class JoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/shop/header.jsp");
		req.setAttribute("content", "/shop/join.jsp");
		req.setAttribute("footer", "/shop/footer.jsp");
		
		req.getRequestDispatcher("/shop/index.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		System.out.println(id+""+pwd+""+name+""+phone+" "+ email+" "+address);
		Members_vo vo = new Members_vo(id, pwd, name, phone, email, address);
		
		Membersdao dao = Membersdao.getinstance();
		int n = dao.insert(id, pwd, name, phone, email, address);
		
		if( n>0) {
			resp.sendRedirect(req.getContextPath()+"/shop/join_ok");
			
		}else {
			System.out.println("���� ");
			
		}
		
	}

}
