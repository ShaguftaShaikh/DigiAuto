package com.digiauto.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.digiauto.service.UsersService;
import com.digiauto.services.impl.UsersServiceImpl;

import javafx.fxml.Initializable;

public class FXMLUserController implements Initializable{
	
	private UsersService userService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		userService = new UsersServiceImpl();
	}

}
