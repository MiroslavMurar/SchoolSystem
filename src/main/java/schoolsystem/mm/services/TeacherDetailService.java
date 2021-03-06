package schoolsystem.mm.services;

import java.util.List;

import schoolsystem.mm.entity.TeacherDetail;

public interface TeacherDetailService {
	
	public List<TeacherDetail> getTeacherDetails(); 
	
	public TeacherDetail getTeacherDetail(int id); 
	
	public void saveTeacherDetail(TeacherDetail teacherDetail); 
	
	public void updateTeacherDetail(TeacherDetail teacherDetail); 
	
	public void deleteTeacherDetail(int id);
	
	public TeacherDetail getTeacherDetailFromTeacher(int id); 
}
