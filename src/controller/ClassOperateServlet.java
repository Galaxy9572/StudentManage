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
/**
 * 操作课程的Servlet
 * @author 廖俊瑶
 *
 */
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 设置响应的编码格式为UTF-8
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if ("addClass".equals(cmd)) {//如果命令是添加课程
			addClass(request, response);
		} else if ("listAll".equals(cmd)) {//如果命令是列出所有课程
			// 设置响应方式为JSON，编码为UTF-8
			response.setContentType("text/json; charset=utf-8");
			// 给前台Ajax响应
			response.getWriter().write(listAllClasses(request, response));
		}
	}

	/**
	 * 添加课程
	 * 
	 * @param request
	 * @param response
	 * @return 成功返回true，否则返回false
	 */
	private boolean addClass(HttpServletRequest request, HttpServletResponse response) {
		String classID = request.getParameter("classID");
		String className = request.getParameter("className");
		int classNum = Integer.valueOf(request.getParameter("classNum"));
		String teacherID = request.getParameter("teacherID");
		if (!isClassIDExists(classID)) {// classID不存在才允许创建课程
			ClassBean classBean = new ClassBean(classID, className, classNum, teacherID);
			return classService.createClass(classBean);
		}
		return false;
	}

	/**
	 * 将List转换成JSON格式
	 * 
	 * @param request
	 * @param response
	 * @return 返回转换结果
	 */
	private String listAllClasses(HttpServletRequest request, HttpServletResponse response) {
		return JSONUtil.list2json(classService.listAllClasses());
	}

	/**
	 * 判断classID是否存在
	 * 
	 * @param classID
	 * @return 存在则返回true，否则返回false
	 */
	private boolean isClassIDExists(String classID) {
		if (classService.queryClassByID(classID) != null) {
			return true;
		}
		return false;
	}
}
