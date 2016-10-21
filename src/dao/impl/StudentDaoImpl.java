package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
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
			Transaction transaction=session.beginTransaction();
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
		System.out.println("StudentDaoImpl");
		List<StudentBean> resList=session.createQuery("from StudentBean stu where stu.stuNum='"+stuNum+"'").list();
		System.out.println(resList.isEmpty());
		if(resList.isEmpty()){
			return null;
		}
		return resList.get(0);
	}

	@Override
	public List<ClassBean> listAllSelectedClasses(String stuNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
