package cn.bdqn.tangcco.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.bdqn.tangcco.dao.BaseDao;
import cn.bdqn.tangcco.dao.StudentDao;
import cn.bdqn.tangcco.entity.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao{

	/**
	 * 用户登录操作
	 */
	public Student findUser(String uname, String pwd) {
		Student student=null;
		
	    ResultSet rs=null;
		try {
			
			
				
			//3.创建statement对象,发送sql语句
			String sql="SELECT * FROM `student` WHERE `studentName`=? AND `loginPwd`=?;";
			Object[] params={uname,pwd};
			
			rs=super.executeQuery(sql, params);
			
			while (rs.next()) {
				
				student=new Student();
				student.setStudentNo(rs.getInt(1));
				student.setStudentName(rs.getString("studentName"));
				student.setLoginPwd(rs.getString("loginPwd"));
				student.setSex(rs.getString("sex"));
				student.setPhone(rs.getString("phone"));
				student.setBornDate(rs.getDate("bornDate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeAll();//关闭连接
		}
		return student;
	}

	public List<Student> getAll() {
		 List<Student> students=new ArrayList<Student>();
		 Connection conntection=null;
	     ResultSet rs=null;
	     PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//1.加载驱动
			//2.获得连接Connection对象
			conntection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root","bdqn");
			//3.创建statement对象,发送sql语句
			String sql="SELECT s.*,g.* FROM `student` s,grade g WHERE s.`gradeId`=g.`gradeId`;";
			pstmt=conntection.prepareStatement(sql);
			//4.执行得到结果ResultSet并处理   数据集
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Student student=new Student();
				student.setStudentNo(rs.getInt(1));
				student.setStudentName(rs.getString("studentName"));
				student.setLoginPwd(rs.getString("loginPwd"));
				student.setSex(rs.getString("sex"));
				student.setPhone(rs.getString("phone"));
				student.setBornDate(rs.getDate("bornDate"));
				student.setGradeId(rs.getInt("gradeId"));
				student.setGradeName(rs.getString("name"));
				students.add(student);
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
		return students;
	}
	/**
	 * 修改
	 */
	public int updateStudent(Student student) {
		int result=0;
		
		try {
			//3.创建statement对象,发送sql语句
			StringBuffer sb=new StringBuffer();
			sb.append("UPDATE `student` SET `loginPwd` =?, `studentName` =?," +
					" `sex` =?, `gradeId` =?, `phone` =?, `address` =?, `bornDate` =? WHERE `studentNo` = ?;");
			java.sql.Date dt=new java.sql.Date(student.getBornDate().getTime());
			Object[] params={
						student.getLoginPwd(),
						student.getStudentName(),
						student.getSex(),
						student.getGradeId(),
						student.getPhone(),
						student.getAddress(),
						dt,
						student.getStudentNo()
			        };
			result=super.executeUpdate(sb.toString(), params);
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return result;
	}
	public int addStudent(Student student) {
		int result=0;
		 Connection conntection=null;
	     PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//1.加载驱动
			//2.获得连接Connection对象
			conntection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root","bdqn");
			//3.创建statement对象,发送sql语句
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO `student` (`studentNo`,`loginPwd`,");
			sb.append("`studentName`,`sex`,`gradeId`,`phone`,`address`,`bornDate`)");
			sb.append("VALUES (?,?,?,?,?,?,?,?);");
			pstmt=conntection.prepareStatement(sb.toString());
			pstmt.setInt(1, student.getStudentNo());
			pstmt.setString(2, student.getLoginPwd());
			pstmt.setString(3, student.getStudentName());
			pstmt.setString(4, student.getSex());
			pstmt.setInt(5, student.getGradeId());
			pstmt.setString(6, student.getPhone());
			pstmt.setString(7, student.getAddress());
			java.sql.Date dt=new java.sql.Date(student.getBornDate().getTime());
			pstmt.setDate(8, dt);
			//4.执行得到结果ResultSet并处理   数据集
			result=pstmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null){
					pstmt.close();
				}
				if (conntection!=null) {
					conntection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	

	public Student searchByStuNo(int stuNo) {
		Student student=null;
		Connection conntection=null;
	    ResultSet rs=null;
	    PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//1.加载驱动
			//2.获得连接Connection对象
			conntection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root","bdqn");
			
				
			//3.创建statement对象,发送sql语句
			String sql="SELECT * FROM `student`,`grade` WHERE  student.`gradeId`=grade.`gradeId` AND   `studentNo`=?;";
			pstmt=conntection.prepareStatement(sql);
			pstmt.setInt(1, stuNo);
			//4.执行得到结果ResultSet并处理   数据集
			rs=pstmt.executeQuery();
			while (rs.next()) {
				student=new Student();
				student.setStudentNo(rs.getInt(1));
				student.setStudentName(rs.getString("studentName"));
				student.setLoginPwd(rs.getString("loginPwd"));
				student.setSex(rs.getString("sex"));
				student.setPhone(rs.getString("phone"));
				student.setBornDate(rs.getDate("bornDate"));
				student.setGradeName(rs.getString("name"));
				student.setGradeId(rs.getInt("gradeId"));
				student.setAddress(rs.getString("address"));
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
		return student;
	}
	public int delStudent(int stuNo) {
		int result=0;
		try {
			//3.创建statement对象,发送sql语句
			StringBuffer sb=new StringBuffer();
			sb.append("DELETE FROM `student` WHERE `studentNo`=?");
			
			Object[] params={stuNo};
			result=super.executeUpdate(sb.toString(), params);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return result;
	}	
	/**
	 * 统计总记录数
	 */
	public int getTotalCount() {
		int total=0;
		try {
			Object[] params={};
			String sql="SELECT COUNT(*) FROM `student`;";
			
			ResultSet rs=super.executeQuery(sql, params);
			while (rs.next()) {
				total=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	/**
	 * 统计每页显示学员信息
	 * @param pageIndex 页号
	 * @param pageSize 每页显示总记录数
	 * @return 学员信息
	 */
	public List<Student> getStudents(int pageIndex, int pageSize) {
		int start=(pageIndex-1)*pageSize;
		Object[] params={start,pageSize};
		List<Student> students=new ArrayList<Student>();
		try {
			String sql="SELECT * FROM student s, grade g WHERE s.`gradeId` = g.`gradeId` ORDER BY `studentNo` desc LIMIT ?, ?";
			ResultSet rs=super.executeQuery(sql, params);
			while (rs.next()) {
				Student student=new Student();
				student.setStudentNo(rs.getInt(1));
				student.setStudentName(rs.getString("studentName"));
				student.setLoginPwd(rs.getString("loginPwd"));
				student.setSex(rs.getString("sex"));
				student.setPhone(rs.getString("phone"));
				student.setBornDate(rs.getDate("bornDate"));
				student.setGradeId(rs.getInt("gradeId"));
				student.setGradeName(rs.getString("name"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		System.out.println(pageIndex);
		return students;
	}

	
	public static void main(String[] args) {
		StudentDaoImpl stuDao=new StudentDaoImpl();
		int total=stuDao.getTotalCount();
		int pageIndex=3;
		int pageSize=3;
		int totalPages=(total%pageSize==0)?(total/pageSize):(total/pageSize+1);
		
		System.out.println("总记录数:"+total);
		System.out.println("总页数:"+totalPages);
		System.out.println("当前页:"+pageIndex);
		System.out.println("当前页信息：");
		List<Student> students=stuDao.getStudents(pageIndex, pageSize);
		for (Student student : students) {
			System.out.println(student.getStudentNo()+"\t"+student.getStudentName()+"\t"+student.getGradeName());
		}
		
	}

	public List<Student> searchByName(String name) {
		 List<Student> students=new ArrayList<Student>();
	     ResultSet rs=null;
   		 try {
			Object[] params={name};
			String sql="SELECT * FROM `student` WHERE `studentName`=?;";
			rs=super.executeQuery(sql, params);
			while (rs.next()) {
				Student student=new Student();
				student.setStudentNo(rs.getInt(1));
				student.setStudentName(rs.getString("studentName"));
				student.setLoginPwd(rs.getString("loginPwd"));
				student.setSex(rs.getString("sex"));
				student.setPhone(rs.getString("phone"));
				student.setBornDate(rs.getDate("bornDate"));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return students;
	}
	
}
