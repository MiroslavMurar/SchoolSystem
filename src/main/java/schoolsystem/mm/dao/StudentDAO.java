package schoolsystem.mm.dao;

import java.util.List;

import schoolsystem.mm.entity.Course;
import schoolsystem.mm.entity.Student;

public interface StudentDAO {
	
	public List<Student> getStudents(); 
	
//	public List<Course> getCourses(int studentId); 
	
	public Student getStudent(int id); 
	
	public void saveStudent(Student student); 
	
	public void deleteStudent(int id); 
	
}
