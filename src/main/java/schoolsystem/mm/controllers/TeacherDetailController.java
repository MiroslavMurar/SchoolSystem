package schoolsystem.mm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import schoolsystem.mm.entity.Teacher;
import schoolsystem.mm.entity.TeacherDetail;
import schoolsystem.mm.services.TeacherDetailService;
import schoolsystem.mm.services.TeacherService;

@Controller	
@RequestMapping("/teacherDetails")
public class TeacherDetailController {

private List<TeacherDetail> theTeachers; 
	
	@Autowired
	private TeacherDetailService teacherDetailService; 

	@Autowired
	private TeacherService teacherService; 
	

	@GetMapping("/list")
	public String listTeacherDetails(Model theModel) {
		
		List<TeacherDetail> teacherDetails = teacherDetailService.getTeacherDetails(); 
		
		theModel.addAttribute("teacherDetails", teacherDetails); 
		
		return "teacherDetail/list-teacherDetails";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("teacherId") int teacherId, Model model) {
		
		Teacher teacher = teacherService.getTeacher(teacherId); 
		TeacherDetail teacherDetail = null; 
		if (teacher.getTeacherDetailId() == null) {
			teacherDetail = new TeacherDetail(); 
			teacher.setTeacherDetailId(teacherDetail); 
		} else {
			teacherDetail = teacher.getTeacherDetailId(); 
		}
		
		teacherService.saveTeacher(teacher); 
		
		model.addAttribute("teacherDetail", teacherDetail); 
		
		return "teacherDetail/teacherDetail-form"; 
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("teacherDetail") TeacherDetail teacherDetail) {
	
		teacherDetailService.saveTeacherDetail(teacherDetail); 

		return "redirect:/teacherDetails/list"; 
	}
}
	
