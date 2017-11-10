package cn.bdqn.tangcco.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.service.impl.StudentServiceImpl;
import cn.bdqn.tangcco.util.Page;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		//alt+/
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("flag");
		
		if (action!=null&&action.equals("login")) {
			this.doLogin(request, response);//登录
		}else if (action!=null&&action.equals("add")) {
			this.doAdd(request, response);//添加
		}else if (action!=null&&action.equals("search")) {
			this.doSearch(request, response);//添加
		}else if (action!=null&&action.equals("del")) {
			this.doDelete(request, response);//删除
		}else if (action!=null&&action.equals("upShow")) {
			this.doUpShow(request, response);//显示学员详细信息
		}else if (action!=null&&action.equals("update")) {
			this.doUpdate(request, response);//修改学员信息
		}else if (action!=null&&action.equals("fenye")) {
			this.doPage(request, response);
		}else if (action!=null&&action.equals("findStu")) {
			this.doFindStudent(request, response);
		}
	}
	public void doFindStudent(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		StudentServiceImpl studentService=new StudentServiceImpl();
		String name=request.getParameter("name");
		List<Student> students=studentService.searchByName(name);
		boolean used=false;
		if (students!=null&&students.size()>0) {
			used=true;
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(used);
		out.flush();
		out.close();
	}
	public void doPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		StudentServiceImpl studentService=new StudentServiceImpl();
		String currentIndex=request.getParameter("pageIndex");
		if (currentIndex==null) {
			currentIndex="1";
		}
		int pageIndex=Integer.parseInt(currentIndex);
		int pageSize=2;
		
		
		Page<Student> pages=studentService.getPage(pageIndex, pageSize);
		request.setAttribute("pages",pages);
		request.getRequestDispatcher("student/PageStudent.jsp").forward(request, response);
	}
	/**
	 * 学员修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    	StudentServiceImpl studentService=new StudentServiceImpl();
			Student student=new Student();
			
			student.setStudentNo(Integer.parseInt(request.getParameter("stunum")));
			student.setLoginPwd(request.getParameter("pwd"));
			student.setStudentName(request.getParameter("stuname"));
			student.setSex(request.getParameter("sex"));
			student.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
			student.setPhone(request.getParameter("phone"));
			student.setAddress(request.getParameter("address"));
			
			String dt=request.getParameter("bornDate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				student.setBornDate(sdf.parse(dt));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int result=studentService.updateStudent(student);
			if (result>0) {
				response.sendRedirect("student/listStudent.jsp");
			}else{
				response.sendRedirect("student/UpdateStudent.jsp");
			}
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		StudentServiceImpl studentService=new StudentServiceImpl();
		int result=studentService.delStudent(Integer.parseInt(request.getParameter("stuNo")));
		if (result>0) {
			response.sendRedirect("student/listStudent.jsp");
		}else{
			response.sendRedirect("student/listStudent.jsp");
		}
	}
	public void doUpShow(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		StudentServiceImpl studentService=new StudentServiceImpl();
		Student stu=studentService.searchByStuNo(Integer.parseInt(request.getParameter("stuNo")));
		request.setAttribute("student", stu);
		request.getRequestDispatcher("student/UpdateStudent.jsp").forward(request, response);
	}
	public void doSearch(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		StudentServiceImpl studentService=new StudentServiceImpl();
		Student stu=studentService.searchByStuNo(Integer.parseInt(request.getParameter("stuNo")));
		request.setAttribute("student", stu);
		request.getRequestDispatcher("student/detailStudent.jsp").forward(request, response);
	}
	/**
	 * 用户登录操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doLogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//alt+/
		StudentServiceImpl studentService=new StudentServiceImpl();
		String uname=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		Student student=studentService.login(uname, pwd);
		if (student!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("user",student);
			response.sendRedirect("main/main.html");
		}else{
			response.sendRedirect("UserLogin.jsp");
		}
	}
	/**
	 * 学员信息添加
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    	StudentServiceImpl studentService=new StudentServiceImpl();
			Student student=new Student();
			student.setStudentNo(Integer.parseInt(request.getParameter("stunum")));
			student.setLoginPwd(request.getParameter("pwd"));
			student.setStudentName(request.getParameter("stuname"));
			student.setSex(request.getParameter("sex"));
			student.setGradeId(Integer.parseInt(request.getParameter("gradeId")));
			student.setPhone(request.getParameter("phone"));
			student.setAddress(request.getParameter("address"));
			String dt=request.getParameter("bornDate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				student.setBornDate(sdf.parse(dt));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int result=studentService.addStudent(student);
			if (result>0) {
				response.sendRedirect("student/listStudent.jsp");
			}else{
				response.sendRedirect("student/addStudent.jsp");
			}
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
