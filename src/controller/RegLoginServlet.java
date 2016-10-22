package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.StudentBean;
import domain.TeacherBean;
import service.StudentManageService;
import service.TeacherManageService;
import service.impl.StudentManageServiceImpl;
import service.impl.TeacherManageServiceImpl;

@WebServlet("/RegLoginServlet")
public class RegLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentManageService studentService = new StudentManageServiceImpl();
	TeacherManageService teacherService = new TeacherManageServiceImpl();

	public RegLoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if ("stuReg".equals(cmd)) {
			if (stuReg(request, response)) {
				request.setAttribute("regResult", "注册成功！");
			} else {
				request.setAttribute("regResult", "注册失败！");
			}
			request.getRequestDispatcher("/jsp/regResult.jsp").forward(request, response);
		} else if ("stuLogin".equals(cmd)) {
			if (stuLogin(request, response)) {
				request.setAttribute("loginResult", "登录成功！");
			} else {
				request.setAttribute("loginResult", "登录失败！");
			}
			request.getRequestDispatcher("/jsp/loginResult.jsp").forward(request, response);
		} else if ("teacherReg".equals(cmd)) {
			if (teacherReg(request, response)) {
				request.setAttribute("regResult", "注册成功！");
			} else {
				request.setAttribute("regResult", "注册失败！");
			}
			request.getRequestDispatcher("/jsp/regResult.jsp").forward(request, response);
		} else if ("teacherLogin".equals(cmd)) {
			if (teacherLogin(request, response)) {
				request.setAttribute("loginResult", "登录成功！");
			} else {
				request.setAttribute("loginResult", "登录失败！");
			}
			request.getRequestDispatcher("/jsp/loginResult.jsp").forward(request, response);
		} else if ("valStuNum".equals(cmd)) {
			if (isStuNumExists(request.getParameter("valStuNum"))) {
				response.getWriter().println("false");
			}
			response.getWriter().println("true");
		}
	}

	/**
	 * 学生注册
	 * 
	 * @param request
	 * @param response
	 * @return 成功则返回true，否则返回false
	 */
	private boolean stuReg(HttpServletRequest request, HttpServletResponse response) {
		String stuName = request.getParameter("stuName").trim();
		String stuNum = request.getParameter("stuNum").trim();
		String gender = request.getParameter("gender").trim();
		int age = Integer.valueOf(request.getParameter("age"));
		String password = request.getParameter("password").trim();
		if (!isStuNumExists(stuNum)) {
			StudentBean studentBean = new StudentBean(stuName, stuNum, gender, age, password);
			return studentService.reg(studentBean);
		}
		return false;
	}

	/**
	 * 学生登录
	 * 
	 * @param request
	 * @param response
	 * @return 成功则返回true，否则返回false
	 */
	private boolean stuLogin(HttpServletRequest request, HttpServletResponse response) {
		String stuNum = request.getParameter("ID").trim();
		String password = request.getParameter("password").trim();
		return studentService.login(stuNum, password);
	}

	/**
	 * 老师注册
	 * 
	 * @param request
	 * @param response
	 * @return 成功则返回true，否则返回false
	 */
	private boolean teacherReg(HttpServletRequest request, HttpServletResponse response) {
		String teacherName = request.getParameter("teacherName").trim();
		String teacherID = request.getParameter("teacherID").trim();
		String gender = request.getParameter("gender").trim();
		int age = Integer.valueOf(request.getParameter("age"));
		String major = request.getParameter("major").trim();
		String password = request.getParameter("password").trim();
		System.out.println(teacherName+","+teacherID+","+gender+","+age+","+major+","+password);
		if (!isTeacherIDExists(teacherID)) {
			TeacherBean teacherBean = new TeacherBean(teacherName, teacherID, gender, age, major, password);
			return teacherService.reg(teacherBean);
		}
		return false;
	}

	/**
	 * 老师登录
	 * 
	 * @param request
	 * @param response
	 * @return 成功则返回true，否则返回false
	 */
	private boolean teacherLogin(HttpServletRequest request, HttpServletResponse response) {
		String teacherID = request.getParameter("ID").trim();
		String password = request.getParameter("password").trim();
		return teacherService.login(teacherID, password);
	}

	/**
	 * 根据学号判断学生是否存在
	 * 
	 * @param stuNum
	 * @return 存在则返回true，否则返回false
	 */
	private boolean isStuNumExists(String stuNum) {
		if (studentService.queryStudentByNum(stuNum) != null) {
			return true;
		}
		return false;
	}

	/**
	 * 根据编号判断老师是否存在
	 * 
	 * @param stuNum
	 * @return 存在则返回true，否则返回false
	 */
	private boolean isTeacherIDExists(String teacherID) {
		if (teacherService.queryTeacherByTeacherId(teacherID) != null) {
			return true;
		}
		return false;
	}
}
