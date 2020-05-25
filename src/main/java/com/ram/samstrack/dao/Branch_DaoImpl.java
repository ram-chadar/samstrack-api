package com.ram.samstrack.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.samstrack.model.Branch;

@Repository
public class Branch_DaoImpl implements Branch_Dao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Serializable addBranch(Branch branch) {
		Serializable id=null;
		try {
		id = sf.getCurrentSession().save(branch);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

}
