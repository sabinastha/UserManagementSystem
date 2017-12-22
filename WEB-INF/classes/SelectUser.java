
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

public class SelectUser extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		List dataList = new ArrayList();

		String uid = req.getParameter("id");

		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");

			String query = "select * from user where id=?";

			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,uid);

			ResultSet rs = st.executeQuery();

			while(rs.next())
			{

				dataList.add(rs.getInt("id"));
				dataList.add(rs.getString("username"));
				dataList.add(rs.getString("fullname"));
				dataList.add(rs.getString("password"));

			}

			rs.close();
			st.close();

		}

		catch(Exception e)
		{
			out.println(e.getMessage());
		}

		req.setAttribute("data",dataList);
		RequestDispatcher rd = req.getRequestDispatcher("useredit.jsp");

		rd.forward(req,res);

	}
}