package schoolsystem.mm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import schoolsystem.mm.entity.Course;
import schoolsystem.mm.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired 
	SessionFactory sessionFactory; 
	
	@Override
	public List<Student> getStudents() {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		List<Student> students = session.createQuery("from Student ").list(); 
		
		return students;
	}

	@Override
	public Student getStudent(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		return session.get(Student.class, id);
	}

	@Override
	public void saveStudent(Student student) {
		
		Session session = sessionFactory.getCurrentSession(); 

		session.saveOrUpdate(student); 
	}

	@Override
	public void deleteStudent(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		Student student = session.get(Student.class, id); 
		
		session.delete(student);
		
	}

//	@Override
//	public List<Course> getCourses(int studentId) {
//		
//		Session session = sessionFactory.getCurrentSession(); 
//		
//		Student student = session.get(Student.class, studentId); 
//		
//		List<Course> courses = student.getCourses(); 
//		
//		return courses; 
//	
//	}
}
