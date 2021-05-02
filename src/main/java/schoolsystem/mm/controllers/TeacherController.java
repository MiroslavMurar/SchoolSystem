package schoolsystem.mm.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/teachers")
public class TeacherController { 
	
	@Autowired
	private TeacherService teacherService; 

	@Autowired
	private TeacherDetailService teacherDetailService; 

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

		TeacherDetail teacherDetail = new TeacherDetail();
		teacher.setTeacherDetailId(teacherDetail); 
		
		teacherService.saveTeacher(teacher);   
		
		return "redirect:/teachers/list"; 
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("teacher") Teacher teacher) {
		
		teacherService.saveTeacher(teacher);
		
		return "redirect:/teachers/list"; 
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("teacherId") int teacherId, Model model) {
		
		Teacher teacher = teacherService.getTeacher(teacherId); 
		
		model.addAttribute("teacher", teacher); 
		
		return "teacher-update-form"; 
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("teacherId") int teacherId) {
		System.out.println("Hello");
		
		teacherService.deleteTeacher(teacherId); 
		
		return "redirect:/teachers/list"; 
	}
}
	
