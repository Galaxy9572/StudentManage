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
			Transaction transaction=session.beginTransaction();
			session.save(teacherBean);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
