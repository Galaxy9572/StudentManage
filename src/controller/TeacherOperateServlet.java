package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.TeacherManageServiceImpl;
import util.JSONUtil;

@WebServlet("/TeacherOperateServlet")
public class TeacherOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherManageServiceImpl teacherService = new TeacherManageServiceImpl();

	public TeacherOperateServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 设置响应的编码格式为UTF-8
		String cmd = request.getParameter("cmd");
		if ("findTByTeacherID".equals(cmd)) {// 如果命令是按照编号查找老师
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(findTeacherByTeacherID(request, response));
		} else if ("findTByTeacherName".equals(cmd)) {// 如果命令是按照姓名查找老师
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(findTeacherByTeacherName(request, response));
		}
	}

	/**
	 * 按照姓名查找老师
	 * 
	 * @param request
	 * @param response
	 * @return 返回JSON格式的结果
	 */
	private String findTeacherByTeacherName(HttpServletRequest request, HttpServletResponse response) {
		String teacherName = request.getParameter("teacherName");
		return JSONUtil.list2json(teacherService.queryTeacherByName(teacherName));
	}

	/**
	 * 按照编号查找老师
	 * 
	 * @param request
	 * @param response
	 * @return 返回JSON格式的结果
	 */
	private String findTeacherByTeacherID(HttpServletRequest request, HttpServletResponse response) {
		String teacherID = request.getParameter("teacherID");
		return JSONUtil.object2json(teacherService.queryTeacherByTeacherID(teacherID));
	}

}
