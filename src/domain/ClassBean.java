package domain;

import java.util.List;

public class ClassBean {
	private String classID;//课程ID
	private String className;//课程名
	private String teacherID;//授课老师
	private int classNum;//课程节数
	
	private List<StudentBean> students;
	public List<StudentBean> getStudents() {
		return students;
	}
	public void setStudents(List<StudentBean> students) {
		this.students = students;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacher) {
		this.teacherID = teacher;
	}
	
	
}
