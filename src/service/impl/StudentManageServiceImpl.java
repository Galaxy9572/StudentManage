package service.impl;

import java.util.List;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.ClassBean;
import domain.StudentBean;
import service.StudentManageService;

public class StudentManageServiceImpl implements StudentManageService {
	private StudentDao studentDao=new StudentDaoImpl();;
	public StudentManageServiceImpl() {

	}

	@Override
	public boolean reg(StudentBean studentBean) {
		return studentDao.createStudent(studentBean);
	}

	@Override
	public boolean login(String stuNum, String password) {
		if(password.equals(studentDao.queryPassword(stuNum))){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudentByName(String stuName) {
		return studentDao.deleteStudentByName(stuName);
	}

	@Override
	public boolean deleteStudentByNum(String stuNum) {
		return studentDao.deleteStudentByNum(stuNum);
	}

	@Override
	public StudentBean updateStudentInfo(StudentBean studentBean) {
		return studentDao.updateStudentInfo(studentBean);
	}

	@Override
	public List<StudentBean> queryStudentByName(String stuName) {
		return studentDao.queryStudentByName(stuName);
	}

	@Override
	public StudentBean queryStudentByNum(String stuNum) {
		return studentDao.queryStudentByNum(stuNum);
	}
	
	

	@Override
	public List<ClassBean> listAllSelectedClasses(String stuNum) {
		return studentDao.listAllSelectedClasses(stuNum);
	}

}
