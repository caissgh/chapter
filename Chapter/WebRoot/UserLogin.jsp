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

	<form  id="loginForm" action="UserServlet?flag=login" method="post">
    	<table style="margin-top:180px" border="1" width="60%" align="center">
        	<tr>
            	<th align="right" width="25%">用户名:</th>
                <td width="35%">
                	<input id="username" 
                    	type="text" 
                        name="username"  />
                </td>
                <td id="resultUsername"></td>
            </tr>
            <tr>
            	<th align="right">密码:</th>
                <td>
                	<input name="pwd"  id="pwd" 
                    	type="password" 
                        />
                </td>
                <td id="resultPassword"></td>
            </tr>
            <tr>
            	
                <td colspan="3" align="center">
                	<input type="submit"  value="登录"/>
                </td>
            </tr>
    </table>
    </form>
</body>
</html>

