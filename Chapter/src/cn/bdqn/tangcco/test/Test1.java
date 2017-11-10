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
				Class.forName("com.mysql.jdbc.Driver");//1.��������
				//2.�������Connection����
				conntection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root","bdqn");
				if (conntection!=null) {
					
				//3.����statement����,����sql���
				Scanner input=new Scanner(System.in);
				System.out.print("�������û���:");
				String uname=input.next();
				System.out.print("����������:");
				String upwd=input.next();
				String sql="SELECT * FROM `student` WHERE `studentName`=? AND `loginPwd`=?;";
				pstmt=conntection.prepareStatement(sql);
				pstmt.setString(1, uname);
				pstmt.setString(2, upwd);
				//4.ִ�еõ����ResultSet������   ���ݼ�
				rs=pstmt.executeQuery();
			
				System.out.println("������Ϣ����:");
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
					System.out.println("����ʧ��!");
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
