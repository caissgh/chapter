<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	  	$(function(){
	  		$("#stuname").blur(function(){
	  			var nameVal=$(this).val();
	  			alert(nameVal);
	  			if(nameVal==""){
	  				//非空判断
	  				$("#nameSpan").css("color","red");
	  				$("#nameSpan").html("用户名不能为空");
	  			}else{
	  				//ajax你的名字是否有重名现象
	  				alert("else");
	  				$.ajax({
		  				url:"UserServlet?flag=findStu",
		  				type:"POST",
		  				data:"name="+nameVal,
		  				dataType:"text",
		  				success:function(data){
	  						if(data=="true"){
		  						$("#nameSpan").css("color","red");
	  							$("#nameSpan").html("此用户名已被使用!");		
		  					}else{
		  						$("#nameSpan").css("color","green");
	  							$("#nameSpan").html("此用户名可以使用!");
		  					}
		  				},
		  				error:function(){
							$("#nameSpan").html("系统异常!"); 					
		  				}
	  				});
	  			}
	  		});
	  	});
	  </script>
</head>
<body>
	<form id="studentForm" action="UserServlet?flag=add" method="post">
    	<table border="1" width="97%" align="center">
        
        	<tr>
            	<th width="30%" align="right">年级:</th>
                <td>
                	
                	<select name="gradeId">
                	<%
                		List<Grade> grades=(List<Grade>)request.getAttribute("grades");
                		for(Grade grade:grades){
                	 %>
                    	<option value="<%=grade.getGradeId() %>"><%=grade.getName() %></option>
                    	<%} %>
                    	
                    </select>
                </td>
            </tr>
            <tr>
            	<th align="right">学生姓名:</th>
                <td>
                	<input id="stuname" type="text" name="stuname"/>
                	<span id="nameSpan"></span>
                </td>
            </tr>
            <tr>
            	<th align="right">电话:</th>
                <td>
                	<input  type="text" name="phone"/>
                </td>
            </tr>
            <tr>
            	<th align="right">密码:</th>
                <td>
                	<input  type="password" name="pwd"/>
                </td>
            </tr>
        	 <tr>
            	<th align="right">出生日期:</th>
                <td>
                	<input type="text" name="bornDate"/>
                </td>
            </tr>
             <tr>
            	<th align="right">学号:</th>
                <td>
                	<input type="text" name="stunum" id="stunum"/>
                </td>
            </tr>
            <tr>
            	<th align="right">还是性别:</th>
                <td>
                	<input type="radio" name="sex" value="男" checked="checked"/>男
                    <input type="radio" name="sex" value="女" />女
                </td>
            </tr>
            <tr>
            	<th align="right">地址:</th>
                <td>
                	<textarea rows="5" cols="20" name="address"></textarea>
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


