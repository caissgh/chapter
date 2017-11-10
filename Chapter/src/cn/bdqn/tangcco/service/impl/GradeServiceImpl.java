package cn.bdqn.tangcco.service.impl;

import java.util.List;

import cn.bdqn.tangcco.dao.GradeDao;
import cn.bdqn.tangcco.dao.impl.GradeDaoImpl;
import cn.bdqn.tangcco.entity.Grade;
import cn.bdqn.tangcco.service.GradeService;

public class GradeServiceImpl implements GradeService {
	private GradeDao gradeDao;
	public GradeServiceImpl(){
		gradeDao=new GradeDaoImpl();
	}
	public List<Grade> findAll() {
		return gradeDao.findAll();
	}
	public int addGrade(Grade grade) {
		return gradeDao.addGrade(grade);
	}
	public Grade getGrade(int gradeId) {
		return gradeDao.getGrade(gradeId);
	}
	public int updateGrade(Grade grade) {
		return gradeDao.updateGrade(grade);
	}
	public int delGrade(int gradeId) {
		return gradeDao.delGrade(gradeId);
	}
	public static void main(String[] args) {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		int result=gradeService.delGrade(6);
	}
	
}
