package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ClassDao;
import domain.ClassBean;
import util.HibernateSessionFactory;

public class ClassDaoImpl implements ClassDao {
	private Session session=HibernateSessionFactory.getSession();
	@Override
	public boolean createClass(ClassBean classBean) {
		try {
			session = HibernateSessionFactory.getSession();
			Transaction transaction=session.beginTransaction();
			session.save(classBean);
			session.flush();
			session.clear();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ClassBean updateClass(ClassBean oldBean,ClassBean newBean) {
		try {
			Transaction transaction=session.beginTransaction();
			newBean.setClassID(oldBean.getClassID());
			session.update(newBean);
			session.flush();
			session.clear();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return queryClassByID(newBean.getClassID());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassBean> listAllClasses() {
		List<ClassBean> resList=session.createQuery("from ClassBean").list();
		session.flush();
		session.clear();
		if(resList.isEmpty()){
			return null;
		}
		return resList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClassBean queryClassByID(String classID) {
		List<ClassBean> resList=session.createQuery("from ClassBean c where c.classID='"+classID+"'").list();
		session.flush();
		session.clear();
		if(resList.isEmpty()){
			return null;
		}
		return resList.get(0);
	}

}
