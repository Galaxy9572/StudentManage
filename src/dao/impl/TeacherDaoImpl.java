package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.TeacherDao;
import domain.TeacherBean;
import util.HibernateSessionFactory;

public class TeacherDaoImpl implements TeacherDao {
	private Session session = HibernateSessionFactory.getSession();

	@Override
	public boolean createTeacher(TeacherBean teacherBean) {
		try {
			Transaction transaction = session.beginTransaction();
			session.save(teacherBean);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherBean> queryTeacherByName(String teacherName) {
		List<TeacherBean> resList = session.createQuery("from TeacherBean t where t.teacherName='" + teacherName + "'")
				.list();
		if (resList.isEmpty()) {
			return null;
		}
		return resList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TeacherBean queryTeacherByTeacherID(String teacherID) {
		List<TeacherBean> resList = session.createQuery("from TeacherBean t where t.teacherID='" + teacherID + "'")
				.list();
		if (resList.isEmpty()) {
			return null;
		}
		return resList.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryPassword(String teacherID) {
		List<TeacherBean> resList = session.createQuery("from TeacherBean t where t.teacherID='" + teacherID + "'")
				.list();
		if (resList.isEmpty()) {
			return null;
		}
		return resList.get(0).getPassword();
	}

}
