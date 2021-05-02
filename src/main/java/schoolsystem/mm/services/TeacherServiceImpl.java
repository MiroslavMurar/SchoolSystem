package schoolsystem.mm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolsystem.mm.dao.TeacherDAO;
import schoolsystem.mm.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired 
	TeacherDAO teacherDAO; 
	
	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		
		return teacherDAO.getTeachers();
	}

	@Override
	@Transactional
	public Teacher getTeacher(int id) {
		
		return teacherDAO.getTeacher(id);
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher teacher) {
		
		teacherDAO.saveTeacher(teacher);

	}
	
	@Transactional
	public void persistTeacher(Teacher teacher) {
		
		teacherDAO.persistTeacher(teacher);

	}

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		
		teacherDAO.saveTeacher(teacher);

	}

	@Override
	@Transactional
	public void deleteTeacher(int id) {
		
		teacherDAO.deleteTeacher(id);
	}

}
