
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;

public class RegisterHandler extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		PrintWriter out = res.getWriter();

		RequestDispatcher rq = req.getRequestDispatcher("index.jsp");

		res.setContentType("text/html");

		String username = req.getParameter("username");
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");

		//out.println("Hello" + username);

		if(password.equals(repassword))
		{

			try{

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");
				Statement st = con.createStatement();

				String query = "insert into user(username,fullname,password) values('"+username+"','"+fullname+"','"+password+"')";

				st.executeUpdate(query);

				res.sendRedirect("index.jsp");
			}

			catch(Exception e)
			{
				out.println(e.getMessage());
				out.println("Can not insert record");
			}
		}

		else
		{
			out.println("<center>"+"<h1>"+"Passwords Incorrect"+"</h1>"+"</center>");
		}
	}
}