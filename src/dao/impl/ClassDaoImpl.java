package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ClassDao;
import domain.ClassBean;
import util.HibernateSessionFactory;

public class ClassDaoImpl implements ClassDao {
	private Session session = HibernateSessionFactory.getSession();

	@Override
	public boolean createClass(ClassBean classBean) {
		try {
			Transaction transaction=session.beginTransaction();
			session.save(classBean);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ClassBean updateClass(ClassBean classBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassBean> listAllClasses() {
		List<ClassBean> resList=session.createQuery("from ClassBean").list();
		if(resList.isEmpty()){
			return null;
		}
		return resList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClassBean queryClassByID(String classID) {
		List<ClassBean> resList=session.createQuery("from ClassBean c where c.classID='"+classID+"'").list();
		if(resList.isEmpty()){
			return null;
		}
		return resList.get(0);
	}

}
