package service.impl;

import java.util.List;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import domain.TeacherBean;
import service.TeacherManageService;

public class TeacherManageServiceImpl implements TeacherManageService {
	private TeacherDao teacherDao=new TeacherDaoImpl();

	public TeacherManageServiceImpl() {

	}

	@Override
	public boolean reg(TeacherBean teacherBean) {
		return teacherDao.createTeacher(teacherBean);
	}
	
	@Override
	public boolean login(String teacherID, String password) {
		if(password.equals(teacherDao.queryPassword(teacherID))){
			return true;
		}
		return false;
	}

	@Override
	public List<TeacherBean> queryTeacherByName(String teacherName) {
		return teacherDao.queryTeacherByName(teacherName);
	}

	@Override
	public TeacherBean queryTeacherByTeacherID(String teacherID) {
		return teacherDao.queryTeacherByTeacherID(teacherID);
	}
}
