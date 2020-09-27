package com.ram.samstrack.service.auth;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.samstrack.dao.auth.Auth_Dao;
import com.ram.samstrack.model.User;

@Service
@Transactional
public class Auth_ServiceImpl implements Auth_Service{

	@Autowired
	private Auth_Dao auth_Dao;
	
	@Override
	public User login(User user) {
		return auth_Dao.login(user);
	}

	@Override
	public void logout(HttpSession httpSession) {
		auth_Dao.logout(httpSession);
		
	}

	@Override
	public int forgot_Password(User user) {
		return auth_Dao.forgot_Password(user);
	}

}
