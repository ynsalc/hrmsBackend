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
@Table(name="cv_education")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvMain"})
public class CvEducation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_year")
	private String startYear;
	
	@Column(name="end_year")
	private String endYear;
	
	@ManyToOne()
	@JoinColumn(name="school_id")
	private School school;
	
	@ManyToOne(targetEntity = CvMain.class)
	@JoinColumn(name="resume_main_id")
	private CvMain cvMain;
	
	
	public CvEducation() {}
	
	public CvEducation(int resumeId, int schoolId, String department, String startYear, String endYear) {
		super();
		this.cvMain = new CvMain();
		this.cvMain.setId(resumeId);
		this.school = new School();
		this.school.setId(schoolId);
		this.department = department;
		this.startYear = startYear;
		this.endYear = endYear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public CvMain getCvMain() {
		return cvMain;
	}

	public void setCvMain(CvMain cvMain) {
		this.cvMain = cvMain;
	}
	
	
}
