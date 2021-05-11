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
import schoolsystem.mm.entity.Student;
import schoolsystem.mm.services.CourseService;
import schoolsystem.mm.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService; 
	
	@Autowired
	CourseService courseService; 
	
	@GetMapping("/list")
	public String listStudents(Model model) {
		
		List<Student> students = studentService.getStudents(); 
		
		model.addAttribute("students", students); 
		
		return "students/list-students"; 
		
	}
	
	@GetMapping("/list/{studentId}")
	public String listStudents(@PathVariable("studentId") int studentId, Model model) {
		
		Student student = studentService.getStudent(studentId); 
		List<Course> courses = student.getCourses(); 
		
		model.addAttribute("courses", courses); 
		model.addAttribute("student", student);
		
		return "students/list-student"; 
		
	}
	
	@GetMapping("/deleteCourse/{courseId}/{studentId}")
	public String deleteCourse(@PathVariable("courseId") int courseId, 
								@PathVariable("studentId") int studentId) { 
	
		Student student = studentService.getStudent(studentId); 
		Course course = courseService.getCourse(courseId); 
		
		System.out.println("Student name: " + student.getFirstName());
		System.out.println("Course title: " + course.getTitle()); 
		
		student.removeCourse(course); 
		studentService.saveStudent(student); 
		
		return "redirect:/students/list"; 
	}
	
	
	@GetMapping("/showCourses/{studentId}")
	public String showCourses(@PathVariable("studentId") int studentId, Model model) { 
		
		Student student = studentService.getStudent(studentId); 
		
		List<Course> courses = courseService.getCourses(); 
		
		model.addAttribute("courses", courses); 
		model.addAttribute("student", student);
		
		return "courses/list-courses"; 
		
	}
	
	@GetMapping("/addCourse/{courseId}/{studentId}") 
//						(courseId=${course.id},studentId=${student.id})}")
	public String addCourse(@PathVariable("courseId") int courseId, @PathVariable("studentId") int studentId) { 
		
		Student student = studentService.getStudent(studentId); 
		Course course = courseService.getCourse(courseId);
		
		student.addCourse(course); 
		studentService.saveStudent(student); 
		
		return "redirect:/students/showCourses/{studentId}"; 
		
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student student = new Student(); 
		
		model.addAttribute("student", student); 
		
		return "students/student-form"; 
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student); 
		
		return "redirect:/students/list"; 
		
	}	
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("studentId") int studentId, Model model) {
		
		Student student = studentService.getStudent(studentId); 
		
		model.addAttribute("student", student); 
		
		return "students/student-form"; 
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int studentId) {
		
		studentService.deleteStudent(studentId); 
		
		return "redirect:/students/list"; 
	}
	
	@GetMapping("/showCourses")
	public String showCourses(@RequestParam("studentId") int studentId) { 
		
		return "redirect:students/list/" + studentId; 
		
	}
	
	
}
