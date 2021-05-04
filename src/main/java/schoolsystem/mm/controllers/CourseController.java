package schoolsystem.mm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import schoolsystem.mm.entity.Course;
import schoolsystem.mm.entity.Teacher;
import schoolsystem.mm.services.CourseService;
import schoolsystem.mm.services.TeacherService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService; 
	
	@Autowired
	private TeacherService teacherService;  
	
	
	@GetMapping("/list/{teacherId}")
	public String teacherListCourses(@PathVariable("teacherId") int teacherId, Model model) {
		
		Teacher teacher = teacherService.getTeacher(teacherId);  
		List<Course> courses = teacher.getCourses(); 
		
		model.addAttribute("courses", courses); 
		model.addAttribute("teacher", teacher);
		
		return "courses/list-teacher-courses"; 
	}
	
	@GetMapping("/showFormForAdd/{teacherId}")
	public String showFormForAdd(@PathVariable("teacherId") int teacherId, Model model) {
		
		Teacher teacher = teacherService.getTeacher(teacherId); 
		Course course = new Course(); 
		
		course.setTeacher(teacher); 
		model.addAttribute("course", course); 
		model.addAttribute("teacher", teacher); 
		
		return "courses/course-form"; 	
	}
	
	@GetMapping("/showFormForAdd/{teacherId}/{courseId}")
	public String showFormForAdd(@PathVariable("teacherId") int teacherId, 
								 @PathVariable("courseId") int courseId, Model model) {
		
		Teacher teacher = teacherService.getTeacher(teacherId); 
		Course course = courseService.getCourse(courseId); 
		
		course.setTeacher(teacher); 
		model.addAttribute("course", course); 
		model.addAttribute("teacher", teacher); 
		
		return "courses/course-form"; 
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("course") Course course) {
		
		Teacher teacher = teacherService.getTeacher(course.getTeacher().getId()); 
		teacher.addCourses(course); 
		courseService.saveCourse(course); 
		
		return "redirect:/courses/list/" + teacher.getId(); 
		
	}
	
	@GetMapping("/delete//{teacherId}/{courseId}")
	public String delete(@PathVariable("teacherId") int teacherId, @PathVariable("courseId") int courseId) {
		
		courseService.deleteCourse(courseId);
		
		return "redirect:/courses/list/" + teacherId; 
	}
}
