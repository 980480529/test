package server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static Map<String, String[]> map=new HashMap<>();
       public Register() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        HttpSession ss= request.getSession();
		     System.out.println(ss.getAttribute("password"));
		     System.out.println(ss.getId());
		     request.setCharacterEncoding("utf-8");
		     response.setContentType("text/html;charset=utf-8");
		     map=request.getParameterMap();
		     response.setHeader("Content-type","text/html;charset=utf-8");
		     response.setCharacterEncoding("utf-8"); 
		     int count= insert();
		    if(count!=0) {
		    	response.getWriter().append("×¢²á³É¹¦!");
		    }
		    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		           doGet(request, response);
	}
	
	public  int insert() {
		  int count=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","briup","briup");
			    PreparedStatement pro = conn.prepareStatement("insert  into login values(?,?,?)");
			     pro.setString(1, map.get("username")[0]);
			     pro.setString(2, map.get("id")[0]);
                 pro.setString(3, map.get("password")[0]);
                 count= pro.executeUpdate();
                 System.out.println(map.get("id")[0]);
                 pro.close();
                 conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
	}
		return count;
}
}
