package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Clazz;
import com.bean.PageBean;
import com.bean.Student;
import com.biz.IStudentBiz;
import com.biz.StudentBiz;

public class myServlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
}
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//========================================================
		HttpSession session=request.getSession();
		IStudentBiz sbiz=new StudentBiz();
		
		//获取客户端传递的请求码
		int op=Integer.parseInt(request.getParameter("op"));
		
		switch (op) {
		case 1://增加
			Student st=(Student) request.getAttribute("st");
			
			boolean flag=sbiz.save(st);
			if(flag){
				response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
				return;
			}else{
				response.sendRedirect(request.getContextPath()+"/error.jsp");
				
			}
			break;
		case 2://修改
			st=(Student) request.getAttribute("st");			
			flag=sbiz.update(st);
			if(flag){
				response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
				return;
			}else{
				response.sendRedirect(request.getContextPath()+"/error.jsp");
				
			}
			break;
		case 3://删除
			String sid=request.getParameter("sid");//获取学生编号
			flag=sbiz.delById(Integer.parseInt(sid));
			if(flag){
				response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
				return;
			}else{
				response.sendRedirect(request.getContextPath()+"/error.jsp");
				
			}
			break;
		case 4://查找
			sid=request.getParameter("sid");//获取学生编号
			Student oldst=sbiz.findById(Integer.parseInt(sid));
			session.setAttribute("oldst",oldst);
			response.sendRedirect(request.getContextPath()+"/stuupdate.jsp");
			break;
		case 5://显示
			//从session获取分页对象
			PageBean pb=(PageBean)session.getAttribute("pb");
			pb=pb==null?new PageBean():pb;
			//从页面请求获取page rows
			String page=request.getParameter("page");
			String rows=request.getParameter("rows");
			//从servlet中来的请求
			page=page==null?pb.getPage()+"":page;
			rows=rows==null?pb.getRows()+"":rows;
			//将String转int
			int ipage=Integer.parseInt(page);
			int irows=Integer.parseInt(rows);
			//限制数据
			if(ipage<1)ipage=1;
			if(irows<1)irows=5;
			//获取总页数
			int maxpage=sbiz.findMaxPage(irows);
			if(ipage>maxpage)ipage=maxpage;
			//获取当前页记录集合
			List<Student> lsst=sbiz.findPageAll(ipage, irows);
			//将分页数据存入pb对象
			pb.setPage(ipage);
			pb.setRows(irows);
			pb.setMaxpage(maxpage);
			pb.setPageList(lsst);
			session.setAttribute("pb", pb);
			response.sendRedirect(request.getContextPath()+"/stulist.jsp");
			break;
		case 6://初始化
			List<Clazz> lsca=sbiz.doinit();
			session.setAttribute("lsca", lsca);
			response.sendRedirect(request.getContextPath()+"/stuadd.jsp");
			break;

		default:
			break;
		}
		
		//========================================================
		out.flush();
		out.close();
	}
}
