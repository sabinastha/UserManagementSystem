
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

public class UserView extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		List dataList = new ArrayList(); 

		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");

			String query = "select * from user";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

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

		RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");

		rd.forward(req,res);

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		List dataList = new ArrayList(); 

		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user","root","root");

			String query = "select * from user";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

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

		RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");

		rd.forward(req,res);

	}
}