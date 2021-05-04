package schoolsystem.mm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolsystem.mm.dao.CourseDAO;
import schoolsystem.mm.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;

	@Override
	@Transactional
	public List<Course> getCourses() {
		
		return courseDAO.getCourses();
	}
	
	@Override
	@Transactional
	public List<Course> getCoursesForTeacher(int teacherId) {
	
		return courseDAO.getCoursesForTeacher(teacherId);
	}

	@Override
	@Transactional
	public Course getCourse(int id) {
	
		return courseDAO.getCourse(id);
	}

	@Override
	@Transactional
	public void saveCourse(Course course) {
		
		courseDAO.saveCourse(course);
	}

	@Override
	@Transactional
	public void deleteCourse(int id) {
		
		courseDAO.deleteCourse(id);
	} 
}
