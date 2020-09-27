package com.ram.samstrack.dao.auth;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.samstrack.model.User;

@Repository
public class Auth_DaoImpl implements Auth_Dao {

	@Autowired
	private SessionFactory sf;

	@Override
	public User login(User u) {
		User user = null;
		try {
			Session session = sf.getCurrentSession();
			String hql = "FROM User u WHERE u.username=:un AND u.password=:pass";
			Query query = session.createQuery(hql);
			query.setString("un", u.getUsername());
			query.setString("pass", u.getPassword());

			user = (User) query.uniqueResult();
			if (user != null) {

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

		Session session = sf.getCurrentSession();
		User user = session.get(User.class, new Integer((int) httpSession.getAttribute("userid")));

		user.setActive(0);
		session.update(user);
	}

	@Override
	public int forgot_Password(User user) {
		int result = 0;
		try {

			Session session=sf.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq("username", user.getUsername()));
			User u = (User) criteria.uniqueResult();

			if (u == null) {
				result = 0;
			} else if(!u.getQuestion().equals(user.getQuestion()) || !u.getAnswer().equals(user.getAnswer())){
				result=1;
			}
			else if(u.getActive()==1){
				result=2;
			}
			else if(!user.getPassword().equals("")) {
				u.setPassword(user.getPassword());
				session.saveOrUpdate(u);
				result=3;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
