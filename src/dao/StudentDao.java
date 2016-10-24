package dao;

import java.util.List;

import domain.StudentBean;

public interface StudentDao {
	/**
	 * 创建一个新的学生
	 * 
	 * @param studentBean
	 * @return 成功则返回true，否则返回false
	 */
	public boolean createStudent(StudentBean studentBean);

	/**
	 * 根据学生姓名删除学生
	 * 
	 * @param stuName
	 * @return 成功则返回true，否则返回false
	 */
	public boolean deleteStudentByName(String stuName);

	/**
	 * 根据学生学号删除学生
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
	public StudentBean updateStudentInfo(StudentBean oldBean,StudentBean newBean);

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
	 * 根据学号查询学生的密码
	 * @param stuNum
	 * @return 成功则返回密码，否则返回null
	 */
	public String queryPassword(String stuNum);
	
	/**
	 * 列出指定学号的的学生的所有所选课程
	 * 
	 * @param stuNum
	 * @return 成功则返回String，否则返回null
	 */
	public String listAllSelectedClasses(String stuNum);

}
