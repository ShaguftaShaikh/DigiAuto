package com.digiauto.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.digiauto.beans.User;
import com.digiauto.service.UserService;
import com.digiauto.utils.HibernetUtils;

public class UsersServiceImpl implements UserService {

	@Override
	public List<User> validateUser(String username,String password) {
		// TODO Auto-generated method stub
		Session session = HibernetUtils.getHibernateSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> userRoot = criteria.from(User.class);
		criteria.select(userRoot);

		criteria.where(builder.equal(userRoot.get("name"), username));
		criteria.where(builder.equal(userRoot.get("password"), password));
		List<User> userList = session.createQuery(criteria).getResultList();
		
		session.close();
		return userList;
	}

}
