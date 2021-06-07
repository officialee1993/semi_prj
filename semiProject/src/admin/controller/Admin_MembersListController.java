package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.vo.Members_vo;
import shop_dao.Membersdao;
@WebServlet("/admin/members_list")
public class Admin_MembersListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Membersdao dao = Membersdao.getinstance();
		ArrayList<Members_vo> all_members = new ArrayList<Members_vo>();
		all_members = dao.all_members();
		
		req.setAttribute("all_members", all_members);
		
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/members_list.jsp");
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
