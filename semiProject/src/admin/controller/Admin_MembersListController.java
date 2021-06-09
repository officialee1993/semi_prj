package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Membersdao;
import shop.vo.Members_vo;
@WebServlet("/admin/members_list")
public class Admin_MembersListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
//		Membersdao dao = Membersdao.getinstance();
//		ArrayList<Members_vo> all_members = new ArrayList<Members_vo>();
//		all_members = dao.all_members();
//		
//		req.setAttribute("all_members", all_members);
		
	
		//페이징
		String field = req.getParameter("field");
		String keyword = req.getParameter("keyword");
		String spageNum = req.getParameter("pageNum");
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum = Integer.parseInt(spageNum);
		}
		Membersdao dao = Membersdao.getinstance();
		int startRow = (pageNum-1)*10+1;
		int endRow = startRow+9;
		
		ArrayList<Members_vo> list = dao.list(startRow, endRow, field, keyword);
		int pageCount = (int)Math.ceil(dao.getCount(field,keyword)/10.0);
		int startPageNum = ((pageNum-1)/10*10)+1;
		
		int endPageNum = startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum = pageCount;
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/members_list.jsp");
		
		
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
}
