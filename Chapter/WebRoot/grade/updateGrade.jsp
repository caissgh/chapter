<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>

<body>
	<form action="GradeServlet?flag=update" method="post">
    	<table border="1" width="97%" align="center">
        	<tr>
            	<td align="right"><b>班级名称:</b></td>
                <td>
                	<input type="hidden" name="gradeId" value="${grade.gradeId }"/>
                	<input type="text" name="gradeName" value="${grade.name}"/>
                </td>
            </tr>
        	<tr>
            	<td colspan="2" align="center">
                	<input type="submit" value="修改班级信息" />
                </td>
            </tr>
       </table>
     </form>
</body>
</html>
