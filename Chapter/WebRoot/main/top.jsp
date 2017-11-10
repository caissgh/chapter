<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bdqn.tangcco.entity.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'top.jsp' starting page</title>
  </head>
  
  <body>
    <%
    	Student student=(Student)session.getAttribute("user");
     %>
     <p>登录成功,欢迎您,<%=student.getStudentName() %>!   
     <a href="logOut.jsp" target="_parent">注销</a></p>
  </body>
</html>
