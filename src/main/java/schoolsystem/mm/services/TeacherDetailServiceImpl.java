package schoolsystem.mm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolsystem.mm.dao.TeacherDetailDAO;
import schoolsystem.mm.entity.TeacherDetail;

@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {

	@Autowired 
	TeacherDetailDAO teacherDetailDAO; 
	
	@Override
	@Transactional
	public List<TeacherDetail> getTeacherDetails() {
		
		return teacherDetailDAO.getTeacherDetails();
	}

	@Override
	@Transactional
	public TeacherDetail getTeacherDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveTeacherDetail(TeacherDetail teacherDetail) {
		
		teacherDetailDAO.saveTeacherDetail(teacherDetail);

	}

	@Override
	@Transactional
	public void updateTeacherDetail(TeacherDetail teacherDetail) {
		
		teacherDetailDAO.saveTeacherDetail(teacherDetail);

	}

	@Override
	@Transactional
	public void deleteTeacherDetail(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public TeacherDetail getTeacherDetailFromTeacher(int id) {
		
		return teacherDetailDAO.getTeacherDetailFromTeacher(id);
	}

}
