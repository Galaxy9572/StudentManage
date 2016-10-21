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
	public boolean login(String stuName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudentByName(String stuName) {
		return studentDao.deleteStudentByName(stuName);
	}

	@Override
	public boolean deleteStudentByNum(String stuNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudentBean updateStudentInfo(StudentBean studentBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentBean> queryStudentByName(String stuName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBean queryStudentByNum(String stuNum) {
		System.out.println("StudentManageServiceImpl");
		return studentDao.queryStudentByNum(stuNum);
	}

	@Override
	public List<ClassBean> listAllSelectedClasses(String stuNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
