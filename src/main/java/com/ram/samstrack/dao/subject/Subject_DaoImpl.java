package com.ram.samstrack.dao.subject;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.samstrack.model.Allocate_Theory_Subject;
import com.ram.samstrack.model.Subject;

@Repository
public class Subject_DaoImpl implements Subject_Dao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Serializable add_Subject(Subject subject) {
		Serializable id = null;
		try {
			id = sf.getCurrentSession().save(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> get_Branch_Subject(int branch_Id) {
		List<Subject> subjecList = null;
		try {
			subjecList = sf.getCurrentSession().createCriteria(Subject.class)
					.add(Restrictions.eq("branch.branch_Id", branch_Id)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return subjecList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> get_Branch_Sem_Subject(int branch_Id, int sem) {
		List<Subject> subjectList = null;
		try {

			Criteria criteria = sf.getCurrentSession().createCriteria(Subject.class);
			Criterion criterion1 = Restrictions.eq("branch.branch_Id", branch_Id);
			Criterion criterion2 = Restrictions.eq("sem", sem);
			criteria.add(Restrictions.and(criterion1, criterion2));

			/*
			 * String
			 * hql="FROM Subject s WHERE s.branch.branch_Id=:branchId AND s.sem=:sem"; Query
			 * qry=sf.getCurrentSession().createQuery(hql); qry.setInteger("branchId",
			 * branch_Id); qry.setInteger("sem", sem);
			 */

			subjectList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subjectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> get_Theory_Practical_Subject(int branch_Id, int sem, String subject_Type) {
		List<Subject> subjectList = null;

		try {
			Criteria criteria = sf.getCurrentSession().createCriteria(Subject.class);
			Criterion criterion1 = Restrictions.eq("branch.branch_Id", branch_Id);
			Criterion criterion2 = Restrictions.eq("sem", sem);
			Criterion criterion3 = Restrictions.eq("subject_Type", subject_Type);
			criteria.add(Restrictions.and(criterion1, criterion2, criterion3));
			subjectList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}



}
