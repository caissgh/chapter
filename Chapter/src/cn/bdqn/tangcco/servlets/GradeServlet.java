package cn.bdqn.tangcco.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.tangcco.entity.Grade;
import cn.bdqn.tangcco.service.impl.GradeServiceImpl;

public class GradeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GradeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("flag");
		if (action!=null&&action.equals("addStu")) {
			this.doStudentAdd(request, response);//学生添加
		}else if (action!=null&&action.equals("updateStu")) {
			this.doStudentUpdate(request, response);//修生修改
		}else if (action!=null&&action.equals("findAll")) {
			//查询全部信息
			this.doFindAll(request, response);
		}else if (action!=null&&action.equals("add")) {
			this.doAdd(request, response);//添加
		}else if (action!=null&&action.equals("search")) {
			this.doSearch(request, response);//添加
		}else if (action!=null&&action.equals("showUpdate")) {
			this.doShowUpdate(request, response);//查询修改信息
		}else if (action!=null&&action.equals("update")) {
			this.doUpdate(request, response);//修改信息
		}else if (action!=null&&action.equals("del")) {
			this.doDelete(request, response);//删除
		}
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		int result=gradeService.delGrade(Integer.parseInt(request.getParameter("gradeId")));
		if (result>0) {
			response.sendRedirect("GradeServlet?flag=findAll");
		}else{
			response.sendRedirect("GradeServlet?flag=findAll");
		}
	}
	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		Grade grade=new Grade();
		grade.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
		grade.setName(request.getParameter("gradeName"));
		int result=gradeService.updateGrade(grade);
		if (result>0) {
			response.sendRedirect("GradeServlet?flag=findAll");
		}else{
			response.sendRedirect("GradeServlet?flag=findAll");
		}
	}
	public void doShowUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		Grade grade=gradeService.getGrade(Integer.parseInt(request.getParameter("gradeId")));
		request.setAttribute("grade",grade);
		request.getRequestDispatcher("grade/updateGrade.jsp").forward(request, response);
	}
	public void doSearch(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		Grade grade=gradeService.getGrade(Integer.parseInt(request.getParameter("gradeId")));
		request.setAttribute("grade",grade);
		request.getRequestDispatcher("grade/detailGrade.jsp").forward(request, response);
	}
	public void doAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		Grade grade=new Grade();
		grade.setName(request.getParameter("gradeName"));
		int result=gradeService.addGrade(grade);
		if (result>0) {
			response.sendRedirect("GradeServlet?flag=findAll");
		}else{
			response.sendRedirect("grade/addGrade.jsp");
		}
	}
	public void doFindAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		List<Grade> grades=gradeService.findAll();
		request.setAttribute("grades", grades);
		request.getRequestDispatcher("grade/ListGrade.jsp").forward(request, response);
	}
	public void doStudentUpdate(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		List<Grade> grades=gradeService.findAll();
		request.setAttribute("grades", grades);
		request.setAttribute("stuNo", request.getParameter("stuNo"));//保存学号
		request.getRequestDispatcher("UserServlet?flag=upShow").forward(request, response);
	}
	public void doStudentAdd(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		GradeServiceImpl gradeService=new GradeServiceImpl();
		List<Grade> grades=gradeService.findAll();
		request.setAttribute("grades", grades);
		request.getRequestDispatcher("student/addStudent.jsp").forward(request, response);
	}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
