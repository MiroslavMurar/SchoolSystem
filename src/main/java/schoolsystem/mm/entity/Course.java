package schoolsystem.mm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="title")
	private String title; 
	
	@ManyToOne()
	@JoinColumn(name="teacher_id")
	Teacher teacher;

	@ManyToMany(fetch = FetchType.EAGER, 
				cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(name="course_student", 
			joinColumns = @JoinColumn(name = "course_id"), 
			inverseJoinColumns = @JoinColumn(name = "student_id")
			)
	List<Student> students; 
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		
		if(students == null) {
			students = new ArrayList<>(); 
		}
		students.add(student); 
	}
	
	
	public Course() {}

	public Course(String title, Teacher teacher) {
		super();
		this.title = title;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	} 
}
