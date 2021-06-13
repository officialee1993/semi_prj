package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Productdao;
import shop.vo.Cgname_Pid_select_vo;
import shop.vo.Product_vo;
import shop_dao.Categorydao;
@WebServlet("/admin/goods_modify")
public class Admin_GoodsModifyController extends HttpServlet{

	
	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int p_num = Integer.parseInt(req.getParameter("p_num")) ;
	int s_count = Integer.parseInt(req.getParameter("s_count")) ;
	String p_size = req.getParameter("p_size");
	Productdao productdao = Productdao.getinstance();
	
	Product_vo vo = productdao.getinfo(p_num);
	int cg_id = vo.getCg_id();
	String str_p_id = null;
	Categorydao categorydao = Categorydao.getinstance();
	Cgname_Pid_select_vo cgname_pid_select_vo= categorydao.cgname_pid_select(cg_id);
	String cg_name = cgname_pid_select_vo.getCg_name();
	int p_id = cgname_pid_select_vo.getP_id();
	if(p_id == 1) {
		str_p_id = "남성";
	}else if(p_id==2) {
		str_p_id = "여성";
	}
	req.setAttribute("vo", vo);
	req.setAttribute("p_num", p_num);
	req.setAttribute("s_count", s_count);
	req.setAttribute("p_size", p_size);
	req.setAttribute("cg_name", cg_name);
	req.setAttribute("str_p_id", str_p_id);
	req.setAttribute("sidemenu", "/admin/sidemenu.jsp");
	req.setAttribute("content", "/admin/goods_modify.jsp");

	req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	
}
}
