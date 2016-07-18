<%@ page import="java.sql.*,java.io.*,java.util.*, com.DBConnections" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	System.out.println("IMAGE>JSP 1");
  int id =  Integer.parseInt(request.getParameter("imgid"));
  try{     
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");     
    Statement st=con.createStatement();
    id=2;
    String strQuery = "select photo from contacts where contact_id="+id;
    ResultSet rs = st.executeQuery(strQuery);
    System.out.println("IMAGE>JSP 2");
    String imgLen="";
    System.out.println("IMAGE>JSP 3");
   while(rs.next()){
      imgLen = rs.getString("photo");
      System.out.println("IMAGE LENGTH =>" +imgLen);
       } 
    rs = st.executeQuery(strQuery);
    if(rs.next()){
    	System.out.println("IMAGE>JSP 4");
      int len = imgLen.length();
      System.out.println("IMAGE>JSP 4.1");
      byte [] rb = new byte[len];
      System.out.println("IMAGE>JSP 4.2");
      response.setContentType("image/png");
      System.out.println("IMAGE>JSP 5");
      InputStream readImg = rs.getBinaryStream(1);
      //InputStream readImg1 = rs.getBinaryStream(2);
      int index=readImg.read(rb, 0, len); 
      st.close();
      response.reset();
      System.out.println("IMAGE>JSP 6");
      response.getOutputStream().write(rb,0,len);
      response.getOutputStream().flush();
      response.getOutputStream().close();		
      System.out.println("IMAGE>JSP 7");
     
     
     
    }
  }
  catch (Exception e){
    e.printStackTrace();
  }
%>