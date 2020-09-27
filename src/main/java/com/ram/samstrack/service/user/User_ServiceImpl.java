package com.ram.samstrack.service.user;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.samstrack.dao.user.User_Dao;
import com.ram.samstrack.model.Branch;
import com.ram.samstrack.model.User;

@Service
@Transactional
public class User_ServiceImpl implements User_Service {

	@Autowired
	private User_Dao user_Dao;
	
	@Override
	public Serializable addUser(User user) {
		return user_Dao.addUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return user_Dao.getAllUser();
	}

	@Override
	public List<User> getBranchUser(HttpSession httpSession) {
		return user_Dao.getBranchUser(httpSession);
	}
	
	@Override
	public User getUser(int id) {
		return user_Dao.getUser(id);
	}

	@Override
	public void updateUser(User user) {
		user_Dao.updateUser(user);
	}

	@Override
	public void deleteUser(int user_id) {
		user_Dao.deleteUser(user_id);
	}

	

}
