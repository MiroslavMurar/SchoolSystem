package schoolsystem.mm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import schoolsystem.mm.entity.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDAO {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Teacher> getTeachers() {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		List<Teacher> teachers = session.createQuery("from Teacher").list(); 
		
		return teachers;
	}

	@Override
	public Teacher getTeacher(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		Teacher teacher = session.get(Teacher.class, id); 
		
		return teacher;
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		session.saveOrUpdate(teacher);
		
	}
	
	public void persistTeacher(Teacher teacher) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		session.persist(teacher);
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		session.saveOrUpdate(teacher);
		
	}

	@Override
	public void deleteTeacher(int id) {
		
		
	}

}
