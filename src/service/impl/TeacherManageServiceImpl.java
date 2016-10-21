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
	public boolean login(String teacherName, String password) {

		return false;
	}

	@Override
	public List<TeacherBean> queryTeacherByName(String teacherName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherBean queryTeacherByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}
