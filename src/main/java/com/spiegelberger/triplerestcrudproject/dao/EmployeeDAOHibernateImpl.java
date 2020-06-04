package com.spiegelberger.triplerestcrudproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spiegelberger.triplerestcrudproject.entity.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee>query =
				session.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Employee theEmployee = session.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
	Session session = entityManager.unwrap(Session.class);
	session.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery(
				"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}
	
	

}
