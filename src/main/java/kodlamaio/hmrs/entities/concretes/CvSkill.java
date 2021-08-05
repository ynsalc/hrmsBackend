package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="cv_skills")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvMain"})
public class CvSkill 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = CvMain.class)
	@JoinColumn(name="resume_main_id")
	private CvMain cvMain;
	
	@Column(name="skill_name")
	private String skillName;

	public CvSkill() {}
	
<<<<<<< HEAD
	public CvSkill(int id, String skillName, CvMain cvMain) {
		super();
		this.id = id;
		this.cvMain = cvMain;
=======
	public CvSkill(int resumeId, String skillName) {
		super();
		this.cvMain = new CvMain();
		this.cvMain.setId(resumeId);
>>>>>>> a62b5e5 (day 14 finished)
		this.skillName = skillName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CvMain getCvMain() {
		return cvMain;
	}

	public void setCvMain(CvMain cvMain) {
		this.cvMain = cvMain;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
}
