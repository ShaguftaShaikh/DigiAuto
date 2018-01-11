package com.digiauto.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.digiauto.beans.Customer;
import com.digiauto.service.CustomerService;
import com.digiauto.utils.HibernetUtils;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session = HibernetUtils.getHibernateSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
		Root<Customer> userRoot = criteria.from(Customer.class);
		criteria.select(userRoot);

		List<Customer> customerList = session.createQuery(criteria).getResultList();

		session.close();
		System.out.println(customerList);
		return customerList;
	}

}
