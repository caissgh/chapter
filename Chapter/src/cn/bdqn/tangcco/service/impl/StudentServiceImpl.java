package cn.bdqn.tangcco.service.impl;
import java.util.List;

import cn.bdqn.tangcco.dao.StudentDao;
import cn.bdqn.tangcco.dao.impl.StudentDaoImpl;
import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.service.StudentService;
import cn.bdqn.tangcco.util.Page;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	public StudentServiceImpl(){
		studentDao=new StudentDaoImpl();
	}
	public Student login(String uname, String pwd) {
		return studentDao.findUser(uname, pwd);
	}
	public List<Student> getAll() {
		return studentDao.getAll();
	}
	public int addStudent(Student student) {
		return studentDao.addStudent(student);
	}
	public Student searchByStuNo(int stuNo) {
		return studentDao.searchByStuNo(stuNo);
	}
	public int delStudent(int stuNo) {
		return studentDao.delStudent(stuNo);
	}
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
	public Page<Student> getPage(int pageIndex, int pageSize) {
		Page<Student> pages=new Page<Student>();
		pages.setPageSize(pageSize);
		int totalCount=studentDao.getTotalCount();
		pages.setTotalCount(totalCount);
		if (pageIndex>pages.getPageTotalCount()) {
			pageIndex=pages.getPageTotalCount();
		}
		if (pageIndex<1) {
			pageIndex=1;
		}
		pages.setCurrentIndex(pageIndex);
		List<Student> studentList=studentDao.getStudents(pageIndex, pageSize);
		pages.setPageList(studentList);
		return pages;
	}
	
	public static void main(String[] args) {
		StudentServiceImpl studentService=new StudentServiceImpl();
		int pageIndex=3;
		int pageSize=2;
		
		Page<Student> pages=studentService.getPage(pageIndex, pageSize);
		System.out.println("总记录数:"+pages.getTotalCount());
		System.out.println("总页数:"+pages.getPageTotalCount());
		System.out.println("当前页:"+pages.getCurrentIndex());
		System.out.println("当前页信息：");
		List<Student> students=pages.getPageList();
		for (Student student : students) {
			System.out.println(student.getStudentNo()+"\t"+student.getStudentName()+"\t"+student.getGradeName());
		}	
	
	}
	public List<Student> searchByName(String name) {
		return studentDao.searchByName(name);
	}
	
	
}
