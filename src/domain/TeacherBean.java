package domain;

public class TeacherBean {
	private String teacherID;//教师编号
	private String teacherName;//教师姓名
	private String gender;//性别
	private int age;//年龄
	private String password;//密码
	private String major;//所教课程
	
	public TeacherBean() {
		
	}
	
	public TeacherBean(String teacherName,String teacherID, String gender, int age, String major,String password) {
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.gender = gender;
		this.age = age;
		this.major=major;
		this.password = password;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
