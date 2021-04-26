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
import schoolsystem.mm.services.TeacherService;

@Controller	
@RequestMapping("/teachers")
public class TeacherController {
	
private List<Teacher> theTeachers; 
	
	@Autowired
	private TeacherService teacherService; 


	@GetMapping("/list")
	public String listTeachers(Model theModel) {
		
		List<Teacher> teachers = teacherService.getTeachers(); 
		
		theModel.addAttribute("teachers", teachers); 
		
		return "list-teachers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Teacher teacher = new Teacher(); 
		
		model.addAttribute("teacher", teacher); 
		
		return "teacher-form"; 
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("teacher") Teacher teacher, Model model) {
		
//		teacherService.saveTeacher(teacher); 
//		teacherService.persistTeacher(teacher);
		
		model.addAttribute("teacher", teacher); 
		
		return "redirect:/teacherDetails/showFormForAdd"; 
	}
}
	
