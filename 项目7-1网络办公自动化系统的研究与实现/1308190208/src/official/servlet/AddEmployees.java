package official.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload; 

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import official.dao.Dao;
import official.entity.Employees;

public class AddEmployees extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddEmployees() {
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

		String employeeName =request.getParameter("employeeName");
		String sex =request.getParameter("sex");
		String birthday =request.getParameter("birthday");
		String address =request.getParameter("address");
		String nOcode =request.getParameter("NOcode");
		String learn =request.getParameter("learn");
		String mobile =request.getParameter("mobile");
		String email =request.getParameter("email");
		String jobName =request.getParameter("jobName");
		String deptName =request.getParameter("deptName");
		String workState =request.getParameter("workState");
		String photo =request.getParameter("doc");
		//String photo="";
		String agreement =request.getParameter("agreement");
		String pwd =request.getParameter("pwd");
		String userLevell ="1";
		//System.out.print(userLevell);
		int userLevel = Integer.parseInt(userLevell);
	    /*SmartUpload smart = new SmartUpload();
		smart.initialize(super.getServletConfig(), request, response);
		try {
			smart.upload();
			int count=smart.getFiles().getCount();
			System.out.print(count);
			File img = smart.getFiles().getFile(0);
			String fileName = null;
			if (img != null && img.getSize() > 0) {
				fileName = UUID.randomUUID().toString() + "." + img.getFileExt();

				img.saveAs("/upload/" + fileName);
				photo="../upload/"+fileName;
			}

		} catch (SmartUploadException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}*/
	/*	request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        //Ϊ�������ṩ������Ϣ  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //�����������ʵ��  
        ServletFileUpload sfu = new ServletFileUpload(factory);  
        //��ʼ����  
        sfu.setFileSizeMax(1024*400);  
        //ÿ�����������ݻ��װ��һ����Ӧ��FileItem������  
        try {  
            List<FileItem> items = sfu.parseRequest(request);  
            //���ֱ���  
            for (int i = 0; i < items.size(); i++) {  
                FileItem item = items.get(i);  
                //isFormFieldΪtrue����ʾ�ⲻ���ļ��ϴ�����  
                if(!item.isFormField()){  
                    ServletContext sctx = getServletContext();  
                    //��ô���ļ�������·��  
                    //upload�µ�ĳ���ļ���   �õ���ǰ���ߵ��û�  �ҵ���Ӧ���ļ���  
                      System.out.println(sctx);
                    String path = sctx.getRealPath("/upload");  
                    System.out.println(path);  
                    //����ļ���  
                    String fileName = item.getName();  
                    System.out.println(fileName);  
                    //�÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ���  
                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
                 
                       photo=fileName; 
                        //���ϴ�ͼƬ�����ּ�¼�����ݿ���  
                       
                     
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  */
         
	
		Employees em =new Employees(employeeName, sex, birthday, address, nOcode, learn, mobile, email, jobName, deptName, workState, photo, agreement, pwd, userLevel, "out");
		Dao d = new Dao();
		int x = d.addEmployees(em);
		if(x==-2){
			//-2�Ѵ���
		 response.sendRedirect("http://localhost:8080/office/person.jsp?x=-1");
		}else if(x==0){
			//0���ɹ�
			response.sendRedirect("http://localhost:8080/office/person.jsp?x=0");
		}else{
			//ʧ��
			response.sendRedirect("http://localhost:8080/office/person.jsp?x=1");
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
