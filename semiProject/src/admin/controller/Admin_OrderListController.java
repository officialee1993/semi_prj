package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import admin.dao.OrderDao;
import shop.vo.Orders_vo;
@WebServlet("/admin/order_list")
public class Admin_OrderListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd=req.getParameter("cmd");
		if(cmd==null) {
			cmd="list";
		}
		
		if(cmd.equals("list")) {
			list(req,resp);
		}else if(cmd.equals("update")) {
			update(req,resp);
		}
		
	}
	
	private void update(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int o_num=Integer.parseInt(req.getParameter("o_num"));
		OrderDao dao=OrderDao.getinstance();
		int n=dao.adminOrderStateUpdate(o_num);
		
		JSONObject json=new JSONObject();
		
		String result="";
		if(n>0) {
			System.out.println("updateComplete");
			result="success";
			json.put("result", result);
		}else {
			System.out.println("updateFail");
			json.put("result", result);
		}	
		
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(json);
	}

	//由ъ뒪�똿
	private void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*8+1;
		int endRow=startRow+7;
		OrderDao dao=OrderDao.getinstance();
		ArrayList<Orders_vo> list=dao.adminOrder(startRow,endRow,field,keyword);
		int pageCount=(int)Math.ceil(dao.getCount(field,keyword)/8.0);
		int startPageNum=((pageNum-1)/5*5)+1;
		int endPageNum=startPageNum+4;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}

		
		
		req.setAttribute("orderList", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/order_list.jsp");

		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}

}





























