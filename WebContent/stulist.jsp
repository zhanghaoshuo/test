<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pb==null}">
	<c:redirect url="servlet/myServlet?op=5"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生列表</title>
<script>
   //更改每页记录数
   function dobtrows(){
	   //获取文本框数据
	   var rows=document.f1.rows.value;
	   if(isNaN(rows)){
		   alert("请输入正确的数字");
		   document.f1.rows.value=${pb.rows}; 
		   return;
	   }
	   window.location="servlet/myServlet?op=5&rows="+rows;
	   
   }
   //跳转到指定页
   function dobtpage(){
	   //获取文本框数据
	   var page=document.f1.page.value;
	   if(isNaN(page)){
		   alert("请输入正确的数字");
		   document.f1.page.value=${pb.page}; 
		   return;
	   }
	   window.location="servlet/myServlet?op=5&page="+page;
   }
</script>
</head>

<body>
<p align="center">学生列表
</p>
<hr />
<table width="720" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr align="center" bgcolor="#FFFF99">
    <td>编号</td>
    <td>姓名</td>
    <td>性别</td>
    <td>生日</td>
    <td>地址</td>
    <td>班级</td>
    <td>图片</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${pb.pageList}" var="st">
  <tr align="center">
    <td>${st.sid}</td>
    <td>${st.sname}</td>
    <td>${st.sex}</td>
    <td>${st.birthday}</td>
    <td>${st.address}</td>
    <td>${st.cname}</td>
    <td>
    <a href="uppic/${st.fname}">
     <img src="uppic/${st.fname}" width="120" height="110" alt="图片未上传"></img>
    </a>
    </td>
    <td>
    <a href="servlet/myServlet?op=3&sid=${st.sid}">删除</a> 
    <a href="servlet/myServlet?op=4&sid=${st.sid}">修改</a></td>
  </tr>
  </c:forEach>
  <form id="f1" name="f1" method="post" action="">
  <table width="720" border="1" align="center" cellpadding="1" cellspacing="0">
     <tr align="center" bgcolor="#FFFF99">
        <td>
       <c:if test="${pb.page>1}">
       <a href="servlet/myServlet?op=5&page=1">
       </c:if> 
            首页</a></td>
        <td>
       <c:if test="${pb.page>1}">
       <a href="servlet/myServlet?op=5&page=${pb.page-1}">
       </c:if>
           上一页</a></td>
        <td>
       <c:if test="${pb.page<pb.maxpage}">
       <a href="servlet/myServlet?op=5&page=${pb.page+1}">
       </c:if>
           下一页</a></td>
        <td>
       <c:if test="${pb.page<pb.maxpage}">
       <a href="servlet/myServlet?op=5&page=${pb.maxpage}">
       </c:if>
            尾页</a></td>
        <td>每页
         <input type="text" size="2" name="rows" id="rows" value="${pb.rows}" />  
            条记录
         <input type="button" name="btrows" id="btrows" value="确定" onclick="dobtrows()" />   
            </td>
        <td>跳转
       <input type="text" size="2" name="page" id="page" value="${pb.page}" />  
             页
          <input type="button" name="btpage" id="btpage" value="确定" onclick="dobtpage()" />       
             </td>
        <td>${pb.page}/${pb.maxpage}</td>
         
     </tr>
  </table>
  </form>
</table>
<hr />
<p align="center"><a href="stuadd.jsp">返回添加</a></p>
</body>
</html>