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
	 		/*******请求处理文件处理**********/
	 		  //1.获取磁盘工厂对象
	 		DiskFileItemFactory factory=new DiskFileItemFactory();
	 		  //2.获取上传的servlet对象
	 		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
	 		try {
	 			 //3.解析request请求,获取上传的选项对象
	 			List<FileItem> lsItems=servletFileUpload.parseRequest(request);
	 			
	 			//4.处理上传的数据
	 			if(lsItems!=null){
	 				//遍历请求选项
	 				for (FileItem item : lsItems) {
	 					//判断item请求选项是表单元素还是文件
	 					if(item.isFormField()){//是表单元素
	 						//获取表单元素名称
	 						String fieldName=item.getFieldName();
	 						//根据获取到的表单元素名称判断item代表的是哪个选项
	 						if(fieldName.equals("sid")){
	 							//获取表单元素值
	 							String sid=item.getString("utf-8");
	 							st.setSid(Integer.parseInt(sid));
	 						}
	 						if(fieldName.equals("sname")){
	 							//获取表单元素值
	 							String sname=item.getString("utf-8");
	 							st.setSname(sname);
	 						}
	 						if(fieldName.equals("sex")){
	 							//获取表单元素值
	 							String sex=item.getString("utf-8");
	 							st.setSex(sex);
	 						}
	 						if(fieldName.equals("birthday")){
	 							//获取表单元素值
	 							String birthday=item.getString("utf-8");
	 							st.setBirthday(birthday);
	 						}
	 						if(fieldName.equals("address")){
	 							//获取表单元素值
	 							String address=item.getString("utf-8");
	 							st.setAddress(address);
	 						}
	 						if(fieldName.equals("classid")){
	 							//获取表单元素值
	 							String classid=item.getString("utf-8");
	 							st.setClassid(Integer.parseInt(classid));
	 						}
	 						if(fieldName.equals("op")){
	 							//获取表单元素值
	 							 op1=item.getString("utf-8");
	 							System.out.println("pic：op="+op1);
	 							session.setAttribute("op", op1);
	 						}
	 					}else{//是文件域
	 						//获取上传的文件名称
	 						String fname=item.getName();
	 						System.out.println("原始文件名:"+fname);
	 						//获取上传文件的后缀
	 						if(fname.lastIndexOf(".")!=-1){
	 							//获取后缀
	 							String ext=fname.substring(fname.lastIndexOf("."));
	 							//限制上传文件类型
	 							if(ext!=null&&(ext.equalsIgnoreCase(".jpg"))){
	 								//改文件名
	 								fname=new Date().getTime()+ext;
	 							}
	 						}
	 						System.out.println("修改后文件名:"+fname);
	 						//获取服务器个路径
	 						String realpath=getServletContext().getRealPath("/");
	 						System.out.println("realpath:"+realpath);
	 						//获取上传文件的字节数组
	 						byte[] b=item.get();
	 						//创建输出流
	 						FileOutputStream fout=new FileOutputStream(new File(realpath+"/uppic/"+fname));
	 						fout.write(b);
	 						fout.flush();
	 						fout.close();
	 						Student oldst=(Student)session.getAttribute("oldst");
	 						if(oldst==null){
	 						/**
	 						 * 结合富文本文件上传的回调功能，回调图片路径，实现预览效果
	 						 * **/
	 						String imageContextPath1=realpath+"uppic/"+fname;
	 						String imageContextPath=imageContextPath1.replace("\\", "/");
	 						System.out.println("原始路径:"+imageContextPath);
	 						 //返回"图像信息"选项卡并显示图片
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
	 		/*******请求处理文件处理end**********/
	 		//判断有无文本数据，如果有跳转
 			if(st.getSname()!=null&&!op1.equals("2")){
 				st.setFname((String)session.getAttribute("fname"));
 				boolean flag=ibiz.save(st);
 				if(flag){
 					System.out.println("添加完成准备跳转到myServlet的op=5");
 					response.sendRedirect(request.getContextPath()+"/servlet/myServlet?op=5");
 					return;
 				}else{
 					response.sendRedirect(request.getContextPath()+"/error.jsp");
 					
 				}
 				
 			}
 			//修改时
 			if(st.getSname()!=null&&op1.equals("2")){
 				st.setFname((String)session.getAttribute("fname"));
 				boolean flag=ibiz.update(st);
 				if(flag){
 					session.removeAttribute("oldst");
 					System.out.println("修改完成准备跳转到myServlet的op=5");
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
