package service;

import java.util.List;

import domain.ClassBean;

public interface ClassManageService {

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
	 * @param ClassBean ClassBean
	 * @return 成功则返回新的ClassBean，否则返回null
	 */
	public ClassBean updateClass(ClassBean oldBean,ClassBean newBean);
	
	/**
	 * 根据课程ID查找课程
	 * 
	 * @param classID
	 * @return 成功则返回ClassBean，否则返回null
	 */
	public ClassBean queryClassByID(String classID);

	/**
	 * 列出所有课程
	 * 
	 * @return 成功则返回List<ClassBean>，否则返回null
	 */
	public List<ClassBean> listAllClasses();
}
