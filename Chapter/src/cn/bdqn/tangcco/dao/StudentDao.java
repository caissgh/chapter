package cn.bdqn.tangcco.dao;

import java.util.List;

import cn.bdqn.tangcco.entity.Student;
/**
 * 对学生信息的全部业务处理
 * @author pc
 *
 */
public interface StudentDao {
	public Student findUser(String uname,String pwd);
	/**
	 * 查询全部学员信息
	 * @return 信息列表
	 */
	public List<Student> getAll();
	
	/**
	 * 查询某位学员信息
	 * @param stuNo
	 * @return
	 */
	public Student searchByStuNo(int stuNo);
	public List<Student> searchByName(String name);
	/**
	 * 添加学生信息
	 * @param student 学生信息
	 * @return 大于0的值 >0成功　否则失败
	 */
	public int addStudent(Student student);
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
	 * 统计总记录数
	 */
	public int getTotalCount();
	/**
	 * 统计每页显示学员信息
	 * @param pageIndex 页号
	 * @param pageSize 每页显示总记录数
	 * @return 学员信息
	 */
	public List<Student> getStudents(int pageIndex,int pageSize);
}
