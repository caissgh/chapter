<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<body>
	
	<table border="1" width="50%" align="center">
    	<tr>
        	<td align="right"><b>班级名称:</b></td>
            <td width="300">${grade.name}</td>
        </tr>
    	<tr>
        	<td colspan="2" align="center">
            	<input type="button" value="返回" onclick="window.history.go(-1);" />
            </td>
        </tr>
    </table>
</body>
</html>
