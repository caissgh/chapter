<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bdqn.tangcco.service.impl.StudentServiceImpl"%>
<%@page import="cn.bdqn.tangcco.entity.Student"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addControl.jsp' starting page</title>
    
  </head>
  
  <body>
    <%
        request.setCharacterEncoding("UTF-8");
    	StudentServiceImpl studentService=new StudentServiceImpl();
		Student student=new Student();
		student.setStudentNo(Integer.parseInt(request.getParameter("stunum")));
		student.setLoginPwd(request.getParameter("pwd"));
		student.setStudentName(request.getParameter("stuname"));
		student.setSex(request.getParameter("sex"));
		student.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
		student.setPhone(request.getParameter("phone"));
		student.setAddress(request.getParameter("address"));
		String dt=request.getParameter("bornDate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			student.setBornDate(sdf.parse(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int result=studentService.addStudent(student);
		if (result>0) {
			response.sendRedirect("listStudent.jsp");
		}else{
			response.sendRedirect("addStudent.jsp");
		}
     %>
  </body>
</html>
