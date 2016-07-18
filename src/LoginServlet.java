

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		String  user_name=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		
		
		DBConnections db=new DBConnections();
		String valid_yn=db.valid_password(pwd, user_name);
		
		if(valid_yn.contains("FAIL"))
		{
			response.sendRedirect("FAIL.jsp/"+valid_yn);
			return;
			
		}
		
		
	    empBean emp=new empBean();
//	    emp.setUser_id()=user;
	//    emp.setUser_id(user_name);
	    emp.setName(user_name);
		System.out.println("user_name =>"+ user_name);
		HttpSession hs=request.getSession();
	//    String  login_name=db.getLoginName(user_name); 
		hs.setAttribute("WelcomeName", user_name);
		hs.setAttribute("user_name", user_name);
		request.setAttribute("DB_obj", db);
		/*if( user_name==0)
		{
			System.out.println("NOTHING");
			response.sendRedirect("Login.jsp");
			return;
		}*/
    	if(db.isadmin(user_name)==true) 
		{
		  System.out.println("Calling AdminLogin");
			response.sendRedirect("AdminLogin.jsp");
			return;
			
			
		}
		
		else 
		{
		//	 System.out.println("Calling UserLogin but ...."+db.isadmin(emp.getUser_id()));
		     System.out.println("Calling UserLogin");
			
		response.sendRedirect("userlogin.jsp");
			return;
			
		}
	
	}

}
