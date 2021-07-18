<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="st" class="com.bean.Student" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="st"/>
<%
	//获取操作码
	String op=request.getParameter("op");
%>
<jsp:forward page="servlet/myServlet">
	<jsp:param value="<%=op%>" name="op"/>
</jsp:forward>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
</body>
</html>