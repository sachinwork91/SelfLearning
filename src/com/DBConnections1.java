package com;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Blob;

//import org.omg.CORBA.portable.InputStream;


import com.mysql.jdbc.*;

public class DBConnections1 {
 
    private Connection con=null ;
    private   Statement stmt=null;
    private ResultSet rs;
//	statement st1=null;

     DBConnections1()
		{
    	   //step1 load the driver class  
    	 try {
    		 System.out.println("HERE 1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("HERE 2");
			//step2 create  the connection object  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3307/test","root","");  
			
			System.out.println("HERE 3 NP");
			//step3 create the statement object  
			 stmt=con.createStatement();  
			  

			
			//step4 execute query  
	//		 ResultSet rs=stmt.executeQuery("select * from emp");
			
    	 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( SQLException e)
		{
			e.printStackTrace();
		}
    	 
		};
		
		public boolean validate(Integer id)
		{
			
			
			return true;
		}
		
		public boolean isadmin(Integer userid)
		{
			
			boolean res=true;
			System.out.println("DB CONNECTED ISADMIN USER ID => "+userid);
			PreparedStatement ps;
			String query="select * from emp ";
		      try {
		    	  System.out.println("ISADMIN 111");
				ps=con.prepareStatement(query);
				System.out.println("ISADMIN 222");
				//ps.setInt(1, userid);
				rs=ps.executeQuery(query);
				while(rs.next())
				{
					System.out.println("this is resultset"+rs.getInt(1));
					if(rs.getInt(1)==1)
					{
						res=true;
					}
					else{
							res= false;
					}		
				}
				System.out.println("rs.next ran success");
				//	return res;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ISADMIN 3333");
			}	
		      System.out.println("RESULT => "+res);
				
			return res;
		};
		
		public String getLoginName(int pi_user_id)
		{
			System.out.println("IN GETLOGINNAME	=>" +pi_user_id);
			String query="select name from emp where user_id=?";
			String name="";
			try
			{PreparedStatement ps;
			ps=con.prepareStatement(query);
			ps.setInt(1, pi_user_id);
			
			rs=ps.executeQuery();
	    
			while(rs.next())
			{
			  name=rs.getString(1);  	
			}
			
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			System.out.println("NAME OF THE SESSION" + name);
			return name;
		};
		
		public void test_db()
		{
			String str="select * from emp";
			try {
				rs=stmt.executeQuery(str);
				while(rs.next())
				{
					System.out.println("HELLO RS PRINTING");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
     
		
/*	public  Blob getPicture()
	{
		//Blob bfile= new Blob();
		String sql = "SELECT photo FROM person WHERE contact_id=1";
		try { 
		PreparedStatement statement;
		statement = con.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		if (result.next()) {
            Blob blob = result.getBlob("photo");
            InputStream inputStream = blob.getBinaryStream();
            
            
            //OutputStream outputStream = new FileOutputStream(filePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
         //   System.out.println("File saved");
        }
        con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return blob;
		
	//	return bfile;
		
	}
*/		
     public static void main(String args[])
	{
		System.out.println("HELLO");
		 
		
		
		
	}
	
}
