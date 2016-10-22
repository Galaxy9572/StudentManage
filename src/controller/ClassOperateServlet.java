package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ClassBean;
import service.impl.ClassManageServiceImpl;

@WebServlet("/ClassOperateServlet")
public class ClassOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassManageServiceImpl classService = new ClassManageServiceImpl();

	public ClassOperateServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addClass(request,response);
	}

	private boolean addClass(HttpServletRequest request, HttpServletResponse response) {
		String classID = request.getParameter("classID");
		String className = request.getParameter("className");
		int classNum = Integer.valueOf(request.getParameter("classNum"));
		String teacherID = request.getParameter("teacherID");
		if (!isClassIDExists(classID)) {
			ClassBean classBean = new ClassBean(classID, className, classNum, teacherID);
			return classService.createClass(classBean);
		}
		return false;
	}

	private boolean isClassIDExists(String classID) {
		if (classService.queryClassByID(classID) != null) {
			return true;
		}
		return false;
	}
}
