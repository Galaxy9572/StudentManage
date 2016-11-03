package service;

import java.util.List;

import domain.TeacherBean;

public interface TeacherManageService {

	/**
	 * 创建一个新的教师
	 * 
	 * @param teacherBean
	 * @return TeacherBean
	 */
	public boolean reg(TeacherBean teacherBean);

	/**
	 * 根据教师姓名查找教师
	 * 
	 * @param teacherName
	 * @return 成功则返回List<TeacherBean>，否则返回null
	 */
	public List<TeacherBean> queryTeacherByName(String teacherName);

	/**
	 * 根据教师ID查找教师
	 * 
	 * @param teacherID
	 * @return 成功则返回TeacherBean，否则返回null
	 */
	public TeacherBean queryTeacherByTeacherID(String teacherID);

	/**
	 * 老师登录
	 * @param teacherName
	 * @param password
	 * @return 成功返回true，否则返回false
	 */
	boolean login(String teacherID, String password);
}
