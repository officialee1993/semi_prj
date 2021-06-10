package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.vo.Sales_stats_vo;
import shop_dao.Salesdao;

@WebServlet("/admin/sales")
public class Admin_SalesController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		Sales_stats_list(req, resp);
		
		
		
		
		req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
		req.setAttribute("content", "/admin/sales_statistics.jsp");
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);

	}

	private void Sales_stats_list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int all_sum = 0;
		Salesdao salesdao = Salesdao.getinstance();
		
		String spageNum = req.getParameter("pageNum");// 현재 페이지 쪽수 
		int pageNum = 1; 
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int startRow  = (pageNum-1)*15+1; 
		int endRow= startRow+14;
		
		int pageCount = (int)Math.ceil(salesdao.sales_stats_all_selete_getCount()/15.0);
		int startPageNum = ((pageNum-1)/10*10)+1;
		int endPageNum = startPageNum + 9; 
		if(endPageNum > pageCount) {
			endPageNum = pageCount;
		}
		
		ArrayList<Sales_stats_vo> list = salesdao.sales_stats_all_selete(startRow,endRow);
		ArrayList<Sales_stats_vo> list1 = salesdao.sales_stats_all_selete();
		for (Sales_stats_vo vo : list1) {

			all_sum += vo.getAll_Sales();

		}

		req.setAttribute("all_sum", all_sum);
		req.setAttribute("list", list);
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);

		
	}

	
}
