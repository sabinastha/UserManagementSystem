
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class UserDelete extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();	
		String id = req.getParameter("id");

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");		

			String query = "delete from user where id=?";
			PreparedStatement st = con.prepareStatement(query);
		
			st.setString(1,id);

			st.executeUpdate();

			con.close();
			st.close();

			RequestDispatcher rd = req.getRequestDispatcher("userview");
			rd.forward(req,res);

		}

		catch(Exception e)
		{
			out.println("Exception Occured : " + e.getMessage());
		}

	}
}