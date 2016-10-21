package domain;

import java.util.List;

public class StudentBean {
	private String stuName;// 学生名字
	private String stuNum;// 学号
	private String gender;// 性别
	private int age;// 年龄
	private String password;// 密码
	private List<ClassBean> selectedClass;// 已选课程

	public StudentBean(String stuName, String stuNum, String gender, int age, String password) {
		this.stuName = stuName;
		this.stuNum = stuNum;
		this.gender = gender;
		this.age = age;
		this.password = password;
	}

	public StudentBean() {
	};

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<ClassBean> getSelectedClass() {
		return selectedClass;
	}

	public void setSelectedClass(List<ClassBean> selectedClass) {
		this.selectedClass = selectedClass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
