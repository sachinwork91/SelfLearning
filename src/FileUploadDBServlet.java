import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.UserDetails;
 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
     
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3307/test";
    private String dbUser = "root";
    private String dbPass = "";
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String firstName = request.getParameter("firstName");
        String password=request.getParameter("password");
        System.out.println("CDONTACT NUMBER => "+request.getParameter("contactnum"));
        System.out.println("ADDRESS => "+request.getParameter("addr"));
        System.out.println("EMAIL => "+request.getParameter("email"));
        //Gets the UserDetails Entered at the GUI
        UserDetails ud=new UserDetails();
        ud.setAddress(request.getParameter("addr"));
        ud.setCon_umber(Integer.parseInt(request.getParameter("contactnum")));
        ud.setEmail_id(request.getParameter("email"));
        ud.setExp(request.getParameter("experience"));
        ud.setComp_name(request.getParameter("company"));
        ud.setSkills(request.getParameter("skills"));
        request.setAttribute("Userobj",ud);
        
        
        String addr=ud.getAddress() ;
        int contactnum=ud.getCon_umber() ;
        String email=ud.getEmail_id() ;
        String experience=ud.getExp() ;
        String company=ud.getComp_name() ;
        String skills=ud.getSkills() ;
    
        
        request.setAttribute("userdetails", ud);
        request.setAttribute("username", request.getParameter("firstName"));
        request.setAttribute("addr", addr);
        request.setAttribute("contactnum", contactnum);
        request.setAttribute("email", email);
        request.setAttribute("company", company);
        request.setAttribute("experience", experience);
        request.setAttribute("skills", skills);
          
     // String lastName = request.getParameter("lastName");
         
        InputStream inputStream = null; // input stream of the upload file
       
        
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "INSERT INTO emp (name, photo, password) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(3, password); 
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
             System.out.println("prepared st 1");
            	statement.setBlob(2, inputStream);
            	System.out.println("prepared st 2");
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
            
           String insert_personal_info="insert into personal_info(p_id, addr,contact_num,email,user_id) values (?,?,?,?,?)";
           
           statement=conn.prepareStatement(insert_personal_info);
           addr=ud.getAddress() ;
          
           statement.setInt(1,0);
           statement.setInt(5,0);
           statement.setInt(3,contactnum );
           statement.setString(2, addr);       
           statement.setString(4, email); 
           statement.execute();
        //   String insert_corp_info= "insert into corp_info(c_id,company_name,experience,skills,user_id) values(?,?,?,?,?)"; 
            
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
            
            System.out.println("IN FILEUPLOADDBSERVLET => " + request.getParameter("firstName"));
            
            // forwards to the message page
            getServletContext().getRequestDispatcher("/WelcomePage.jsp").forward(request, response);
      //      			response.sendRedirect("WelcomePage.jsp");
            					return;
			 
        }
    }
}