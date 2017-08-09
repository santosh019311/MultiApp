package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.EmployeeDaoImpl;
import com.app.dao.IEmployeeDao;
import com.app.model.Employee;

public class EmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1.read inputs from ui using req.getparam
			String empName = request.getParameter("ename");
			String esal = request.getParameter("esal");
			String empMail = request.getParameter("email");
			// 2.convert if required
			double empSal = Double.parseDouble(esal);    

			// 3.create model class obj
			Employee e = new Employee();
			e.setEmpName(empName);
			e.setEmpSal(empSal);
			e.setEmpMail(empMail);

			// 4.create obj to poji-pojo
			IEmployeeDao dao = new EmployeeDaoImpl();

			// and call operation save
			int empId = dao.saveEmp(e);

			// 5.get return value and const
			// a simple msg to UI
			String message = "Saved Data with id:" + empId;

			// 6.adding msg to req. attribute, to send data to UI
			request.setAttribute("msg", message);

			// 7.dispatch to UI using req.getReqDispatcher
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
