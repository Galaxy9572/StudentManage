package service;

import java.util.List;

import domain.ClassBean;
import domain.StudentBean;

public interface StudentManageService {
	/**
	 * 注册一个新的学生
	 * 
	 * @param studentBean
	 * @return 成功则返回true，否则返回false
	 */
	public boolean reg(StudentBean studentBean);

	/**
	 * 学生登录
	 * 
	 * @param stuName
	 * @param password
	 * @return 成功则返回true，否则返回false
	 */
	public boolean login(String stuNum, String password);

	/**
	 * 根据姓名删除学生
	 * 
	 * @param stuName
	 * @return 成功则返回true，否则返回false
	 */
	public boolean deleteStudentByName(String stuName);

	/**
	 * 根据学号删除学生
	 * 
	 * @param stuNum
	 * @return 成功则返回true，否则返回false
	 */
	public boolean deleteStudentByNum(String stuNum);

	/**
	 * 更新学生信息
	 * 
	 * @param studentBean
	 * @return 成功则返回新的StudentBean，否则返回null
	 */
	public StudentBean updateStudentInfo(StudentBean studentBean);

	/**
	 * 根据学生姓名查找学生
	 * 
	 * @param stuName
	 * @return 成功则返回List<StudentBean>，否则返回null
	 */
	public List<StudentBean> queryStudentByName(String stuName);

	/**
	 * 根据学生学号查找学生
	 * 
	 * @param stuNum
	 * @return 成功则返回StudentBean，否则返回null
	 */
	public StudentBean queryStudentByNum(String stuNum);

	/**
	 * 列出指定学号的的学生的所有所选课程
	 * 
	 * @param stuNum
	 * @return 成功则返回List<ClassBean>，否则返回null
	 */
	public List<ClassBean> listAllSelectedClasses(String stuNum);
}
