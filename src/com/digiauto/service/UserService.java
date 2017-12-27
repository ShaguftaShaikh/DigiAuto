package com.digiauto.service;

import java.util.List;

import com.digiauto.beans.User;

public interface UserService {

	public List<User> validateUser(String username,String password);
}
