package official.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import official.dao.Dao;
import official.entity.Job;

public class AddJob extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddJob() {
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

		doPost(request, response);
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
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		String deptName = new String(request.getParameter("deptName").getBytes("ISO-8859-1"),"UTF-8");
		String jobName = new String (request.getParameter("jobName").getBytes("ISO-8859-1"),"UTF-8");
		String jobText =new String(request.getParameter("jobText").getBytes("ISO-8859-1"),"UTF-8");
		
		Job jo = new Job(deptName, jobName, jobText);
		Dao d = new Dao();
		int x = d.addJob(jo);
		if(x==0){
			 response.sendRedirect("http://localhost:8080/office/addjob.jsp?x=0");	
		}else{
			//no
			 response.sendRedirect("http://localhost:8080/office/addjob.jsp?x=-1");
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
