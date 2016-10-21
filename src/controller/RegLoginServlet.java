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
	StudentManageService studentService=new StudentManageServiceImpl();
	TeacherManageService teacherService=new TeacherManageServiceImpl();
       
    public RegLoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		if("stuReg".equals(cmd)){
			if(stuReg(request,response)){
				request.getRequestDispatcher("/jsp/regSuccess.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/jsp/regFailure.jsp").forward(request, response);
			}
		}else if("stuLogin".equals(cmd)){
			stuLogin(request,response);
		}else if("teacherReg".equals(cmd)){
			teacherReg(request, response);
		}else if("teacherLogin".equals(cmd)){
			teacherLogin(request, response);
		}
	}

	private boolean stuReg(HttpServletRequest request, HttpServletResponse response){
		String stuName=request.getParameter("stuName");
		String stuNum=request.getParameter("stuNum");
		String gender=request.getParameter("gender");
		int age=Integer.valueOf(request.getParameter("age"));
		String password=request.getParameter("password");
		String cfpassword=request.getParameter("cfpassword");
		if(password.equals(cfpassword)){
			StudentBean studentBean=new StudentBean(stuName,stuNum,gender,age,password);
			return studentService.reg(studentBean);
		}
		return false;
	}
	
	private boolean stuLogin(HttpServletRequest request, HttpServletResponse response) {
		
		return false;
	}

	
	private boolean teacherReg(HttpServletRequest request, HttpServletResponse response){
		String teacherName=request.getParameter("teacherName");
		String teacherID=request.getParameter("teacherID");
		String gender=request.getParameter("gender");
		int age=Integer.valueOf(request.getParameter("age"));
		String major=request.getParameter("major");
		String password=request.getParameter("password");
		String cfpassword=request.getParameter("cfpassword");
		if(password.equals(cfpassword)){
			TeacherBean teacherBean=new TeacherBean(teacherName,teacherID,gender,age,major,password);
			return teacherService.reg(teacherBean);
		}
		return false;
	}
	
	private boolean teacherLogin(HttpServletRequest request, HttpServletResponse response){
		return false;
	}
}
