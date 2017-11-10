<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.bdqn.tangcco.service.impl.GradeServiceImpl"%>
<%@page import="cn.bdqn.tangcco.entity.Grade"%>
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
<h1>修改页面</h1>
	<form id="studentForm" action="UserServlet?flag=update" method="post">
    	<table border="1" width="97%" align="center">
        
        	<tr>
            	<th width="30%" align="right">年级:</th>
                <td>
                	<%
                		List<Grade> grades=(List<Grade>)request.getAttribute("grades");
                		request.setAttribute("grades",grades);
                	 %>
                	<select name="gradeId">
	                	<c:forEach items="${grades}" var="grade">
	                    	<option value="${grade.gradeId}"  
	                    	<c:if test="${student.gradeId eq grade.gradeId}">
                    		selected="selected"
                    		</c:if>>
	                    	${grade.name}
	                    	</option>
	                    </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
            	<th align="right">学生姓名:</th>
                <td>
                	<input id="stuname" type="text" name="stuname" value="${student.studentName }"/>
                </td>
            </tr>
            <tr>
            	<th align="right">电话:</th>
                <td>
                	<input  type="text" name="phone" value="${student.phone}"/>
                </td>
            </tr>
            <tr>
            	<th align="right">密码:</th>
                <td>
                	<input  type="password" name="pwd"  value="${student.loginPwd}"/>
                </td>
            </tr>
        	 <tr>
            	<th align="right">出生日期:</th>
                <td>
                	<input type="text" name="bornDate"  value="${student.bornDate}"/>
               		<input type="hidden" name="stunum"  value="${student.studentNo}"/>
                </td>
            </tr>
            
            <tr>
            	<th align="right">还是性别:</th>
                <td>
                	<input type="radio" name="sex" value="男"  <c:if test="${student.sex eq '男'}">checked="checked"</c:if>/>男
                    <input type="radio" name="sex" value="女" <c:if test="${student.sex eq '女'}">checked="checked"</c:if>/>女
                </td>
            </tr>
            <tr>
            	<th align="right">地址:</th>
                <td>
                	<textarea rows="5" cols="20" name="address">${student.address}</textarea>
                </td>
            </tr>
            
            <tr>
            	<td colspan="2" align="center">
                	<input type="submit" value="保存学生信息"/>
                </td>
            </tr>
       </table>
    </form>
<script type="text/x-javascript" src="../js/jquery-1.8.3.js"></script>
<script>
    var form = document.querySelector("form");
    form.addEventListener("invalid",function(event){
        var elme = event.target;
        var vali = elme.validity;
        var name = elme.name;
        switch (name){
            case 'stuname':
                if (vali.valueMissing) {
                    elme.setCustomValidity("请输入学生姓名");
                }else if(vali.patternMismatch){
                    elme.setCustomValidity("请输入2-4学生姓名");
                }
                else {
                    elme.setCustomValidity("");
                }
                break;
            case 'age':
                if (vali.valueMissing) {
                    elme.setCustomValidity("请输入你的年龄");
                }else if(vali.patternMismatch){
                    elme.setCustomValidity("请输入1-3位的年龄");
                }
                else {
                    elme.setCustomValidity("");
                }
                break;
			case 'stunum':
                if (vali.valueMissing) {
                    elme.setCustomValidity("请输入你的学号");
                }else if(vali.patternMismatch){
                    elme.setCustomValidity("请输入1-3位的学号");
                }
                else {
                    elme.setCustomValidity("");
                }
                break;
			case 'hobby':
                if (vali.valueMissing) {
                    elme.setCustomValidity("请选择爱好");
                }else {
                    elme.setCustomValidity("");
                }
                break;
        }
    },true) 
</script>


</body>
</html>


