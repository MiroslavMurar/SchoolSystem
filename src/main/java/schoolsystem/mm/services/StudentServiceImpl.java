package schoolsystem.mm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolsystem.mm.dao.StudentDAO;
import schoolsystem.mm.entity.Course;
import schoolsystem.mm.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO; 
	
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		
		studentDAO.saveStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		studentDAO.deleteStudent(id);
	}

//	@Override
//	@Transactional
//	public List<Course> getCourses(int studentId) {
//		
//		return studentDAO.getCourses(studentId);
//	}

}
