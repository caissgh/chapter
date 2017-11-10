package cn.bdqn.tangcco.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		     Connection conntection=null;
		     ResultSet rs=null;
		     PreparedStatement pstmt=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");//1.加载驱动
				//2.获得连接Connection对象
				conntection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root","bdqn");
				if (conntection!=null) {
					
				//3.创建statement对象,发送sql语句
				Scanner input=new Scanner(System.in);
				System.out.print("请输入用户名:");
				String uname=input.next();
				System.out.print("请输入密码:");
				String upwd=input.next();
				String sql="SELECT * FROM `student` WHERE `studentName`=? AND `loginPwd`=?;";
				pstmt=conntection.prepareStatement(sql);
				pstmt.setString(1, uname);
				pstmt.setString(2, upwd);
				//4.执行得到结果ResultSet并处理   数据集
				rs=pstmt.executeQuery();
			
				System.out.println("个人信息如下:");
				while (rs.next()) {
					int stuNo=rs.getInt(1);
					String pwd=rs.getString("loginPwd");
					String name=rs.getString("studentName");
					String sex=rs.getString("sex");
					String phone=rs.getString("phone");
					Date dt=rs.getDate("bornDate");
					System.out.println(stuNo+"\t"+pwd+"\t"+name+"\t"+sex+"\t"+phone+"\t"+dt);
				}
				
				}else{
					System.out.println("连接失败!");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(pstmt!=null){
						pstmt.close();
					}
					if(rs!=null){
						rs.close();
					}
					if (conntection!=null) {
						conntection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
		
	}

}
