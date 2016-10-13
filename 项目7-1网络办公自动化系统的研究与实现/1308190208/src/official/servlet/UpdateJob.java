package official.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import official.dao.Dao;
import official.entity.Job;

public class UpdateJob extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateJob() {
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

		String idd = request.getParameter("jobID");
		int id = Integer.parseInt(idd);
		String deptName = request.getParameter("deptName");
		String jobName = request.getParameter("jobName");
		String jobText = request.getParameter("jobText");
		Job jo = new Job(id,deptName, jobName, jobText);
		Dao d = new Dao();
		int x = d.updateJob(jo);
		if(x==0){
			 response.sendRedirect("http://localhost:8080/office/changejob.jsp?x=0");
		}else{
			//no
			 response.sendRedirect("http://localhost:8080/office/changejob.jsp?x=-1");
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
