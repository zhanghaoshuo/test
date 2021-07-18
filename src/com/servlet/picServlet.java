package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.Student;
import com.biz.IStudentBiz;
import com.biz.StudentBiz;
public class picServlet extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	doPost(request, response);
	 }
	   @Override
	 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		response.setContentType("text/html;Charset=utf-8");
	 		PrintWriter out=response.getWriter();
	 		HttpSession session=request.getSession();
	 		IStudentBiz ibiz=new StudentBiz();
	 		Student st=new Student();
	 		String op1=null;
	 		/*******�������ļ�����**********/
	 		  //1.��ȡ���̹�������
	 		DiskFileItemFactory factory=new DiskFileItemFactory();
	 		  //2.��ȡ�ϴ���servlet����
	 		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
	 		try {
	 			 //3.����request����,��ȡ�ϴ���ѡ�����
	 			List<FileItem> lsItems=servletFileUpload.parseRequest(request);
	 			
	 			//4.�����ϴ�������
	 			if(lsItems!=null){
	 				//��������ѡ��
	 				for (FileItem item : lsItems) {
	 					//�ж�item����ѡ���Ǳ�Ԫ�ػ����ļ�
	 					if(item.isFormField()){//�Ǳ�Ԫ��
	 						//��ȡ��Ԫ������
	 						String fieldName=item.getFieldName();
	 						//���ݻ�ȡ���ı�Ԫ�������ж�item��������ĸ�ѡ��
	 						if(fieldName.equals("sid")){
	 							//��ȡ��Ԫ��ֵ
	 							String sid=item.getString("utf-8");
	 							st.setSid(Integer.parseInt(sid));
	 						}
	 						if(fieldName.equals("sname")){
	 							//��ȡ��Ԫ��ֵ
	 							String sname=item.getString("utf-8");
	 							st.setSname(sname);
	 						}
	 						if(fieldName.equals("sex")){
	 							//��ȡ��Ԫ��ֵ
	 							String sex=item.getString("utf-8");
	 							st.setSex(sex);
	 						}
	 						if(fieldName.equals("birthday")){
	 							//��ȡ��Ԫ��ֵ
	 							String birthday=item.getString("utf-8");
	 							st.setBirthday(birthday);
	 						}
	 						if(fieldName.equals("address")){
	 							//��ȡ��Ԫ��ֵ
	 							String address=item.getString("utf-8");
	 							st.setAddress(address);
	 						}
	 						if(fieldName.equals("classid")){
	 							//��ȡ��Ԫ��ֵ
	 							String classid=item.getString("utf-8");
	 							st.setClassid(Integer.parseInt(classid));
	 						}
	 						if(fieldName.equals("op")){
	 							//��ȡ��Ԫ��ֵ
	 							 op1=item.getString("utf-8");
	 							System.out.println("pic��op="+op1);
	 							session.setAttribute("op", op1);
	 						}
	 					}else{//���ļ���
	 						//��ȡ�ϴ����ļ�����
	 						String fname=item.getName();
	 						System.out.println("ԭʼ�ļ���:"+fname);
	 						//��ȡ�ϴ��ļ��ĺ�׺
	 						if(fname.lastIndexOf(".")!=-1){
	 							//��ȡ��׺
	 							String ext=fname.substring(fname.lastIndexOf("."));
	 							//�����ϴ��ļ�����
	 							if(ext!=null&&(ext.equalsIgnoreCase(".jpg"))){
	 								//���ļ���
	 								fname=new Date().getTime()+ext;
	 							}
	 						}
	 						System.out.println("�޸ĺ��ļ���:"+fname);
	 						//��ȡ��������·��
	 						String realpath=getServletContext().getRealPath("/");
	 						System.out.println("realpath:"+realpath);
	 						//��ȡ�ϴ��ļ����ֽ�����
	 						byte[] b=item.get();
	 						//���������
	 						FileOutputStream fout=new FileOutputStream(new File(realpath+"/uppic/"+fname));
	 						fout.write(b);
	 						fout.flush();
	 						fout.close();
	 						Student oldst=(Student)session.getAttribute("oldst");
	 						if(oldst==null){
	 						/**
	 						 * ��ϸ��ı��ļ��ϴ��Ļص����ܣ��ص�ͼƬ·����ʵ��Ԥ��Ч��
	 						 * **/
	 						String imageContextPath1=realpath+"uppic/"+fname;
	 						String imageContextPath=imageContextPath1.replace("\\", "/");
	 						System.out.println("ԭʼ·��:"+imageContextPath);
	 						 //����"ͼ����Ϣ"ѡ�����ʾͼƬ
	 						String callback = request.getParameter("CKEditorFuncNum");
	 			            out = response.getWriter();
	 			            out.println("<script type=\"text/javascript\">");
	 			            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
	 			            out.println("</script>");
	 			            System.out.println("1111111111111");
	 			            out.flush();
	 			    		out.close();
	 						}
	 						session.setAttribute("fname", fname);
	 					}
	 				}
	 			}
	 			
	 		} catch (FileUploadException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		/*******�������ļ�����end**********/
	 		//�ж������ı����ݣ��������ת
 			if(st.getSname()!=null&&!op1.equals("2")){
 				st.setFname((String)session.getAttribute("fname"));
 				boolean flag=ibiz.save(st);
 				if(flag){
 					System.out.println("������׼����ת��myServlet��op=5");
 					response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
 					return;
 				}else{
 					response.sendRedirect(request.getContextPath()+"/error.jsp");
 					
 				}
 				
 			}
 			//�޸�ʱ
 			if(st.getSname()!=null&&op1.equals("2")){
 				st.setFname((String)session.getAttribute("fname"));
 				boolean flag=ibiz.update(st);
 				if(flag){
 					session.removeAttribute("oldst");
 					System.out.println("�޸����׼����ת��myServlet��op=5");
 					response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
 					
 					return;
 				}else{
 					response.sendRedirect(request.getContextPath()+"/error.jsp");
 					
 				}
 			}
	 		out.flush();
	 		out.close();
	 	}
	 }
