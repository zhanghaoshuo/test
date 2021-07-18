<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${lsca==null}">
	<c:redirect url="servlet/myServlet?op=6"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生添加</title>
<!-- 引入富文本 -->
<script src="ckeditor/ckeditor.js"></script>
<!-- 控件替换 -->
<script type="text/javascript">
   window.onload=function(){
	   CKEDITOR.replace('description');
   }
</script>
</head>

<body>
<form id="form1" name="form1" method="post" enctype="multipart/form-data" action="servlet/picServlet">
  <p align="center">学生添加</p>
      姓名:<input type="text" name="sname" id="sname" />
      性别:<input name="sex" type="radio" id="radio" value="男" checked="checked" />男
        <input type="radio" name="sex" id="radio2" value="女" />女
      生日:<input type="date" name="birthday" id="birthday" value="1990-01-01"/></td>
      地址:<input type="text" name="address" id="address" /></td>
      <input type="hidden" id="op" name="op" value="1" />
      班级:<select name="classid" id="classid">
      		<c:forEach items="${lsca}" var="clazz">
      			<option value="${clazz.cid}">${clazz.cname}</option>
      		</c:forEach>
      	</select>
      描述:<textarea rows="" cols="" name="description" id="description"></textarea>
     <input type="submit" />
</form>
<p>&nbsp; </p>
<p align="center"><a href="servlet/myServlet?op=5">显示列表</a></p>
</body>
</html>