package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import shop.vo.CommentsVo;
import shop.vo.Q_board_vo;
import shop_dao.QuestionDao;



@WebServlet("/shop/question.do")
public class QustionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  req.setCharacterEncoding("utf-8");
		  int p_num=Integer.parseInt(req.getParameter("p_num")); QuestionDao
		  dao=QuestionDao.getinstance(); ArrayList<CommentsVo>
		  list=dao.questionListTest(p_num);
		  
		  resp.setCharacterEncoding("utf-8");
		  resp.setContentType("text/xml;charset=utf-8");
		  
		  PrintWriter pw=resp.getWriter();
		  
		  pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>"); pw.print("<result>");
		  for(CommentsVo vo:list){ pw.print("<comm>");
		  pw.print("<q_num>"+vo.getQ_num()+"</q_num>");
		  pw.print("<id>"+vo.getId()+"</id>");
		  pw.print("<category>"+vo.getCategory()+"</category>");
		  pw.print("<qtitle>"+vo.getQ_title()+"</qtitle>");
		  pw.print("<qcontent>"+vo.getQ_content()+"</qcontent>");
		  pw.print("<qdate>"+vo.getQ_date()+"</qdate>");
		  pw.print("<atitle>"+vo.getA_title()+"</atitle>");
		  pw.print("<acontent>"+vo.getA_content()+"</acontent>");
		  pw.print("<adate>"+vo.getA_date()+"</adate>"); pw.print("</comm>"); }
		  pw.print("</result>");
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		String id=(String)session.getAttribute("id");
		String category=req.getParameter("category");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String pwd=req.getParameter("pwd");
		int pnum=Integer.parseInt(req.getParameter("p_num"));
		
		Q_board_vo vo=new Q_board_vo(0,id,category,title,content,pwd,null,null,pnum);
		
		QuestionDao dao=QuestionDao.getinstance();
		int n=dao.questionInsert(vo);
		
		  JSONObject json=new JSONObject(); PrintWriter pw=resp.getWriter();
		  
		boolean result=false;
		if(n>0) {

			
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date
			time = new Date(); String time1 = format1.format(time); result=true;
			 
			

			 json.put("id",id); json.put("category",category); json.put("title",title);
			 json.put("content",content); json.put("date",time1);
			 json.put("result",result); 
			 
			 
			

		}
		resp.setContentType("text/plain;charset=utf-8");
		pw.print(json);
		
	}
}

















