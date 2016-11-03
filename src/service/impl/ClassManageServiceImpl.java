package service.impl;

import java.util.List;

import dao.impl.ClassDaoImpl;
import domain.ClassBean;
import service.ClassManageService;

public class ClassManageServiceImpl implements ClassManageService {
	private ClassDaoImpl classDao=new ClassDaoImpl();
	@Override
	public boolean createClass(ClassBean classBean) {
		return classDao.createClass(classBean);
	}

	@Override
	public ClassBean updateClass(ClassBean oldBean,ClassBean newBean) {
		return classDao.updateClass(oldBean,newBean);
	}

	@Override
	public ClassBean queryClassByID(String classID) {
		return classDao.queryClassByID(classID);
	}

	@Override
	public List<ClassBean> listAllClasses() {
		return classDao.listAllClasses();
	}
}
