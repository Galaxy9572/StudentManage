package dao;

import java.util.List;

import domain.TeacherBean;

public interface TeacherDao {
	/**
	 * 创建一个新的教师
	 * 
	 * @param teacherBean
	 * @return TeacherBean
	 */
	public boolean createTeacher(TeacherBean teacherBean);

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
	public TeacherBean queryTeacherByTeacherID(String teacherId);
	
	/**
	 * 根据教师ID查找密码
	 * @param teacherID
	 * @return 成功则返回密码，否则返回null
	 */
	public String queryPassword(String teacherID);

}
