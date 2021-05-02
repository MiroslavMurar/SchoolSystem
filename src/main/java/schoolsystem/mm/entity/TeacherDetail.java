package schoolsystem.mm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="teacher_detail")
public class TeacherDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@NotNull(message="is required")
	@Min(value=5, message="must be greater than 0")
	@Max(value=10, message="must be lower than 10")
	@Column(name="profile")
	private String profile; 
	
	@NotNull(message="is required")
	@Min(value=5, message="must be greater than 0")
	@Max(value=10, message="must be lower than 10")
	@Column(name="hobby")
	private String hobby;

	public TeacherDetail() {} 

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
