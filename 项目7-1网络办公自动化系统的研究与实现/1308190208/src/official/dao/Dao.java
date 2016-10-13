package official.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.jspsmart.upload.Request;

import official.entity.Active;
import official.entity.Dept;
import official.entity.Employees;
import official.entity.Filee;
import official.entity.Job;
import official.entity.Notice;
import official.entity.Task;

public class Dao {
	private static Connection conn = null;
	private  void getconnection(){
		try {
			///D:/developements/javaDevelopments/workspace-htz/office/build/classes/official/dao/
			String ds=Dao.class.getResource("").toString();
			int idx=ds.indexOf('/');
			ds=ds.substring(idx+1,ds.length()-1);
			idx=ds.lastIndexOf('/');
			ds=ds.substring(0,idx);
			idx=ds.lastIndexOf('/');
			ds=ds.substring(0,idx);
			idx=ds.lastIndexOf('/');
			
			idx=ds.lastIndexOf('/');
			ds=ds.substring(0,idx+1);
			ds=ds+"officialweb.db";
			System.out.print(ds);
            String thisPath ="D:/developements/javaDevelopments/workspace-htz/office/WebContent/META-INF/officialweb.db";  
            String sql = "jdbc:sqlite:"+ds;

			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void closeconn(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getTotalPage(String name){
		getconnection();
		int count=0;
		String sql = "select count(*) from " + name;
		System.out.print(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
				if(count%8!=0)
					count=count/8+1;
				else
					count=count/8;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return count;
	}
	//0ok,-1no
	public int addActiveAgreeNum(int id){
		getconnection();
		String sql = "update active set activeAgreeNum = activeAgreeNum + 1 where activeID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return -1;
	}
	public int addActiveNoAgreeNum(int id){
		getconnection();
		String sql = "update active set activeNoAgreeNum = activeNoAgreeNum + 1 where activeID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return -1;
	}
	public List<Active> queryActiveByPage(int page){
		List<Active> list = new ArrayList<Active>();
		int start = (page-1)*4;
		String sql = "select * from active limit "+start+",4";
		getconnection();
		try {
			PreparedStatement ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Active a  = new Active();
				a.setActiveID(rs.getInt(1));
				a.setActiveName(rs.getString(2));
				a.setActiveInfo(rs.getString(3));
				a.setActiveAgreeNum(rs.getInt(4));
				a.setEmployeeName(rs.getString(5));
				a.setActiveNoAgreeNum(rs.getInt(6));
				list.add(a);
			}
			closeconn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Active queryActiveByID(int id){
		Active a = new Active();
		String sql = "select * from active where activeID = '"+id+"'";
		getconnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				a.setActiveID(rs.getInt(1));
				a.setActiveName(rs.getString(2));
				a.setActiveInfo(rs.getString(3));
				a.setActiveAgreeNum(rs.getInt(4));
				a.setEmployeeName(rs.getString(5));
				a.setActiveNoAgreeNum(rs.getInt(6));
				closeconn();
				return a;
			}
				closeconn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return null;
	}
	//-1->no;0->ok
	public int addActive(Active a){
		getconnection();
		String sql = "insert into active(activeName,activeInfo,activeAgreeNum,employeeName,activeNoAgreeNum) values("
				+ "'"+a.getActiveName()+"','"+a.getActiveInfo()+"','"+0+"','"+a.getEmployeeName()+"'"
						+ ",'"+0+"')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	public int updateActive(Active a){
		getconnection();
		String sql = "update active set activeName='"+a.getActiveName()+"',"
				+ "activeInfo='"+a.getActiveInfo()+"',employeeName='"+a.getEmployeeName()+"'"
						+ "where activeID='"+a.getActiveID()+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int delActiveByID(int id){
		getconnection();
		String sql = "delete from active where activeID = '"+id+"'";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public List<Dept> queryDeptByPage(int page){
		List<Dept> list = new ArrayList<Dept>();
		int start = (page-1)*4;
		String sql = "select * from dept limit "+start+",4";
		getconnection();
		try {
			PreparedStatement ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Dept d  = new Dept();
				d.setDeptID(rs.getInt(1));
				d.setDeptName(rs.getString(2));
				d.setDeptText(rs.getString(3));
				list.add(d);
			}
			closeconn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Dept queryDeptByID(int id){
		Dept d = new Dept();
		String sql = "select * from dept where deptID='"+id+"'";
		getconnection();
		try {
			PreparedStatement ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				d.setDeptID(rs.getInt(1));
				d.setDeptName(rs.getString(2));
				d.setDeptText(rs.getString(3));
				closeconn();
				return d;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int isDeptExist(String name){
		getconnection();
		String sql = "select * from dept where deptName = '"+name+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				closeconn();
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return -1;
	}
	public int addDept(Dept d){
		if(isDeptExist(d.getDeptName())==0){
			return -2;
		}
		getconnection();
		String sql = "insert into dept (deptName,deptText) values ('"+d.getDeptName()+"','"+d.getDeptText()+"')";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			int x = ps.executeUpdate();
		
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}
		closeconn();
		return -1;
	}
	public int delDeptByID(int id){
		getconnection();
		String sql = "delete from dept where deptID='"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int updateDept(Dept d){
		getconnection();
		String sql = "update dept set deptName='"+d.getDeptName()+"',"
				+ "deptText='"+d.getDeptText()+"' where deptID = '"+d.getDeptID()+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	//�˳�ʱҪ����
	public void changeOnlineOut(int id){
		getconnection();
		String state = "out";
		String sql = "update employees set onLine = '"+state+"' where employeeID = '"+id+"'";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.executeUpdate();
			closeconn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����ʱ״̬�ı䣬���ص���
	public void changeOnlineOn(int id){
		getconnection();
		String state = "on";
		String sql = "update employees set onLine = '"+state+"' where employeeID = '"+id+"'";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			//ps.executeUpdate();
			closeconn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//-1�û�������-2�������0�ɹ�
	public Employees Login(String code,String psw){
		getconnection();
		String sql = "select * from employees where NOcode = '"+code+"'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Employees em = new Employees();
				em.setEmployeeID(rs.getInt(1));
				em.setEmployeeName(rs.getString(2));
				em.setSex(rs.getString(3));
				em.setBirthday(rs.getString(4));
				em.setAddress(rs.getString(5));
				em.setNOcode(rs.getString(6));
				em.setLearn(rs.getString(7));
				em.setMobile(rs.getString(8));
				em.setEmail(rs.getString(9));
				em.setJobName(rs.getString(10));
				em.setDeptName(rs.getString(11));
				em.setWorkState(rs.getString(12));
				em.setPhoto(rs.getString(13));
				em.setAddress(rs.getString(14));
				em.setPwd(rs.getString(15));
				em.setUserLevel(rs.getInt(16));
				em.setOnLine(rs.getString(17));
				if(psw.equals(em.getPwd())){
					changeOnlineOn(em.getEmployeeID());
					closeconn();
					return em;
				}else
					return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Employees> queryEmployeeByName(String Name ,String dep){
		List<Employees> list =new ArrayList<Employees>();
		
		String sql = "select * from employees where employeeName = '"+Name+"' and deptName='"+dep+"'" ;
		getconnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employees em = new Employees();
				em.setEmployeeID(rs.getInt(1));
				em.setEmployeeName(rs.getString(2));
				em.setSex(rs.getString(3));
				em.setBirthday(rs.getString(4));
				em.setAddress(rs.getString(5));
				em.setNOcode(rs.getString(6));
				em.setLearn(rs.getString(7));
				em.setMobile(rs.getString(8));
				em.setEmail(rs.getString(9));
				em.setJobName(rs.getString(10));
				em.setDeptName(rs.getString(11));
				em.setWorkState(rs.getString(12));
				em.setPhoto(rs.getString(13));
				em.setAddress(rs.getString(14));
				em.setPwd(rs.getString(15));
				em.setUserLevel(rs.getInt(16));
				em.setOnLine(rs.getString(17));
				list.add(em);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public List<Employees> queryEmployeeByName(String Name){
		List<Employees> list =new ArrayList<Employees>();
		String sql = "select * from employees where employeeName = '"+Name+"'" ;
		getconnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employees em = new Employees();
				em.setEmployeeID(rs.getInt(1));
				em.setEmployeeName(rs.getString(2));
				em.setSex(rs.getString(3));
				em.setBirthday(rs.getString(4));
				em.setAddress(rs.getString(5));
				em.setNOcode(rs.getString(6));
				em.setLearn(rs.getString(7));
				em.setMobile(rs.getString(8));
				em.setEmail(rs.getString(9));
				em.setJobName(rs.getString(10));
				em.setDeptName(rs.getString(11));
				em.setWorkState(rs.getString(12));
				em.setPhoto(rs.getString(13));
				em.setAddress(rs.getString(14));
				em.setPwd(rs.getString(15));
				em.setUserLevel(rs.getInt(16));
				em.setOnLine(rs.getString(17));
				list.add(em);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public List<Employees> queryEmployeesByPage(int page){
		List<Employees> list =new ArrayList<Employees>();
		int start = (page-1)*5;
		String sql = "select * from employees limit "+start+",5";
		getconnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employees em = new Employees();
				em.setEmployeeID(rs.getInt(1));
				em.setEmployeeName(rs.getString(2));
				em.setSex(rs.getString(3));
				em.setBirthday(rs.getString(4));
				em.setAddress(rs.getString(5));
				em.setNOcode(rs.getString(6));
				em.setLearn(rs.getString(7));
				em.setMobile(rs.getString(8));
				em.setEmail(rs.getString(9));
				em.setJobName(rs.getString(10));
				em.setDeptName(rs.getString(11));
				em.setWorkState(rs.getString(12));
				em.setPhoto(rs.getString(13));
				em.setAddress(rs.getString(14));
				em.setPwd(rs.getString(15));
				em.setUserLevel(rs.getInt(16));
				em.setOnLine(rs.getString(17));
				list.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public List<Employees> queryEmployeesByDept(String dep){
		List<Employees> list =new ArrayList<Employees>();
	
		String sql = "select * from employees where deptName='"+dep+"'";
		getconnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employees em = new Employees();
				em.setEmployeeID(rs.getInt(1));
				em.setEmployeeName(rs.getString(2));
				em.setSex(rs.getString(3));
				em.setBirthday(rs.getString(4));
				em.setAddress(rs.getString(5));
				em.setNOcode(rs.getString(6));
				em.setLearn(rs.getString(7));
				em.setMobile(rs.getString(8));
				em.setEmail(rs.getString(9));
				em.setJobName(rs.getString(10));
				em.setDeptName(rs.getString(11));
				em.setWorkState(rs.getString(12));
				em.setPhoto(rs.getString(13));
				em.setAddress(rs.getString(14));
				em.setPwd(rs.getString(15));
				em.setUserLevel(rs.getInt(16));
				em.setOnLine(rs.getString(17));
				list.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public Employees queryEmployeesByID(int dep){
	
	
		String sql = "select * from employees where employeeID='"+dep+"'";
		getconnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Employees em = new Employees();
				em.setEmployeeID(rs.getInt(1));
				em.setEmployeeName(rs.getString(2));
				em.setSex(rs.getString(3));
				em.setBirthday(rs.getString(4));
				em.setAddress(rs.getString(5));
				em.setNOcode(rs.getString(6));
				em.setLearn(rs.getString(7));
				em.setMobile(rs.getString(8));
				em.setEmail(rs.getString(9));
				em.setJobName(rs.getString(10));
				em.setDeptName(rs.getString(11));
				em.setWorkState(rs.getString(12));
				em.setPhoto(rs.getString(13));
				em.setAddress(rs.getString(14));
				em.setPwd(rs.getString(15));
				em.setUserLevel(rs.getInt(16));
				em.setOnLine(rs.getString(17));
				return em;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return null;
	}
	public int isNoCodeExist(String code){
		getconnection();
		String sql = "select * from employees where NOcode = '"+code+"'";
		System.out.print(sql);
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				closeconn();
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return -1;
	}
	//-2�Ѵ��ڣ�-1��ʧ�ܣ�0���ɹ�
	public int addEmployees(Employees em){
		
		if(isNoCodeExist(em.getNOcode())==0){
			return -2;
		}
		getconnection();
		String sql = "insert into employees (employeeName,sex,birthday,address,NOcode"
				+ ",learn,mobile,email,jobName,deptName,workState,photo,agreement,pwd,userLevel)"
				+ "values('"+em.getEmployeeName()+"','"+em.getSex()+"','"+em.getBirthday()+"'"
						+ ",'"+em.getAddress()+"','"+em.getNOcode()+"','"+em.getLearn()+"'"
								+ ",'"+em.getMobile()+"','"+em.getEmail()+"','"+em.getJobName()+"'"
										+ ",'"+em.getDeptName()+"','"+em.getWorkState()+"'"
												+ ",'"+em.getPhoto()+"','"+em.getAgreement()+"'"
														+ ",'"+em.getPwd()+"','"+em.getUserLevel()+"')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public void delEmployeesByID(int id){
		getconnection();
		String sql = "delete from employees where employeeID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			closeconn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���޸ģ�-1ʧ�ܣ�0�ɹ�
	public int updateEmloyees(Employees em){
		getconnection();
		String sql = "update employees set employeeName='"+em.getEmployeeName()+"',sex='"+em.getSex()+"'"
				+ ",birthday='"+em.getBirthday()+"',address='"+em.getAddress()+"',NOcode='"+em.getNOcode()+"'"
						+ ",learn='"+em.getLearn()+"',mobile='"+em.getMobile()+"',email='"+em.getEmail()+"'"
								+ ",jobName='"+em.getJobName()+"',deptName='"+em.getDeptName()+"',workState"
										+ "='"+em.getWorkState()+"',photo='"+em.getPhoto()+"',agreement='"+em.getAgreement()+"'"
												+ ",pwd='"+em.getPwd()+"',userLevel='"+em.getUserLevel()+"' where employeeID"
														+ "='"+em.getEmployeeID()+"'";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	//-1no,0->ok
	public int changePsw(String id ,String p){
		getconnection();
		String sql = "update employees set pwd = '"+p+"' where NOcode = '"+id+"'";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int addFile(Filee fi){
		getconnection();
		String sql = "insert into file (fileTime,fileText,fileFrom,fileTo,fileName)"
				+ "values('"+fi.getFileTime()+"','"+fi.getFileText()+"','"+fi.getFileFrom()+"'"
						+ ",'"+fi.getFileTo()+"','"+fi.getFileName()+"')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int delFileById(int id){
		getconnection();
		String sql = "delete from file where fileID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return -1;
	}
	public int updateFile(Filee fi){
		getconnection();
		String sql = "update file set fileTime = '"+fi.getFileTime()+"',fileText='"+fi.getFileText()+"'"
				+ ",fileFrom='"+fi.getFileFrom()+"',fileTo='"+fi.getFileTo()+"',fileName='"+fi.getFileName()+"'"
						+ "where fileID = '"+fi.getFileID()+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public List<Filee> queryFileByPage(int page){
		List<Filee> list = new ArrayList<Filee>();
		getconnection();
		int start = (page-1)*3;
		String sql = "select * from file limit "+start+",3";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Filee fi = new Filee();
				fi.setFileID(rs.getInt(1));
				fi.setFileTime(rs.getString(2));
				fi.setFileText(rs.getString(3));
				fi.setFileFrom(rs.getString(4));
				fi.setFileTo(rs.getString(5));
				fi.setFileName(rs.getString(6));
				list.add(fi);
			}
			closeconn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Filee> queryFileByName(String name){
		List<Filee> list = new ArrayList<Filee>();
		getconnection();
		String sql = "select * from file where fileTo = '"+name+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Filee fi = new Filee();
				fi.setFileID(rs.getInt(1));
				fi.setFileTime(rs.getString(2));
				fi.setFileText(rs.getString(3));
				fi.setFileFrom(rs.getString(4));
				fi.setFileTo(rs.getString(5));
				fi.setFileName(rs.getString(6));
			    list.add(fi);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public Filee queryFileByID(String name){
		
		getconnection();
		int id=Integer.parseInt(name);
		String sql = "select * from file where fileID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Filee fi = new Filee();
				fi.setFileID(rs.getInt(1));
				fi.setFileTime(rs.getString(2));
				fi.setFileText(rs.getString(3));
				fi.setFileFrom(rs.getString(4));
				fi.setFileTo(rs.getString(5));
				fi.setFileName(rs.getString(6));
				return fi;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return null;
	}
	public int addJob(Job jo){
		getconnection();
		String sql = "insert into job (deptName,jobName,jobText) values ("
				+ "'"+jo.getDeptName()+"','"+jo.getJobName()+"','"+jo.getJobText()+"')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int  delJobByID(int id){
		getconnection();
		String sql = "delete from job where jobID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int updateJob(Job jo){
		getconnection();
		String sql = "update job set deptName='"+jo.getDeptName()+"',jobName='"+jo.getJobName()+"'"
				+ ",jobText='"+jo.getJobText()+"' where jobID = '"+jo.getJobID()+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public List<Job> queryJobByPage(int page){
		List<Job> list = new ArrayList<Job>();
		getconnection();
		int start = (page-1)*8;
		String sql = "select * from job limit "+start+",8";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Job jo = new Job();
				jo.setJobID(rs.getInt(1));
				jo.setDeptName(rs.getString(2));
				jo.setJobName(rs.getString(3));
				jo.setJobText(rs.getString(4));
				list.add(jo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public Job queryJobByID(int id){
		getconnection();
		String sql = "select * from job where jobID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Job jo = new Job();
				jo.setJobID(rs.getInt(1));
				jo.setDeptName(rs.getString(2));
				jo.setJobName(rs.getString(3));
				jo.setJobText(rs.getString(4));
				closeconn();
				return jo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return null;
	}
	public List<Job> queryJobByID(String job){
		List<Job> list = new ArrayList<Job>();
		getconnection();
		String sql = "select * from job where jobName = '"+job+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Job jo = new Job();
				jo.setJobID(rs.getInt(1));
				jo.setDeptName(rs.getString(2));
				jo.setJobName(rs.getString(3));
				jo.setJobText(rs.getString(4));
		        list.add(jo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public int addNotice(Notice no){
		getconnection();
		String sql = "insert into notice (employeeName,noteName,noteInfo,noteTime) values("
				+ "'"+no.getEmployeeName()+"','"+no.getNoteName()+"','"+no.getNoteInfo()+"'"
						+ ",'"+no.getNoteTime()+"')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int delNoticeByID(int id){
		getconnection();
		String  sql = "delete from notice where noteID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int updateNotice(Notice no){
		getconnection();
		String sql = "update notice set employeeName='"+no.getEmployeeName()+"',"
				+ "noteName='"+no.getNoteName()+"',noteInfo='"+no.getNoteInfo()+"'"
						+ ",noteTime='"+no.getNoteTime()+"' where noteID ='"+no.getNoteID()+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int getTotakPageByCondition(String dep,String emName,String date,int page){
		getconnection();
		String sql ;
		int countt = 0;
		if(emName!=null&&emName.equals("")==false)
			sql = "select count(*) from notice where employeeName = '"+emName+"'";
		else
			sql = "select count(*) from notice";
		if(date!=null&&date.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql + " where noteTime = '"+date+"'";
			else
				sql = sql + " and noteTime = '"+date+"'";
		}
		if(dep!=null&&dep.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql+ " where employeeName in (select  employeeName from employees "
						+ " where deptName = '"+dep+"')";
			else
				sql = sql + " and employeeName in (select  employeeName from employees "
						+ " where deptName = '"+dep+"')";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				countt = rs.getInt(1);
			}
			if(countt%8==0)
				countt = countt/8;
			else
				countt = countt/8+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return countt;
	}
	public int getTotaWorkPageByCondition(String dep,String emName){
		getconnection();
		String sql ;
		int countt = 0;
		if(emName!=null&&emName.equals("")==false)
			sql = "select count(*) from employees where employeeName = '"+emName+"'";
		else
			sql = "select count(*) from employees";
		
		if(dep!=null&&dep.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql+" where deptName = '"+dep+"'";
			else
				sql = sql + " and deptName = '"+dep+"'";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				countt = rs.getInt(1);
			}
			if(countt%5==0)
				countt = countt/5;
			else
				countt = countt/5+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return countt;
	}
	public List<Notice> queryNoticeByCondition(String dep,String emName,String date,int page){
		List<Notice> list = new ArrayList<Notice>();
		getconnection();
		String sql ;
		int start = (page-1)*5;
		if(emName!=null&&emName.equals("")==false)
			sql = "select * from notice where employeeName = '"+emName+"'";
		else
			sql = "select * from notice";
		if(date!=null&&date.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql + " where noteTime = '"+date+"'";
			else
				sql = sql + " and noteTime = '"+date+"'";
		}
		if(dep!=null&&dep.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql+ " where employeeName in (select  employeeName from employees "
						+ " where deptName = '"+dep+"')";
			else
				sql = sql + " and employeeName in (select  employeeName from employees "
						+ " where deptName = '"+dep+"')";
		}
		sql = sql +" limit "+start+",5";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Notice no =new Notice();
				no.setNoteID(rs.getInt(1));
				no.setEmployeeName(rs.getString(2));
				no.setNoteName(rs.getString(3));
				no.setNoteInfo(rs.getString(4));
				no.setNoteTime(rs.getString(5));
				list.add(no);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public List<Notice> queryNoticeByCondition(String dep,String emName,String date){
		List<Notice> list = new ArrayList<Notice>();
		getconnection();
		String sql ;
		if(emName!=null&&emName.equals("")==false)
			sql = "select * from notice where employeeName = '"+emName+"'";
		else
			sql = "select * from notice";
		if(date!=null&&date.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql + " where noteTime = '"+date+"'";
			else
				sql = sql + " and noteTime = '"+date+"'";
		}
		if(dep!=null&&dep.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql+ " where employeeName in (select  employeeName from employees "
						+ " where deptName = '"+dep+"')";
			else
				sql = sql + " and employeeName in (select  employeeName from employees "
						+ " where deptName = '"+dep+"')";
		}
	
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Notice no =new Notice();
				no.setNoteID(rs.getInt(1));
				no.setEmployeeName(rs.getString(2));
				no.setNoteName(rs.getString(3));
				no.setNoteInfo(rs.getString(4));
				no.setNoteTime(rs.getString(5));
				list.add(no);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public List<Employees> queryEmployByCondition(String dep,String emName,int page){
		List<Employees> list = new ArrayList<Employees>();
		getconnection();
		String sql ;
		int start = (page-1)*5;	
	
		if(emName!=null&&emName.equals("")==false)
			sql = "select * from employees where employeeName = '"+emName+"'";
		else
			sql = "select * from employees";
		
		if(dep!=null&&dep.equals("")==false){
			if(sql.indexOf("where")==-1)
				sql = sql+" where deptName = '"+dep+"'";
			else
				sql = sql + " and deptName = '"+dep+"'";
		}
		sql = sql +" limit "+start+",5";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employees em =new Employees();
				em.setEmployeeID(rs.getInt(1));
				em.setEmployeeName(rs.getString(2));
				em.setSex(rs.getString(3));
				em.setBirthday(rs.getString(4));
				em.setAddress(rs.getString(5));
				em.setNOcode(rs.getString(6));
				em.setLearn(rs.getString(7));
				em.setMobile(rs.getString(8));
				em.setEmail(rs.getString(9));
				em.setJobName(rs.getString(10));
				em.setDeptName(rs.getString(11));
				em.setWorkState(rs.getString(12));
				em.setPhoto(rs.getString(13));
				em.setAddress(rs.getString(14));
				em.setPwd(rs.getString(15));
				em.setUserLevel(rs.getInt(16));
				em.setOnLine(rs.getString(17));
				list.add(em);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public Notice queryNoticeByID(int id){
		getconnection();
		String sql = "select * from notice where noteID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Notice no =new Notice();
				no.setNoteID(rs.getInt(1));
				no.setEmployeeName(rs.getString(2));
				no.setNoteName(rs.getString(3));
				no.setNoteInfo(rs.getString(4));
				no.setNoteTime(rs.getString(5));
				closeconn();
				return no;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return null;
	}
	public int addTask(Task ta){
		getconnection();
		String sql = "insert into task (taskName,taskInfo,getTime,taskState,employeeName)"
				+ "values('"+ta.getTaskName()+"','"+ta.getTaskInfo()+"','"+ta.getGetTime()+"'"
						+ ",'"+ta.getTaskSate()+"','"+ta.getEmployeeName()+"')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int delTaskByID(int id){
		getconnection();
		String sql = "delete from task where taskID = '"+id+"'";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			int x= ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int updateTask(Task ta){
		getconnection();
		String sql = "update task set taskName = '"+ta.getTaskName()+"',taskInfo='"+ta.getTaskInfo()+"'"
				+ ",getTime='"+ta.getGetTime()+"',taskState='"+ta.getTaskSate()+"',employeeName='"+ta.getEmployeeName()+"'"
						+ "where taskID='"+ta.getTaskID()+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate();
			closeconn();
			if(x==1)
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public List<Task> queryTaskByEmployeeName(String name,int page){
		List<Task> list = new ArrayList<Task>();
		getconnection();
		int start = (page-1)*4;
		String sql = "select * from task where employeeName= '"+name+"' limit "+start+",4";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Task ta = new Task();
				ta.setTaskID(rs.getInt(1));
				ta.setTaskName(rs.getString(2));
				ta.setTaskInfo(rs.getString(3));
				ta.setGetTime(rs.getString(4));
				ta.setTaskSate(rs.getString(5));
				ta.setEmployeeName(rs.getString(6));
				list.add(ta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return list;
	}
	public Task queryTaskByID(int id){
		getconnection();
		String sql = "select * from task where taskID = '"+id+"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Task ta = new Task();
				ta.setTaskID(rs.getInt(1));
				ta.setTaskName(rs.getString(2));
				ta.setTaskInfo(rs.getString(3));
				ta.setGetTime(rs.getString(4));
				ta.setTaskSate(rs.getString(5));
				ta.setEmployeeName(rs.getString(6));
				closeconn();
				return ta;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeconn();
		return null;
	}

}
