package schoolsystem.mm.services;

import java.util.List;

import schoolsystem.mm.entity.Course;
import schoolsystem.mm.entity.Student;

public interface StudentService {

	public List<Student> getStudents();
	
	public Student getStudent(int id); 
	
	public void saveStudent(Student student); 
	
	public void deleteStudent(int id); 
}
