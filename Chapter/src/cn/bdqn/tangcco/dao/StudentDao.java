package cn.bdqn.tangcco.dao;

import java.util.List;

import cn.bdqn.tangcco.entity.Student;
/**
 * ��ѧ����Ϣ��ȫ��ҵ����
 * @author pc
 *
 */
public interface StudentDao {
	public Student findUser(String uname,String pwd);
	/**
	 * ��ѯȫ��ѧԱ��Ϣ
	 * @return ��Ϣ�б�
	 */
	public List<Student> getAll();
	
	/**
	 * ��ѯĳλѧԱ��Ϣ
	 * @param stuNo
	 * @return
	 */
	public Student searchByStuNo(int stuNo);
	public List<Student> searchByName(String name);
	/**
	 * ���ѧ����Ϣ
	 * @param student ѧ����Ϣ
	 * @return ����0��ֵ >0�ɹ�������ʧ��
	 */
	public int addStudent(Student student);
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
	 * ͳ���ܼ�¼��
	 */
	public int getTotalCount();
	/**
	 * ͳ��ÿҳ��ʾѧԱ��Ϣ
	 * @param pageIndex ҳ��
	 * @param pageSize ÿҳ��ʾ�ܼ�¼��
	 * @return ѧԱ��Ϣ
	 */
	public List<Student> getStudents(int pageIndex,int pageSize);
}
