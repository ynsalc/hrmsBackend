package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cv_experience")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvMain"})
public class CvExperience 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = CvMain.class)
	@JoinColumn(name="resume_main_id")
	private CvMain cvMain;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_year")
	private String startYear;
	
	@Column(name="end_year")
	private String endYear;
	
	public CvExperience() {}

	public CvExperience(int resumeId, String companyName, String position, String startYear, String endYear) {
		super();
		this.cvMain = new CvMain();
		this.cvMain.setId(resumeId);
		this.companyName = companyName;
		this.position = position;
		this.startYear = startYear;
		this.endYear = endYear;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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
}
