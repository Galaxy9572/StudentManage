package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.StudentBean;
import service.StudentManageService;
import service.impl.StudentManageServiceImpl;
import util.JSONUtil;
/**
 * 操作学生的Servlet
 * @author 廖俊瑶
 *
 */
public class StudentOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentManageService studentService= new StudentManageServiceImpl();
	
    public StudentOperateServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置响应编码为UTF-8
		String cmd=request.getParameter("cmd");
		if("findStuByStuNum".equals(cmd)){//如果命令是按学号查找学生
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(findStuByStuNum(request, response));
		}else if("findStuByStuName".equals(cmd)){//如果命令是按姓名查找学生
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(findStuByStuName(request, response));
		}else if("delStuByStuNum".equals(cmd)){//如果命令是按学号删除学生
			response.getWriter().write(delStuByStuNum(request, response));
		}else if("updateStuInfo".equals(cmd)){//如果命令是更新学生信息
			StudentBean bean=updateStuInfo(request,response);
			request.getSession().setAttribute("user", bean);
			request.getRequestDispatcher("/jsp/stuInfo.jsp").forward(request, response);
		}else if("listSelectedClasses".equals(cmd)){//如果命令是列出已选课程
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().write(listSelectedClasses(request,response));
		}
	}

	/**
	 * 列出已选课程
	 * @param request
	 * @param response
	 * @return 返回已选择的课程字符串
	 */
	private String listSelectedClasses(HttpServletRequest request, HttpServletResponse response) {
		String stuNum=request.getParameter("stuNum");
		System.out.println(stuNum);
		return studentService.listAllSelectedClasses(stuNum);
	}

	/**
	 * 按学号删除学生
	 * @param request
	 * @param response
	 * @return 成功则返回1，否则返回0
	 */
	private int delStuByStuNum(HttpServletRequest request, HttpServletResponse response) {
		String stuNum=request.getParameter("stuNum");
		if(studentService.deleteStudentByNum(stuNum)){
			return 1;
		}
		return 0;
	}

	/**
	 * 按学号查找学生
	 * @param request
	 * @param response
	 * @return 返回JSON格式结果
	 */
	private String findStuByStuNum(HttpServletRequest request, HttpServletResponse response){
		String stuNum=request.getParameter("stuNum");
		return JSONUtil.object2json(studentService.queryStudentByNum(stuNum));
	}
	
	/**
	 * 按姓名查找学生
	 * @param request
	 * @param response
	 * @return 返回JSON格式结果
	 */
	private String findStuByStuName(HttpServletRequest request, HttpServletResponse response){
		String stuName=request.getParameter("stuName");
		return JSONUtil.list2json(studentService.queryStudentByName(stuName));
	}
	
	/**
	 * 更新学生信息
	 * @param request
	 * @param response
	 * @return 返回新的StudentBean
	 */
	private StudentBean updateStuInfo(HttpServletRequest request, HttpServletResponse response){
		StudentBean oldBean=(StudentBean) request.getSession().getAttribute("user");
		String stuNum=request.getParameter("stuNum");
		String stuName=request.getParameter("stuName");
		int age=Integer.valueOf(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		StudentBean newBean=new StudentBean(stuName,stuNum,gender,age,password);
		return studentService.updateStudentInfo(oldBean,newBean);
	}
}
