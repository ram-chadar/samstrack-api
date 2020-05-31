package com.ram.samstrack.dao.auth;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.samstrack.model.User;

@Repository
public class Auth_DaoImpl implements Auth_Dao {

	@Autowired
	private SessionFactory sf;

	@Override
	public User login(User u) {
		User user=null;
		try {
			Session session = sf.getCurrentSession();
			String hql = "FROM User u WHERE u.username=:un AND u.password=:pass";
			Query query = session.createQuery(hql);
			query.setString("un", u.getUsername());
			query.setString("pass", u.getPassword());
			
			user=(User) query.uniqueResult();
			if(user!=null)
			{
				
				user.setActive(1);
				session.update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void logout(HttpSession httpSession) {

		Session session=sf.getCurrentSession();
			User user=session.get(User.class, new Integer((int) httpSession.getAttribute("userid")));
		
		user.setActive(0);
		session.update(user);
	}

}
