import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.http.HttpSession;

public class LoginHandler extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		PrintWriter out = res.getWriter();
		RequestDispatcher rq = req.getRequestDispatcher("userview");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");
			Statement st = con.createStatement();

			String query = "select * from user where username='"+username+"' and password='"+password+"' ";

			ResultSet rs = st.executeQuery(query);

			if(rs.next())
			{
				
				HttpSession session = req.getSession();
				

				rq.forward(req,res);	
			}

			else
			{
				out.println("<center>"+"<h1>"+"Username and Password Incorrect <br /> Try Again"+"</h1>"+"</center>");
				res.sendRedirect("index.jsp");
			}

		}

		catch(Exception e)
		{
			out.println(e.getMessage());

		}


	}
}