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
	<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function check(){
			var grade=$("#gname").val();
			if(grade==""){
				alert("年级名称不能为空!");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
    <form action="../GradeServlet?flag=add" method="post" onsubmit="return check();"> 
       	<table border="1" width="97%" align="center">
        	<tr>
            	<td width="35%" align="right">
                	<b>班级名称:</b>
                </td>
                <td>
                	<input type="text" name="gradeName" id="gname"/>
                    
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
                	<input type="submit" value="保存班级信息" />
                </td>
            </tr>
        </table> 
    </form>
    
</body>
</html>