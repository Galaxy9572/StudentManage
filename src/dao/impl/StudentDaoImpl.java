package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.StudentDao;
import domain.ClassBean;
import domain.StudentBean;
import util.HibernateSessionFactory;

public class StudentDaoImpl implements StudentDao {

	private Session session = HibernateSessionFactory.getSession();

	@Override
	public boolean createStudent(StudentBean studentBean) {
		try {
			Transaction transaction = session.beginTransaction();
			session.save(studentBean);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteStudentByName(String stuName) {

		return true;
	}

	@Override
	public boolean deleteStudentByNum(String stuNum) {
		try {
			Transaction t = session.beginTransaction();
			Query q = session.createQuery("delete StudentBean where stuNum='" + stuNum + "'");
			q.executeUpdate();
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public StudentBean updateStudentInfo(StudentBean studentBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentBean> queryStudentByName(String stuName) {
		List<StudentBean> resList = session.createQuery("from StudentBean stu where stu.stuName='" + stuName + "'")
				.list();
		if (resList.isEmpty()) {
			return null;
		}
		return resList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StudentBean queryStudentByNum(String stuNum) {
		List<StudentBean> resList = session.createQuery("from StudentBean stu where stu.stuNum='" + stuNum + "'")
				.list();
		if (resList.isEmpty()) {
			return null;
		}
		return resList.get(0);
	}

	@SuppressWarnings("unchecked")
	public String queryPassword(String stuNum) {
		List<StudentBean> resList = session.createQuery("from StudentBean stu where stu.stuNum='" + stuNum + "'")
				.list();
		if (resList.isEmpty()) {
			return null;
		}
		return resList.get(0).getPassword();
	}

	@Override
	public List<ClassBean> listAllSelectedClasses(String stuNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
