package cn.bdqn.tangcco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bdqn.tangcco.util.ConfigManager;

/**
 * Dao层的通用类
 * @author pc
 *
 */
public class BaseDao {
	protected Connection conn=null;
	protected PreparedStatement pstmt=null;
	protected ResultSet rs=null;
	
	/**
	 * 获得连接对象
	 * @return
	 */
	public  boolean getConnection(){
		String driver=ConfigManager.getInstance().getString("jdbc.driver_class");
		String url=ConfigManager.getInstance().getString("jdbc.connection.url");
		String uname=ConfigManager.getInstance().getString("jdbc.connection.username");
		String pwd=ConfigManager.getInstance().getString("jdbc.connection.password");
		
		try {
			Class.forName(driver);//1.加载驱动
			//2.获得连接Connection对象
			conn=DriverManager.getConnection(url,uname,pwd);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 增删改通用方法
	 * @param sql 命令
	 * @param params 参数
	 * @return 返回结果
	 */
	public int executeUpdate(String sql,Object[] params){
		int result=0;
		try {
			if (getConnection()) {
				//增删改操作
				pstmt=conn.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject((i+1), params[i]);
				}
				result=pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return result;
	}
	/**
	 * 增删改通用方法
	 * @param sql 命令
	 * @param params 参数
	 * @return 返回结果
	 */
	public ResultSet executeQuery(String sql,Object[] params){
		try {
			if (getConnection()) {//1.2.
				//增删改操作
				pstmt=conn.prepareStatement(sql); //3.
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject((i+1), params[i]);
				}
				rs=pstmt.executeQuery();//4.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭
		}
		return rs;
	}
	/**
	 * 释放资源
	 */
	public void closeAll(){
		try {
			if(pstmt!=null){
				pstmt.close();
			}
			if(rs!=null){
				rs.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
