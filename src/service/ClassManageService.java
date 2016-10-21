package service;

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
	 * @param ClassBean
	 * @return 成功则返回新的ClassBean，否则返回null
	 */
	public ClassBean updateClass(ClassBean classBean);
}
