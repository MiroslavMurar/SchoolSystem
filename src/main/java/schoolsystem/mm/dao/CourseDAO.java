package schoolsystem.mm.dao;

import java.util.List;

import schoolsystem.mm.entity.Course;

public interface CourseDAO {

	public List<Course> getCourses(); 
	
	public List<Course> getCoursesForTeacher(int teacherId); 
	
	public Course getCourse(int id); 
	
	public void saveCourse(Course course); 
	
	public void deleteCourse(int id); 
}
