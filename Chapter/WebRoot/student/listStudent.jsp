<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bdqn.tangcco.service.impl.StudentServiceImpl"%>
<%@page import="cn.bdqn.tangcco.entity.Student"%>
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
    	<a href="../UserServlet?flag=fenye">分页</a>
    	<table border="1" width="97%" align="center">
        	<tr bgcolor="yellow">
            	<th>年级</th>
                <th>学号</th> 
                <th>学生姓名</th>
                <th>出生日期</th>
                <th>性别</th>
                <th>操作</th>
            </tr>
            <%
            	StudentServiceImpl studentService=new StudentServiceImpl();
				List<Student> students=studentService.getAll();
				int i=0;
				for (Student student : students) {
				 i++;
			%>
            <tr <%
            		if(i%2==0){
            	%>	  
            		bgcolor="yellow"
            	<%	}
            	 %>>
            	
            	<td><%=student.getGradeName() %></td>
                <td><%=student.getStudentNo() %></td>
                <td><%=student.getStudentName() %></td>
                <td><%=student.getBornDate() %></td>
                <td><%=student.getSex() %></td>
                <td>
                	<a href="../UserServlet?flag=search&stuNo=<%=student.getStudentNo() %>">查看</a>
                    <a href="../GradeServlet?flag=updateStu&stuNo=<%=student.getStudentNo() %>">修改</a>
                    <a href="../UserServlet?flag=del&stuNo=<%=student.getStudentNo() %>" onclick="return confirm('确认删除该学生吗?');">删除</a>
                </td>
            </tr>
            <%} %>
        	<tr>
            	<td colspan="7" align="center">
                  	<input type="button" value="新增学生信息" onclick="addStudent();" />  
	             </td>
            </tr>
        </table>
    </form>









</body>
</html>
