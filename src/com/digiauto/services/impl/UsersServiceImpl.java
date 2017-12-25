package com.digiauto.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.digiauto.beans.Users;
import com.digiauto.service.UsersService;

public class UsersServiceImpl implements UsersService{

	private EntityManager entityManager;
	
	public UsersServiceImpl() {
		// TODO Auto-generated constructor stub
		entityManager = Persistence.createEntityManagerFactory("CRMPU").createEntityManager();
	}
	
	@Override
	public Boolean validateUser(Users user) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		return null;
	}

}
