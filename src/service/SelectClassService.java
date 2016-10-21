package service;

import java.util.List;

import domain.ClassBean;

public interface SelectClassService {
	/**
	 * 列出所有的课程
	 * 
	 * @return 所有课程的List
	 */
	public List<ClassBean> listAllClasses();

	/**
	 * 选课（一门或多门）
	 * 
	 * @param List<ClassBean>
	 * @return List<ClassBean>
	 */
	public List<ClassBean> selectClasses(List<ClassBean> classes);
}
