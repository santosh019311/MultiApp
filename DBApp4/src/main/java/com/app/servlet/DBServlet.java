package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	Connection con;
	PreparedStatement ps;
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	ServletContext cg ;
	@Override
	public void init() throws ServletException {
		// get access to ServletContext obj
		cg= getServletContext();
		// read param value from web.xml
		String driver = cg.getInitParameter("driver");
		String url = cg.getInitParameter("dburl");
		String user = cg.getInitParameter("dbuser");
		String pwd = cg.getInitParameter("dbpwd");
		// crete jdbc con
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			// create ps obj
			ps = con.prepareStatement(GET_EMP_DETAILS_BY_NO);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ResultSet rs=null;
		RequestDispatcher rd=null,rd1=null,rd2=null;
		try {
			// include header content
			rd1=req.getRequestDispatcher("/headurl");
			rd1.include(req, res);
			// get printwriter
			PrintWriter pw = res.getWriter();
			// set Content type
			res.setContentType("text/html");
			pw.println("<b>Before raising Exception</b>");
			//read form data
			int no = Integer.parseInt(req.getParameter("teno"));
			ps.setInt(1, no);
			// execute the query
			 rs = ps.executeQuery();
			// process the resultset obj
			if (rs.next()) {
				pw.println("<br><b><i>Emp NO is::</i></b>" + rs.getInt(1));

				pw.println("<br><b><i>Emp Name is::</i></b>" + rs.getString(2));
				pw.println("<br><b><i>Emp Job is::</i></b>" + rs.getString(3));

				pw.println("<br><b><i>Emp Salary is::</i></b>" + rs.getFloat(4));
			} else{
				pw.println("<br><b><i>Employee Record Not Found</i></b>");
			}
			//add hyperlinks
			pw.println("<br><br><a href='input.html'>Home</a>");
				// get Access to ServletConfig obj
			//include footer content
			rd2=req.getRequestDispatcher("/footer.html");
			rd2.include(req, res);
			//close jdbc obj
			rs.close();
			// close stream
			pw.close();
		} // try
		catch (Exception e) {
			rd=req.getRequestDispatcher("/eurl");
			rd.forward(req, res);
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	@Override
	public void destroy() {
		// close jdbc obj
		try {
			if (ps != null)
				ps.close();
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
