
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class UserUpdate extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();	

		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");		

			String query = "update user set username=?, fullname=?, password=?" + " where id=?";
			PreparedStatement st = con.prepareStatement(query); 
		
			st.setString(1, username);
			st.setString(2, fullname);
			st.setString(3, password);
			st.setString(4,id);

			st.executeUpdate();

			con.close();
			st.close();

			RequestDispatcher rd = req.getRequestDispatcher("userview");
			rd.include(req,res);

		}

		catch(Exception e)
		{
			out.println("Exception Occured : " + e.getMessage());
		}

	}
}