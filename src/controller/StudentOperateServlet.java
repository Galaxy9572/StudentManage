package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.StudentBean;
import service.StudentManageService;
import service.impl.StudentManageServiceImpl;

@WebServlet("/StudentOperateServlet")
public class StudentOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentManageService studentService= new StudentManageServiceImpl();
	
    public StudentOperateServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentOperateServlet");
		String stuNum=request.getParameter("stuNum");
		System.out.println(stuNum);
		StudentBean bean = studentService.queryStudentByNum(stuNum);
		System.out.println(bean.getStuName());
	}

}
