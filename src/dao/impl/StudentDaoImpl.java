package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.StudentDao;
import domain.StudentBean;
import util.HibernateSessionFactory;

public class StudentDaoImpl implements StudentDao {
	private Session session=HibernateSessionFactory.getSession();
	@Override
	public boolean createStudent(StudentBean studentBean) {
		try {
			session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(studentBean);
			transaction.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteStudentByName(String stuName) {
		try {
			session = HibernateSessionFactory.getSession();
			Transaction t = session.beginTransaction();
			Query q = session.createQuery("delete StudentBean where stuName='" + stuName + "'");
			q.executeUpdate();
			t.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteStudentByNum(String stuNum) {
		try {
			session = HibernateSessionFactory.getSession();
			Transaction t = session.beginTransaction();
			Query q = session.createQuery("delete StudentBean where stuNum='" + stuNum + "'");
			q.executeUpdate();
			t.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public StudentBean updateStudentInfo(StudentBean oldBean,StudentBean newBean) {
		try {
			session = HibernateSessionFactory.getSession();
			Transaction transaction=session.beginTransaction();
			newBean.setStuNum(oldBean.getStuNum());
			session.update(newBean);
			transaction.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return queryStudentByNum(newBean.getStuNum());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentBean> queryStudentByName(String stuName) {
		List<StudentBean> resList = session.createQuery("from StudentBean stu where stu.stuName='" + stuName + "'")
				.list();
		session.flush();
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
		session.flush();
		if (resList.isEmpty()) {
			return null;
		}
		return resList.get(0);
	}

	@SuppressWarnings("unchecked")
	public String queryPassword(String stuNum) {
		List<StudentBean> resList = session.createQuery("from StudentBean stu where stu.stuNum='" + stuNum + "'")
				.list();
		session.flush();
		if (resList.isEmpty()) {
			return null;
		}
		return resList.get(0).getPassword();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String listAllSelectedClasses(String stuNum) {
		List<StudentBean> results = session.createQuery("from StudentBean stu where stu.stuNum='" + stuNum + "'")
				.list();
		session.flush();
		if (results.isEmpty()) {
			return "";
		}
		return results.get(0).getSelected();
	}

	@Override
	public boolean updateSelectedClasses(String stuNum,String className) {
		try {
			session.beginTransaction();
			String selected=queryStudentByNum(stuNum).getSelected();
			Query query =null;
			if("".equals(selected)){
				query = session.createQuery("update StudentBean s set s.selected ="+"'"+className+"' where stuNum="+"'"+stuNum+"'");
			}else{
				query = session.createQuery("update StudentBean s set s.selected = "+"'"+selected+","+className+"' where stuNum="+"'"+stuNum+"'");
			}
			query.executeUpdate();
			session.getTransaction().commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
