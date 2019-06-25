import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		session.setAttribute("name",null);	
		  session.invalidate();
		  out.print("You have Succefully logged out ");	
		  response.sendRedirect("/DLF");
	       
    }       
}