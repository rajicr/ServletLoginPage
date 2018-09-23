import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HttpAdmin extends HttpServlet{
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		System.out.println("inside admin init method");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		out.println("<h2>Welcome buddies</h2>");
		out.println("</body></html>");
	}
	public void destroy(){
		System.out.println("inside destroy");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		doGet(req,res);
	}
}

