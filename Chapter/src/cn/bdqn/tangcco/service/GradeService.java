package cn.bdqn.tangcco.service;

import java.util.List;

import cn.bdqn.tangcco.entity.Grade;
/**
 * 年级业务层
 * @author pc
 *
 */
public interface GradeService {
	/**
	 * 查询全部年级信息
	 * @return
	 */
	public List<Grade> findAll();
	/**
	 * 查询年级详情
	 * @param gradeId
	 * @return
	 */
	public Grade getGrade(int gradeId);
	/**
	 * 添加年级
	 * @param grade 年级
	 * @return  受影响的行数
	 */
	public int addGrade(Grade grade);
	/**
	 * 修改年级
	 * @param grade 年级
	 * @return  受影响的行数
	 */
	public int updateGrade(Grade grade);
	public int delGrade(int gradeId);
}
