package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentManageService;
import service.impl.StudentManageServiceImpl;
import util.JSONUtil;

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
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getParameter("cmd");
		if("findStuByStuNum".equals(cmd)){
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(findStuByStuNum(request, response));
		}else if("findStuByStuName".equals(cmd)){
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(findStuByStuName(request, response));
		}else if("delStuByStuNum".equals(cmd)){
			response.getWriter().write(delStuByStuNum(request, response));
		}
	}

	private int delStuByStuNum(HttpServletRequest request, HttpServletResponse response) {
		String stuNum=request.getParameter("stuNum");
		if(studentService.deleteStudentByNum(stuNum)){
			System.out.println(1);
			return 1;
		}
		System.out.println(0);
		return 0;
	}

	private String findStuByStuNum(HttpServletRequest request, HttpServletResponse response){
		String stuNum=request.getParameter("stuNum");
		return JSONUtil.object2json(studentService.queryStudentByNum(stuNum));
	}
	
	private String findStuByStuName(HttpServletRequest request, HttpServletResponse response){
		String stuName=request.getParameter("stuName");
		return JSONUtil.list2json(studentService.queryStudentByName(stuName));
	}
}
