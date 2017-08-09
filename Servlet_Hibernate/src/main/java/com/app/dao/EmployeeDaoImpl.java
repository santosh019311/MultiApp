package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	;

	@Override
	public int saveEmp(Employee emp) {
		Session ses = null;
		Transaction tx = null;
		int id = -1;
		try {
			ses = HibernateUtil.getSf().openSession();
			tx = ses.beginTransaction();

			id = (Integer) ses.save(emp);

			tx.commit();
		} catch (Exception e2) {
			tx.rollback();
			e2.printStackTrace();
		} finally {
			if (ses != null)
				ses.close();
		}
		return id;
	}
}
