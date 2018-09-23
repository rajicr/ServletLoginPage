import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HttpLogin extends HttpServlet{
	PreparedStatement pst;
        public void init(ServletConfig config)throws ServletException{
                System.out.println("entered into init method");
		super.init(config);
		try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/UserInformation","raji","Raji@1993");
		System.out.println("inside connection");
                pst=con.prepareStatement("select * from user where NAME= ? and PASSWORD= ?;");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
        }
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		System.out.println("entered doGet");
		String s1=req.getParameter("name");
		String s2=req.getParameter("password");
		try{
			pst.setString(1,s1);
			pst.setString(2,s2);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				System.out.println("inside next");
				RequestDispatcher rd=req.getRequestDispatcher("admin");
				System.out.println("going to forward");
				rd.forward(req,res);
			}
			else{
				res.setContentType("text/html");
				PrintWriter out=res.getWriter();
				out.println("<h2>Please enter the correct NAME and PASSWORD</h2>");
				RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
				rd.include(req,res);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void destroy(){
		System.out.println("inside destroy method");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		System.out.println("entered doPost");
		doGet(req,res);
	}
}
		

