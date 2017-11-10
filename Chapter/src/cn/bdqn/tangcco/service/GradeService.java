package cn.bdqn.tangcco.service;

import java.util.List;

import cn.bdqn.tangcco.entity.Grade;
/**
 * �꼶ҵ���
 * @author pc
 *
 */
public interface GradeService {
	/**
	 * ��ѯȫ���꼶��Ϣ
	 * @return
	 */
	public List<Grade> findAll();
	/**
	 * ��ѯ�꼶����
	 * @param gradeId
	 * @return
	 */
	public Grade getGrade(int gradeId);
	/**
	 * ����꼶
	 * @param grade �꼶
	 * @return  ��Ӱ�������
	 */
	public int addGrade(Grade grade);
	/**
	 * �޸��꼶
	 * @param grade �꼶
	 * @return  ��Ӱ�������
	 */
	public int updateGrade(Grade grade);
	public int delGrade(int gradeId);
}
