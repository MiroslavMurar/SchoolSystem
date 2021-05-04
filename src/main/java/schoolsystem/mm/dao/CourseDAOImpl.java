package schoolsystem.mm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import schoolsystem.mm.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Course> getCourses() {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		List<Course> courses = session.createQuery("from Course").list(); 
		
		return courses;
	}
	
	@Override
	public List<Course> getCoursesForTeacher(int teacherId) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		List<Course> courses = session.createQuery("from Course where id=" + teacherId).list(); 
		
		return courses;
	}

	@Override
	public Course getCourse(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		Course course = session.get(Course.class, id); 
		
		return course;
	}

	@Override
	public void saveCourse(Course course) {
	
		Session session = sessionFactory.getCurrentSession(); 
		
		session.saveOrUpdate(course);
	}

	@Override
	public void deleteCourse(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		Course course = session.get(Course.class, id); 
		
		session.delete(course);
	}
}
