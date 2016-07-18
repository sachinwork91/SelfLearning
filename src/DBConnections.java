import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.*;

public class DBConnections {
 
    private Connection con=null ;
    private   Statement stmt=null;
    private ResultSet rs;
//	statement st1=null;

     DBConnections()
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
		
		public boolean isadmin(String  user_name)
		{
			
			
			
			
			System.out.println("IN isADMIN user_name => "+user_name);
			boolean res=true;
		//	System.out.println("DB CONNECTED ISADMIN USER ID => "+userid);
			PreparedStatement ps;
			//String query="select is_admin from emp where name = ?";
		      try {
		    	  
		    	//  System.out.println("query => "+ query );
			    	 
		        	System.out.println("ISADMIN Ready");
		    	
		    	ps=con.prepareStatement("select is_admin from emp where name = ?");
		    	ps.setString(1,user_name);
		   
		    	System.out.println("after query user_name=>"+user_name);
				//ps.setInt(1, userid);
				//rs=ps.executeQuery(query);
				rs=ps.executeQuery();
				if (rs.next())
				{	
				do
				{
					System.out.println("this is resultset"+rs.getInt(1));
					if(rs.getInt(1)==1)
					{
						res=true;
					}
				}while(rs.next());	
							
				}
				else {
					res=false;
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
		
		public String valid_password(String pi_password, String user_name)
		{
			System.out.println("inside valid_password");
			String query="select password from emp where name=?";
			String pwd="";
			PreparedStatement ps;
			String message="PASS";
			boolean res=true;
			try{
				ps=con.prepareStatement("select password from emp where name = ?");
		    	ps.setString(1,user_name);
		    	rs=ps.executeQuery();
				if (rs.next())
				{	
				   System.out.println("this is resultset =>"+rs.getString(1));
					pwd=rs.getString(1);
				System.out.println("Retriver pass 1 => "+pwd);
				System.out.println("PAssed pass => "+pi_password);
				if(pwd.equalsIgnoreCase(pi_password))
					{
						res=true;
					}
					else{ 
						System.out.println("Retriver pass 2 => "+pwd);
						res=false;
					   message="FAIL - WRONG PASSWORD";
					}
				}else
				{res=false;
				message="FAIL - NOT A REGISTERED USER";}
		    	;
				
			}catch(SQLException e)
			{
				System.out.println("Wrong Password");
			}
			System.out.println("message => "+message);
			return message;
			
		}
		
		/*public String getLoginName(string  pi_user_name)
		{
	//		System.out.println("IN GETLOGINNAME	=>" +pi_user_id);
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
		*/
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
     
     public static void main(String args[])
	{
		System.out.println("HELLO");
		 
		
		
		
	}
	
}
