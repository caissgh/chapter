package cn.bdqn.tangcco.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.tangcco.dao.BaseDao;
import cn.bdqn.tangcco.dao.GradeDao;
import cn.bdqn.tangcco.entity.Grade;

public class GradeDaoImpl extends BaseDao implements GradeDao {
	public List<Grade> findAll() {
		 List<Grade> grades=new ArrayList<Grade>();
		 Connection conntection=null;
	     ResultSet rs=null;
	     PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//1.加载驱动
			//2.获得连接Connection对象
			conntection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root","bdqn");
			//3.创建statement对象,发送sql语句
			String sql="SELECT * FROM grade;";
			pstmt=conntection.prepareStatement(sql);
			//4.执行得到结果ResultSet并处理   数据集
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Grade grade=new Grade();
				grade.setGradeId(rs.getInt("gradeId"));
				grade.setName(rs.getString("NAME"));
				grades.add(grade);
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
		return grades;
	}
	
	public int addGrade(Grade grade) {
		int result=0;
		try {
			String sql="INSERT INTO `grade` (`NAME`) VALUES (?);";
			Object[] params={grade.getName()};
			result=super.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Grade getGrade(int gradeId) {
		Grade grade=null;
		Object[] params={gradeId};
		try {
			String sql="SELECT * FROM grade WHERE gradeId=?;";
			ResultSet rs=super.executeQuery(sql, params);
			while (rs.next()) {
				grade=new Grade();
				grade.setGradeId(rs.getInt("gradeId"));
				grade.setName(rs.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return grade;
	}

	public int updateGrade(Grade grade) {
		int result=0;
		try {
			String sql="UPDATE `grade` SET `NAME` = ? WHERE `gradeId` =?;";
			Object[] params={grade.getName(),grade.getGradeId()};
			result=super.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int delGrade(int gradeId) {
		int result=0;
		try {
			String sql="DELETE FROM `grade` WHERE `gradeId` =?;";
			Object[] params={gradeId};
			result=super.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		GradeDaoImpl gradeDao=new GradeDaoImpl();
		int result=gradeDao.delGrade(5);
	}

	


}
