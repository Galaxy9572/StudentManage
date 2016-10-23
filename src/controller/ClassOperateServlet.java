package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ClassBean;
import service.impl.ClassManageServiceImpl;
import util.JSONUtil;

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
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		if("addClass".equals(cmd)){
			addClass(request,response);
		}else if("listAll".equals(cmd)){
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(listAllClasses(request, response));
		}
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
	
	private String listAllClasses(HttpServletRequest request, HttpServletResponse response){
		return JSONUtil.list2json(classService.listAllClasses());
	}

	private boolean isClassIDExists(String classID) {
		if (classService.queryClassByID(classID) != null) {
			return true;
		}
		return false;
	}
}
