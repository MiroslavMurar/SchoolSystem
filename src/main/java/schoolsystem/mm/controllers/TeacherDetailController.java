package schoolsystem.mm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		return "list-teacherDetails";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@ModelAttribute("teacher") Teacher teacher, Model model) {
		
		TeacherDetail teacherDetail = new TeacherDetail(); 
//		teacher.setTeacherDetailId(teacherDetail); 	
//		teacherService.persistTeacher(teacher);
		
		if (teacher != null) {
			System.out.println("Teacher Exist");
		}
		
		model.addAttribute("teacherDetail", teacherDetail); 
		model.addAttribute("teacher", teacher); 
		
		return "teacherDetail-form"; 
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("teacherDetail") TeacherDetail teacherDetail,
						@ModelAttribute("teacher") Teacher teacher) {
		
		if (teacher != null) {
			teacher.setTeacherDetailId(teacherDetail);
			teacherService.saveTeacher(teacher); 
		}
		
//		teacherDetailService.saveTeacherDetail(teacherDetail); 
		
		
//		Teacher teacher1 = teacherService.getTeacher(1); 
//		
//		teacher1.setTeacherDetailId(teacherDetail); 
//		teacherService.saveTeacher(teacher1); 
		
		return "redirect:/teacherDetails/list"; 
	}
}
	
