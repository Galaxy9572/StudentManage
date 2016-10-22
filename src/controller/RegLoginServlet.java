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
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if ("stuReg".equals(cmd)) {
			if (stuReg(request, response)) {
				request.getRequestDispatcher("/jsp/regSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/regFailure.jsp").forward(request, response);
			}
		} else if ("stuLogin".equals(cmd)) {
			if (stuLogin(request, response)) {
				request.getRequestDispatcher("/jsp/loginSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/loginFailure.jsp").forward(request, response);
			}
		} else if ("teacherReg".equals(cmd)) {
			if (teacherReg(request, response)) {
				request.getRequestDispatcher("/jsp/regSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/regFailure.jsp").forward(request, response);
			}
		} else if ("teacherLogin".equals(cmd)) {
			if (teacherLogin(request, response)) {
				request.getRequestDispatcher("/jsp/loginSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/loginFailure.jsp").forward(request, response);
			}
		}else if("valStuNum".equals(cmd)){
			if(isStuNumExists(request.getParameter("valStuNum"))){
				response.getWriter().println("false");
			}
			response.getWriter().println("true");
		}
	}

	private boolean stuReg(HttpServletRequest request, HttpServletResponse response) {
		String stuName = request.getParameter("stuName").trim();
		String stuNum = request.getParameter("stuNum").trim();
		String gender = request.getParameter("gender").trim();
		int age = Integer.valueOf(request.getParameter("age"));
		String password = request.getParameter("password").trim();
		if(!isStuNumExists(stuNum)){
			 StudentBean studentBean=new StudentBean(stuName, stuNum, gender, age, password);
			 return studentService.reg(studentBean);
		}
		return false;
	}

	private boolean stuLogin(HttpServletRequest request, HttpServletResponse response) {
		String stuNum = request.getParameter("ID").trim();
		String password = request.getParameter("password").trim();
		return studentService.login(stuNum, password);
	}

	private boolean teacherReg(HttpServletRequest request, HttpServletResponse response) {
		String teacherName = request.getParameter("teacherName").trim();
		String teacherID = request.getParameter("teacherID").trim();
		String gender = request.getParameter("gender").trim();
		int age = Integer.valueOf(request.getParameter("age"));
		String major = request.getParameter("major").trim();
		String password = request.getParameter("password").trim();
		if (isTeacherIDExists(teacherID)) {
			TeacherBean teacherBean = new TeacherBean(teacherName, teacherID, gender, age, major, password);
			return teacherService.reg(teacherBean);
		}
		return false;
	}

	private boolean teacherLogin(HttpServletRequest request, HttpServletResponse response) {
		String teacherID = request.getParameter("ID").trim();
		String password = request.getParameter("password").trim();
		return teacherService.login(teacherID, password);
	}
	
	private boolean isStuNumExists(String stuNum){
		if(studentService.queryStudentByNum(stuNum)!=null){
			return true;
		}
		return false;
	}
	
	private boolean isTeacherIDExists(String teacherID){
		if(teacherService.queryTeacherByTeacherId(teacherID)!=null){
			return true;
		}
		return false;
	}
}
