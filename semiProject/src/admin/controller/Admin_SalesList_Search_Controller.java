package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.vo.Sales_stats_vo;
import shop_dao.Salesdao;

@WebServlet("/admin/sales_search_list")
public class Admin_SalesList_Search_Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		ArrayList<Sales_stats_vo> list = null;
		ArrayList<Sales_stats_vo> list1 = null;
		String todays = req.getParameter("todays");
		String months = req.getParameter("months");
		String years = req.getParameter("years");
		String spageNum = req.getParameter("pageNum");
		String sum = req.getParameter("sum");
		
		//System.out.println(todays + " " + months + " " + years);

		Salesdao salesdao = Salesdao.getinstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String strToday = sdf.format(cal.getTime());//현재 날짜 
		DecimalFormat formatter = new DecimalFormat("###,###");
		int all_sum = 0;
		String sall_sum = null; 
		
	
		int pageNum=1;
		System.out.println(spageNum);	
		
		if(!spageNum.equals("undefined")) {
			pageNum=Integer.parseInt(spageNum);
			//System.out.println("pageNum: "+pageNum);
		}
		
		int startRow=(pageNum-1)*15+1;
		int endRow=startRow+14;
		
		int startPageNum= 0;
		int endPageNum=0;
		
		int pageCount =0;
		
		String choose = null; 
		
		if (todays.equals("1") && months.equals("undefined") && years.equals("undefined")) {// 오늘

			String strTodayend = strToday + "-23-59";

		//	 System.out.println(strToday+" "+ strTodayend+" " +startRow+" " + endRow);
			 
			list = salesdao.Sales_stats_kal_select(strToday, strTodayend,startRow,endRow );
			
			list1 = salesdao.Sales_stats_kal_select(strToday, strTodayend);
			for (Sales_stats_vo vo : list1) {
				all_sum += vo.getAll_Sales();
				sall_sum = formatter.format(all_sum);
			}
			
			pageCount=(int)Math.ceil(salesdao.sales_stats_search_all_selete_getCount(strToday,strTodayend)/15.0);
			startPageNum= ((pageNum - 1) / 10 * 10) + 1; 
			endPageNum = startPageNum + 9;
			 
			if(endPageNum>pageCount) {
				endPageNum=pageCount;
			}
			
			//System.out.println("all_sum" + all_sum);

			req.setAttribute("all_sum", all_sum);
			req.setAttribute("list", list);
			choose = "1"; 
			// System.out.println("Today=" + strToday);

		} else if (todays.equals("undefined") && months.equals("2") && years.equals("undefined")) {// 한당

			String strmonths = strToday.substring(0, 8) + "01";

			int year = Integer.parseInt(strToday.substring(0, 4));
			int month = Integer.parseInt(strToday.substring(5, 7));
			int day = Integer.parseInt(strToday.substring(8, 10));
			System.out.println(year + " " + month + " " + day);

			cal.set(year, month - 1, day);
			int lastmonthday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			String strmonthsend = strToday.substring(0, 8) + lastmonthday + "-23-59";

			System.out.println(strmonths + " " + strmonthsend);

			
			list = salesdao.Sales_stats_kal_select(strmonths, strmonthsend,startRow,endRow );
			
			list1 = salesdao.Sales_stats_kal_select(strmonths, strmonthsend );
			for (Sales_stats_vo vo : list1) {
				all_sum += vo.getAll_Sales();
				sall_sum = formatter.format(all_sum);
			}
			
			pageCount=(int)Math.ceil(salesdao.sales_stats_search_all_selete_getCount(strmonths,strmonthsend)/15.0);
			startPageNum= ((pageNum - 1) / 10 * 10) + 1; 
			endPageNum = startPageNum + 9;
			 
			if(endPageNum>pageCount) {
				endPageNum=pageCount;
			}
			
			
			
			System.out.println("all_sum" + all_sum);
			req.setAttribute("all_sum", all_sum);
			req.setAttribute("list", list);
			choose = "2"; 
		} else if (todays.equals("undefined") && months.equals("undefined") && years.equals("3")) { // 1년 

			String stryears = strToday.substring(0, 5) + "01-01";
			String stryearsend = strToday.substring(0, 5) + "12-31";

			list = salesdao.Sales_stats_kal_select(stryears, stryearsend,startRow,endRow );
			list1 = salesdao.Sales_stats_kal_select(stryears, stryearsend );
			for (Sales_stats_vo vo : list1) {
				all_sum += vo.getAll_Sales();
				sall_sum = formatter.format(all_sum);
			}
			pageCount=(int)Math.ceil(salesdao.sales_stats_search_all_selete_getCount(stryears,stryearsend)/15.0);
			startPageNum= ((pageNum - 1) / 10 * 10) + 1; 
			endPageNum = startPageNum + 9;
			 
			if(endPageNum>pageCount) {
				endPageNum=pageCount;
			}
			
			
			
			System.out.println("all_sum" + all_sum);
			req.setAttribute("all_sum", all_sum);
			req.setAttribute("list", list);
			choose = "3"; 
		} else {

			String beforekal = req.getParameter("beforekal");
			String afterkal = req.getParameter("afterkal");
			String afterkal2 = afterkal + "-23-59";

			list = salesdao.Sales_stats_kal_select(beforekal, afterkal2,startRow,endRow);
			
			list1 = salesdao.Sales_stats_kal_select(beforekal, afterkal2 );
			for (Sales_stats_vo vo : list1) {
				all_sum += vo.getAll_Sales();
				sall_sum = formatter.format(all_sum);
			}
			
			pageCount=(int)Math.ceil(salesdao.sales_stats_search_all_selete_getCount(beforekal,afterkal2)/15.0);
			startPageNum= ((pageNum - 1) / 10 * 10) + 1; 
			endPageNum = startPageNum + 9;
			 
			if(endPageNum>pageCount) {
				endPageNum=pageCount;
			}
			
			
			req.setAttribute("list", list);

		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/xml;charset=utf-8");
		pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.print("<result>");
		for (Sales_stats_vo vo : list) {

			pw.print("<comm>");
			pw.print("<sales_stats_num>" + vo.getSales_stats_num() + "</sales_stats_num>");
			pw.print("<all_sales>" + vo.getAll_Sales() + "</all_sales>");
			pw.print("<o_date>" + vo.getO_date() + "</o_date>");
			pw.print("<p_count>" + vo.getP_count() + "</p_count>");
			pw.print("<p_num>" + vo.getP_num() + "</p_num>");
			pw.print("</comm>");
		}
		
		pw.print("<pageCount>"+pageCount+"</pageCount>");
		pw.print("<startPageNum>"+startPageNum+"</startPageNum>");
		pw.print("<endPageNum>"+endPageNum+"</endPageNum>");
		pw.print("<pageNum>"+pageNum+"</pageNum>");
		pw.print("<choose>"+choose+"</choose>");
		pw.print("<sall_sum>"+sall_sum+"</sall_sum>");
		pw.print("</result>");

	}
}
