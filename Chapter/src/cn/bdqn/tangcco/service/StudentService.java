package cn.bdqn.tangcco.service;

import java.util.List;

import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.util.Page;

public interface StudentService {
	/**
	 * 实现用户登录操作
	 * @param uname 用户名
	 * @param pwd 密码
	 * @return 用户信息
	 */
	public Student login(String uname,String pwd);
	public List<Student> searchByName(String name);
	/**
	 * 查询全部学员信息
	 * @return 信息列表
	 */
	public List<Student> getAll();
	
	/**
	 * 添加学生信息
	 * @param student 学生信息
	 * @return 大于0的值 >0成功　否则失败
	 */
	public int addStudent(Student student);
	/**
	 * 查询某位学员信息
	 * @param stuNo
	 * @return
	 */
	public Student searchByStuNo(int stuNo);
	
	/**
	 * 删除学员信息
	 * @param stuNo 学号
	 * @return >=1的值成功 否则失败
	 */
	public int delStudent(int stuNo);
	/**
	 * 修改学员信息
	 * @param student 学生对象
	 * @return >=1的值成功 否则失败
	 */
	public int updateStudent(Student student);
	//分页 1.统计总记录数
	//分页 2.每页显示信息列表
	/**
	 * 统计每页显示学员信息
	 * @param pageIndex 页号
	 * @param pageSize 每页显示总记录数
	 * @return 学员信息
	 */
	public Page<Student> getPage(int pageIndex,int pageSize);
}
