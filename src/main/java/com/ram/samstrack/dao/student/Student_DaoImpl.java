package com.ram.samstrack.dao.student;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.samstrack.model.Batch;
import com.ram.samstrack.model.Student;

@Repository
public class Student_DaoImpl implements Student_Dao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Serializable add_Student(Student student) {

		Serializable id = null;
		try {
			id = sf.getCurrentSession().save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Student get_Student(int student_Id) {

		Student student = null;
		try {
			student = (Student) sf.getCurrentSession().createCriteria(Student.class)
					.add(Restrictions.eq("student_Id", student_Id)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> get_All_Student(int acc_Year, String year, int branch_Id, char division) {

		List<Student> studentList = null;
		try {

			Criteria crt = sf.getCurrentSession().createCriteria(Student.class);

			Criterion criterion = Restrictions.eq("acc_Year", acc_Year);
			Criterion criterion1 = Restrictions.eq("year", year);
			Criterion criterion2 = Restrictions.eq("branch.branch_Id", branch_Id);
			Criterion criterion3 = Restrictions.eq("division", division);

			crt.add(Restrictions.and(criterion, criterion1, criterion2, criterion3));

			studentList = crt.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> get_Students_For_Practical(int acc_Year, String year, int branch_Id, char division,
			String batch) {
		List<Student> studentList = null;
		try {

			Criteria crt = sf.getCurrentSession().createCriteria(Student.class);

			Criterion criterion = Restrictions.eq("acc_Year", acc_Year);
			Criterion criterion1 = Restrictions.eq("year", year);
			Criterion criterion2 = Restrictions.eq("branch.branch_Id", branch_Id);
			Criterion criterion3 = Restrictions.eq("division", division);
			Criterion criterion4 = Restrictions.eq("batch", batch);

			crt.add(Restrictions.and(criterion, criterion1, criterion2, criterion3, criterion4));

			studentList = crt.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int generate_Batch(Batch batch) {
		int index = 0;
		try {
			Session session = sf.getCurrentSession();
			String hql = "FROM Student s WHERE s.acc_Year=:accYear  AND s.branch.branch_Id=:branch_id AND s.year=:year AND s.division=:div AND s.roll_No BETWEEN :roll_from AND :roll_to ";
			Query query = session.createQuery(hql);
			
			query.setInteger("accYear", batch.getAcc_Year());
			query.setInteger("branch_id", batch.getBranch().getBranch_Id());
			query.setString("year", batch.getYear());
			query.setCharacter("div", batch.getDivision());
			query.setInteger("roll_from", batch.getRollNo_From());
			query.setInteger("roll_to", batch.getRollNo_To());
			
			List<Student> students = query.list();

			for (Student student : students) {
				student.setBatch(batch.getBatch());
				session.update(student);
				index++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return index;
	}

	@Override
	public void update_Student(Student student) {
		sf.getCurrentSession()
		.update(student);
		
	}

}
