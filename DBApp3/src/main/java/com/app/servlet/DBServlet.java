package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	Connection con;
	PreparedStatement ps;
	ServletContext cg ;
	@Override
	public void init() throws ServletException {
		// get access to ServletConfig obj
		cg= getServletContext();
		// read param value from web.xml
		String s1 = cg.getInitParameter("driver");;;;
		String s2 = cg.getInitParameter("dburl");
		String s3 = cg.getInitParameter("dbuser");
		String s4 = cg.getInitParameter("dbpwd");
		// crete jdbc con
		try{
			Class.forName(s1);
			con = DriverManager.getConnection(s2, s3, s4);
			// create ps obj
			ps = con.prepareStatement("select  empno,ename ,job, sal from emp where empno=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			// read form data from form page
			int no = Integer.parseInt(req.getParameter("teno"));
			// get printwriter
			PrintWriter pw = res.getWriter();
			// set Content type
			res.setContentType("text/html");
			// write jdbc code
			ps.setInt(1, no);
			// execute the query
			ResultSet rs = ps.executeQuery();
			// process the resultset obj
			if (rs.next()) {
				pw.println("<br><b><i>Emp NO is::</i></b>" + rs.getInt(1));

				pw.println("<br><b><i>Emp Name is::</i></b>" + rs.getString(2));
				pw.println("<br><b><i>Emp Job is::</i></b>" + rs.getString(3));

				pw.println("<br><b><i>Emp Salary is::</i></b>" + rs.getFloat(4));
            pw.println("Servler info"+cg.getServerInfo());
            cg.log("System Date And Time"+new Date());
			} else
				pw.println("<br><b><i>Employee Not Found</i></b>");
			// close result set obj
			rs.close();
			// close stream
			pw.println("<br><a href='index.jsp'>Home</a>");
			pw.close();
		} // try
		catch (Exception e) {
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
