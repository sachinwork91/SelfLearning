

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.*;
import java.util.*;

import com.DBConnections1;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	//	  int id =  Integer.parseInt(request.getParameter("imgid"));
		  String username =request.getParameter("imgid");
		  try{
			  System.out.println("USERNAME In IMAGE SERVLET => "+username);
			  Blob image=null;
			  byte[] imData=null;
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","");     
		    Statement st=con.createStatement();
		//    id=3;
		    String strQuery = "select photo from emp where name= ?" ;
		    PreparedStatement ps;
		    ps=con.prepareStatement("select photo from emp where name= ?");
		    ps.setString(1,username);
		    		
		    ResultSet rs =ps.executeQuery();
		    String imgLen="";
		    
		    while(rs.next()){
		    	image=rs.getBlob(1);
		    	imData = image.getBytes(1, (int) image.length());
		    	  response.setContentType("image/gif");
				  
		    	response.getOutputStream().write(imData);
			      
			      response.getOutputStream().flush();
			      response.getOutputStream().close();		
			      System.out.println("IMAGE>SERVLET 7");
			    
		     
		    
		      
		     
		    }
		  }
		  catch (Exception e){
		    e.printStackTrace();
		  }
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("INSIDE DO POST ");
	}

}
