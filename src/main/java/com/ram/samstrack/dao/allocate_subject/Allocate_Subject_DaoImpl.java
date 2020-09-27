package com.ram.samstrack.dao.allocate_subject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.samstrack.model.Allocate_Practical_Subject;
import com.ram.samstrack.model.Allocate_Theory_Subject;
import com.ram.samstrack.model.Branch;

@Repository
public class Allocate_Subject_DaoImpl implements Allocate_Subject_Dao {
	@Autowired
	private SessionFactory sf;

	@Override
	public void allocate_Theory_Subject(Allocate_Theory_Subject allocate_Theory_Subject) {
		try {
			sf.getCurrentSession().saveOrUpdate(allocate_Theory_Subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void allocate_Practical_Subject(Allocate_Practical_Subject allocate_Practical_Subject) {
		try {
			sf.getCurrentSession().saveOrUpdate(allocate_Practical_Subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Allocate_Theory_Subject> get_Allocated_Theory_Subject(
			Allocate_Theory_Subject allocated_Theory_Subject) {
		List<Allocate_Theory_Subject> allocated_Theory_Sub = null;
		try {
			Session session = sf.getCurrentSession();
			String hql = "SELECT subject.subject_Id,subject.subject_Name FROM Allocate_Theory_Subject WHERE "
					+ "branch.branch_Id=:branch_id AND user.user_Id=:user_id AND sem=:sem AND division=:division";
			Query query = session.createQuery(hql);
			query.setInteger("branch_id", allocated_Theory_Subject.getBranch().getBranch_Id());
			query.setInteger("user_id", allocated_Theory_Subject.getUser().getUser_Id());
			query.setInteger("sem", allocated_Theory_Subject.getSem());
			query.setCharacter("division", allocated_Theory_Subject.getDivision());

			allocated_Theory_Sub = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allocated_Theory_Sub;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Allocate_Practical_Subject> get_Allocated_Prctical_Subject(
			Allocate_Practical_Subject allocated_Practical_Subject) {

		List<Allocate_Practical_Subject> allocated_Practical_Sub = null;

		try {
			Session session = sf.getCurrentSession();
			String hql = "SELECT subject.subject_Id,subject.subject_Name FROM Allocate_Practical_Subject WHERE "
					+ "branch.branch_Id=:branch_id AND user.user_Id=:user_id AND sem=:sem AND division=:division AND batch=:batch";
			Query query = session.createQuery(hql);
			query.setInteger("branch_id", allocated_Practical_Subject.getBranch().getBranch_Id());
			query.setInteger("user_id", allocated_Practical_Subject.getUser().getUser_Id());
			query.setInteger("sem", allocated_Practical_Subject.getSem());
			query.setCharacter("division", allocated_Practical_Subject.getDivision());
			query.setString("batch", allocated_Practical_Subject.getBatch());

			allocated_Practical_Sub = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allocated_Practical_Sub;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Allocate_Theory_Subject> list_Allocated_Theory_Subjects(
			Allocate_Theory_Subject allocated_Theory_Subject,HttpSession httpSession) {
		List<Allocate_Theory_Subject> allocated_Theory_Sub = null;
		
		try {
			Branch branch=(Branch) httpSession.getAttribute("branch");
			Session session = sf.getCurrentSession();
			String hql = "SELECT user.username,subject.subject_Name,division FROM Allocate_Theory_Subject WHERE "
					+ "branch.branch_Id=:branch_id  AND sem=:sem ";
			Query query = session.createQuery(hql);
			query.setInteger("branch_id", branch.getBranch_Id());
			query.setInteger("sem", allocated_Theory_Subject.getSem());
			
			allocated_Theory_Sub = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allocated_Theory_Sub;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Allocate_Practical_Subject> list_Allocated_Practical_Subjects(
			Allocate_Practical_Subject allocated_Practical_Subject,HttpSession httpSession) {
		
		List<Allocate_Practical_Subject> allocated_Practical_Sub = null;

		try {
			Branch branch=(Branch) httpSession.getAttribute("branch");

			Session session = sf.getCurrentSession();
			String hql = "SELECT user.username,subject.subject_Name,division,batch FROM Allocate_Practical_Subject WHERE "
					+ "branch.branch_Id=:branch_id AND sem=:sem";
			Query query = session.createQuery(hql);
			query.setInteger("branch_id", branch.getBranch_Id());
			query.setInteger("sem", allocated_Practical_Subject.getSem());
			
			allocated_Practical_Sub = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allocated_Practical_Sub;
	}

}
