<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${lsca==null&&oldst==null}">
	<c:redirect url="servlet/myServlet?op=6"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生修改</title>
</head>

<body>
<form id="form1" name="form1" method="post" enctype="multipart/form-data" action="servlet/picServlet">
  <table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="3" align="center" bgcolor="#FFFF99">学生修改</td>
    </tr>
    <tr>
      <td width="115" height="27">姓名</td>
      <td width="375">
        <input type="text" name="sname" id="sname" value="${oldst.sname }"/>
        <input type="hidden" name="sid" id="sid" value="${oldst.sid}"/>
     </td>
     <td rowspan="5">
      <a href="uppic/${oldst.fname}">
     <img src="uppic/${oldst.fname}" width="120" height="130" alt="图片未上传"></img>
    </a>
     </td>
    </tr>
    <tr>
      <td>性别</td>
      <td>
      <input name="sex" type="radio" id="radio" value="男" checked="checked" />男
      <input type="radio" name="sex" id="radio2" value="女" />女
      </td>
    </tr>
    <tr>
      <td>生日</td>
      <td>
      <input type="date" name="birthday" id="birthday" value="${oldst.birthday}"/></td>
    </tr>
    <tr>
      <td>地址</td>
      <td>
      <input type="text" name="address" id="address" value="${oldst.address}"/></td>
    </tr>
    <tr>
      <td>上传图片</td>
      <td>
      <input type="file" name="pic" id="pic"/></td>
    </tr>
    <tr>
      <td>班级</td>
      <td>
        <select name="classid" id="classid">
      		<c:forEach items="${lsca}" var="clazz">
      			<option value="${clazz.cid}" 
      				<c:if test="${clazz.cid==oldst.classid}">
      					selected="selected"
      				</c:if>	
      			
      			>${clazz.cname}</option>
      		</c:forEach>
      	</select>
      </td>
    </tr>
    <tr>
      <td colspan="3" align="center" bgcolor="#FFFF99">
      <input name="op" type="hidden" id="op" value="2" />
        <input type="submit" name="button" id="button" value="提交" />
      <input type="reset" name="button2" id="button2" value="重置" /></td>
    </tr>
  </table>
</form>
<p>&nbsp; </p>
<p align="center"><a href="servlet/myServlet?op=5">显示列表</a></p>

</body>
</html>