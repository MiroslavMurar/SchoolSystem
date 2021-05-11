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
import javax.persistence.Table;

import net.bytebuddy.asm.Advice.This;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="first_name")
	private String firstName; 
	
	@Column(name="last_name")
	private String lastName; 
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(fetch=FetchType.EAGER, 
				cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})

	@JoinTable(name="course_student", 
				joinColumns=@JoinColumn(name="student_id"),
				inverseJoinColumns=@JoinColumn(name="course_id")
			)
	List<Course> courses; 
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
	
		if (courses == null) {
			courses = new ArrayList<>(); 
		}
		courses.add(course); 
	}
	
	public void removeCourse(Course course) {
		
		for (int i = 0; i < this.courses.size(); i++) {
			Course iteratedCourse = this.courses.get(i);
			if (iteratedCourse.getTitle().equals(course.getTitle())) {
				this.courses.remove(i); 
				break; 
			}
		}	
		
//		int index = this.courses.indexOf(course); 
//		System.out.println("index is: " + index);
//		
//		for (int i = 0; i < this.courses.size(); i++) {
//			Course course1 = this.courses.get(i);
//			System.out.println(course1.getTitle());
//			
//		}
//		
//		if (index != -1) {
//			this.courses.remove(index); 
//		}
	}
		


	public Student() {}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
