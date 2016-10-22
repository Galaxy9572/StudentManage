package domain;

public class ClassBean {
	private String classID;//课程ID
	private String className;//课程名
	private int classNum;//课程节数
	private String teacherID;//授课老师
	
	public ClassBean(String classID, String className, int classNum, String teacherID) {
		this.classID = classID;
		this.className = className;
		this.classNum = classNum;
		this.teacherID = teacherID;
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
