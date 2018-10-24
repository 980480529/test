package server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.api.message.saaj.SaajStaxWriter;

@WebServlet("/LoginIn")
public class LoginIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static Map<String, String[]> map=new HashMap<>();
       public LoginIn() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     request.setCharacterEncoding("utf-8");
	         response.setContentType("text/html;charset=utf-8");
		     map=request.getParameterMap();
		     response.setHeader("Content-type","text/html;charset=utf-8");
		     response.setCharacterEncoding("utf-8");
              HttpSession session = request.getSession();
                    String  id= session.getId();
                    System.out.println(id);
		    int falg= save();
		   
		     if(falg==0) {	
		    	response.getWriter().append("账户不存在!");
		    }else if(falg==1) {
		    	response.getWriter().append("密码错误!");
		    } else {
		    	response.getWriter().append("登录成功!");
		   
		    }		    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		           doGet(request, response);
	}
	
	public  int save() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","briup","briup");
			     PreparedStatement pro = conn.prepareStatement("select * from login where id=? ");
			      pro.setString(1, map.get("id")[0]);
			      System.out.println(map.get("id")[0]);
			      System.out.println(map.get("password")[0]);
			      ResultSet set = pro.executeQuery();
			      while(set.next()) {
			      if(set.getString("password").equals(map.get("password")[0])) {
		        	          return 2;
		             }else {
		            	 return 1;
		             }
		           }
			      pro.close();
			      conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
	}
		return 0;
}
}
