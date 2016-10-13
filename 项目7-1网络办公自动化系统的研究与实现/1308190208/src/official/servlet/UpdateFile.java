package official.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import official.dao.Dao;
import official.entity.Filee;

public class UpdateFile extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateFile() {
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
		String idd = request.getParameter("fileID");
		int id = Integer.parseInt(idd);
		String fileTime = request.getParameter("fileTime");
		String fileText = request.getParameter("fileText");
		String fileFrom = request.getParameter("fileFrom");
		String fileTo = request.getParameter("fileTo");
		String fileName = request.getParameter("fileName");
		Filee fi = new Filee(id,fileTime, fileText, fileFrom, fileTo, fileName);
		Dao d = new Dao();
		int x = d.updateFile(fi);
		if(x==0){
			//ok
		}else{
			//no
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
