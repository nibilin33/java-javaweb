package official.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import official.dao.Dao;
import official.entity.Employees;

public class UpdateEmloyees extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateEmloyees() {
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

		
		SmartUpload smart = new SmartUpload();
		smart.initialize(super.getServletConfig(),request,response);
		SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time=new Date();
		String addtime=matter.format(time);
		try {
			smart.upload();
		} catch (SmartUploadException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		com.jspsmart.upload.Request request1=smart.getRequest();
		String employeeName =request1.getParameter("employeeName");
		String sex =request1.getParameter("sex");
		System.out.println(sex);
		System.out.println(sex.trim().getBytes());
		String idd = request1.getParameter("employeeID");
		int id = Integer.parseInt(idd);
		System.out.print(id);
		String birthday =request1.getParameter("birthday");
		String address =request1.getParameter("address");
		String nOcode =request1.getParameter("NOcode");
		String learn =request1.getParameter("learn");
		String mobile =request1.getParameter("mobile");
		String email =request1.getParameter("email");
		String jobName =request1.getParameter("jobName");
		String deptName =request1.getParameter("deptName");
		String workState =request1.getParameter("workState");
		String userLevell ="1";
		int userLevel = Integer.parseInt(userLevell);
		String photo="";
		String agreement =request1.getParameter("agreement");
		String pwd =request1.getParameter("pwd");
		String filename=null;
		String fileExt=null;
		String realpath="/UserFile/";
		try {
			
			
			int count=smart.getFiles().getCount();
			for(int i=0;i<count;i++){
				com.jspsmart.upload.File file=smart.getFiles().getFile(i);
				if(file.isMissing())continue;
				filename=smart.getFiles().getFile(i).getFileName();
				fileExt=smart.getFiles().getFile(i).getFileExt();
				photo=realpath+filename+"."+fileExt;
				smart.getFiles().getFile(i).saveAs(photo,0);
			}

		} catch (SmartUploadException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Employees em =new Employees(id,employeeName, sex, birthday, address, nOcode, learn, mobile, email, jobName, deptName, workState, photo, agreement, pwd, userLevel, "out");
		Dao d = new Dao();
		int x = d.updateEmloyees(em);
		if(x==0){
			//ok
			 response.sendRedirect("http://localhost:8080/office/person1.jsp?x=0");
		}else{
			//no
			 response.sendRedirect("http://localhost:8080/office/person1.jsp?x=-1");
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
