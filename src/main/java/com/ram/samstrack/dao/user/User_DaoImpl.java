package com.ram.samstrack.dao.user;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.samstrack.model.User;

@Repository
public class User_DaoImpl implements User_Dao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Serializable addUser(User user) {
		Serializable id = null;
		try {
			id = sf.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		List<User> userList = null;
		try {
			userList = sf.getCurrentSession().createCriteria(User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUser(int id) {
		User user = null;
		try {
			user = sf.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(User user) {

		try {
			sf.getCurrentSession()
			.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int user_id) {
		Session session=sf.getCurrentSession();
		User user=session.load(User.class, user_id);
		session.delete(user);
		
	}

}
