package schoolsystem.mm.dao;

import java.util.List;

import schoolsystem.mm.entity.Teacher;

public interface TeacherDAO {
	
	public List<Teacher> getTeachers(); 
	
	public Teacher getTeacher(int id); 
	
	public void saveTeacher(Teacher teacher); 
	
	public void persistTeacher(Teacher teacher); 
	
	public void updateTeacher(Teacher teacher); 
	
	public void deleteTeacher(int id);

}
