package cn.bdqn.tangcco.service;

import java.util.List;

import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.util.Page;

public interface StudentService {
	/**
	 * ʵ���û���¼����
	 * @param uname �û���
	 * @param pwd ����
	 * @return �û���Ϣ
	 */
	public Student login(String uname,String pwd);
	public List<Student> searchByName(String name);
	/**
	 * ��ѯȫ��ѧԱ��Ϣ
	 * @return ��Ϣ�б�
	 */
	public List<Student> getAll();
	
	/**
	 * ���ѧ����Ϣ
	 * @param student ѧ����Ϣ
	 * @return ����0��ֵ >0�ɹ�������ʧ��
	 */
	public int addStudent(Student student);
	/**
	 * ��ѯĳλѧԱ��Ϣ
	 * @param stuNo
	 * @return
	 */
	public Student searchByStuNo(int stuNo);
	
	/**
	 * ɾ��ѧԱ��Ϣ
	 * @param stuNo ѧ��
	 * @return >=1��ֵ�ɹ� ����ʧ��
	 */
	public int delStudent(int stuNo);
	/**
	 * �޸�ѧԱ��Ϣ
	 * @param student ѧ������
	 * @return >=1��ֵ�ɹ� ����ʧ��
	 */
	public int updateStudent(Student student);
	//��ҳ 1.ͳ���ܼ�¼��
	//��ҳ 2.ÿҳ��ʾ��Ϣ�б�
	/**
	 * ͳ��ÿҳ��ʾѧԱ��Ϣ
	 * @param pageIndex ҳ��
	 * @param pageSize ÿҳ��ʾ�ܼ�¼��
	 * @return ѧԱ��Ϣ
	 */
	public Page<Student> getPage(int pageIndex,int pageSize);
}
