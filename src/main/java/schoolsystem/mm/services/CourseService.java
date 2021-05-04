package schoolsystem.mm.services;

import java.util.List;

import schoolsystem.mm.entity.Course;


public interface CourseService {

	public List<Course> getCourses(); 
	
	public List<Course> getCoursesForTeacher(int teacherId);
	
	public Course getCourse(int id); 
	
	public void saveCourse(Course course); 
	
	public void deleteCourse(int id);  
	
}
