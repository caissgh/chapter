<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bdqn.tangcco.service.impl.StudentServiceImpl"%>
<%@page import="cn.bdqn.tangcco.entity.Student"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
	function addStudent(){
		document.getElementById("studentForm").action="../GradeServlet?flag=addStu";
		document.getElementById("studentForm").submit();
	}


</script>
</head>
<body>
	<form id="studentForm" action="" method="post">
    	<h1 align="center">分页显示学员信息</h1>
    	<table border="1" width="97%" align="center">
        	<tr bgcolor="yellow">
            	<th>年级</th>
                <th>学号</th> 
                <th>学生姓名</th>
                <th>出生日期</th>
                <th>性别</th>
                <th>操作</th>
            </tr>
           	<c:forEach items="${pages.pageList}" var="student">
	            <tr>
	            	<td>${student.gradeName}</td>
	                <td>${student.studentNo}</td>
	                <td>${student.studentName}</td>
	                <td>${student.bornDate}</td>
	                <td>${student.sex}</td>
	                <td>
	                	<a href="../UserServlet?flag=search&stuNo=${student.studentNo}">查看</a>
	                    <a href="../GradeServlet?flag=updateStu&stuNo=${student.studentNo}">修改</a>
	                    <a href="../UserServlet?flag=del&stuNo=${student.studentNo}" onclick="return confirm('确认删除该学生吗?');">删除</a>
	                </td>
	            </tr>
            </c:forEach>
        </table>
        ${pages.currentIndex}
        <a href="UserServlet?flag=fenye&pageIndex=1">首  页</a>
        <a href="UserServlet?flag=fenye&pageIndex=${pages.currentIndex-1}">上一页</a>
        <a href="UserServlet?flag=fenye&pageIndex=${pages.currentIndex+1}">下一页</a>
        <a href="UserServlet?flag=fenye&pageIndex=${pages.pageTotalCount}">末页</a>
    </form>









</body>
</html>
