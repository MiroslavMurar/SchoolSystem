package schoolsystem.mm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_detail")
public class TeacherDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="profile")
	private String profile; 
	
	@Column(name="hobby")
	private String hobby;

	public TeacherDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherDetail(String profile, String hobby) {
		super();
		this.profile = profile;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	} 
}
