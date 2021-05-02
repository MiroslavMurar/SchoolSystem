package schoolsystem.mm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import schoolsystem.mm.entity.Teacher;
import schoolsystem.mm.entity.TeacherDetail;

@Repository
public class TeacherDetailDaoImpl implements TeacherDetailDAO {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<TeacherDetail> getTeacherDetails() {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		List<TeacherDetail> teachers = session.createQuery("from TeacherDetail").list(); 
		
		return teachers;
	}

	@Override
	public TeacherDetail getTeacherDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTeacherDetail(TeacherDetail teacherDetail) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		session.saveOrUpdate(teacherDetail);
		
	}
	
	

	@Override
	public void updateTeacherDetail(TeacherDetail teacherDetail) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		session.saveOrUpdate(teacherDetail);
		
	}

	@Override
	public void deleteTeacherDetail(int id) {
		
		
	}

	@Override
	public TeacherDetail getTeacherDetailFromTeacher(int teacherId) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		Teacher teacher = session.get(Teacher.class, teacherId); 
		
		int teacherDetailId = teacher.getTeacherDetailId().getId(); 
		
		TeacherDetail teacherDetail = session.get(TeacherDetail.class, teacherDetailId); 
		
		return teacherDetail;
	}

}
