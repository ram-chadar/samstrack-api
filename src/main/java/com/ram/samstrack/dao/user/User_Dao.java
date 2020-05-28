package com.ram.samstrack.dao.user;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.User;

public interface User_Dao {
	public  Serializable addUser(User user);
	public List<User> getAllUser();
	public User getUser(int id);
	public void updateUser(User user);
	public void deleteUser(int user_id);
}
