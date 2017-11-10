<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ListGrade.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function showAdd(){
			window.location.href='grade/addGrade.jsp';
		}
		function showMsg(){
			var flag=confirm("确定要删除么?");
			if(flag){
				return true;
			}
			return false;
		}
	</script>
  </head>
	<body>
	    	<table border="1" width="97%" align="center" >
	        	<tr>
	            	<td align="center"><b>年级编号</b></td>
	                <td align="center"><b>年级名称</b></td>
	                <td align="center"><b>操作</b></td>
	            </tr>
	            <c:forEach items="${grades}" var="grade" varStatus="state">
		            <tr <c:if test="${state.index%2==0}">
		            		bgcolor="yellow"
		            	</c:if>>
		            	<td>${grade.gradeId}</td>
		                <td>${grade.name}</td>
		                <td>
		                	<a href="GradeServlet?flag=search&gradeId=${grade.gradeId}">查看</a>
		                    <a href="GradeServlet?flag=showUpdate&gradeId=${grade.gradeId}">修改</a>
		                    <a href="GradeServlet?flag=del&gradeId=${grade.gradeId}" onclick="return showMsg()">删除</a>
		                </td>
		            </tr>
	          	</c:forEach>
	            <tr>
	            	<td align="center" colspan="3">
	                	<input type="button" value="新增班级信息"  onclick="showAdd()" />
	                </td>
	            </tr>
	        </table>
</body>
</html>

