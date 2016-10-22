package dao;

import java.util.List;

import domain.ClassBean;

public interface ClassDao {
	/**
	 * 创建一个新的课程
	 * 
	 * @param ClassBean
	 * @return 成功则返回true，否则返回false
	 */
	public boolean createClass(ClassBean classBean);

	/**
	 * 更新课程信息
	 * 
	 * @param ClassBean
	 * @return 成功则返回新的ClassBean，否则返回null
	 */
	public ClassBean updateClass(ClassBean classBean);

	/**
	 * 根据课程ID查找课程
	 * 
	 * @param classID
	 * @return 成功则返回ClassBean，否则返回null
	 */
	public ClassBean queryClassByID(String classID);

	/**
	 * 列出所有的课程
	 * 
	 * @return List<ClassBean>
	 */
	public List<ClassBean> listAllClasses();
}
