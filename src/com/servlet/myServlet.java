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
		
		//��ȡ�ͻ��˴��ݵ�������
		int op=Integer.parseInt(request.getParameter("op"));
		
		switch (op) {
		case 1://����
			Student st=(Student) request.getAttribute("st");
			
			boolean flag=sbiz.save(st);
			if(flag){
				response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
				return;
			}else{
				response.sendRedirect(request.getContextPath()+"/error.jsp");
				
			}
			break;
		case 2://�޸�
			st=(Student) request.getAttribute("st");			
			flag=sbiz.update(st);
			if(flag){
				response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
				return;
			}else{
				response.sendRedirect(request.getContextPath()+"/error.jsp");
				
			}
			break;
		case 3://ɾ��
			String sid=request.getParameter("sid");//��ȡѧ�����
			flag=sbiz.delById(Integer.parseInt(sid));
			if(flag){
				response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
				return;
			}else{
				response.sendRedirect(request.getContextPath()+"/error.jsp");
				
			}
			break;
		case 4://����
			sid=request.getParameter("sid");//��ȡѧ�����
			Student oldst=sbiz.findById(Integer.parseInt(sid));
			session.setAttribute("oldst",oldst);
			response.sendRedirect(request.getContextPath()+"/stuupdate.jsp");
			break;
		case 5://��ʾ
			//��session��ȡ��ҳ����
			PageBean pb=(PageBean)session.getAttribute("pb");
			pb=pb==null?new PageBean():pb;
			//��ҳ�������ȡpage rows
			String page=request.getParameter("page");
			String rows=request.getParameter("rows");
			//��servlet����������
			page=page==null?pb.getPage()+"":page;
			rows=rows==null?pb.getRows()+"":rows;
			//��Stringתint
			int ipage=Integer.parseInt(page);
			int irows=Integer.parseInt(rows);
			//��������
			if(ipage<1)ipage=1;
			if(irows<1)irows=5;
			//��ȡ��ҳ��
			int maxpage=sbiz.findMaxPage(irows);
			if(ipage>maxpage)ipage=maxpage;
			//��ȡ��ǰҳ��¼����
			List<Student> lsst=sbiz.findPageAll(ipage, irows);
			//����ҳ���ݴ���pb����
			pb.setPage(ipage);
			pb.setRows(irows);
			pb.setMaxpage(maxpage);
			pb.setPageList(lsst);
			session.setAttribute("pb", pb);
			response.sendRedirect(request.getContextPath()+"/stulist.jsp");
			break;
		case 6://��ʼ��
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
