package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="cv_main")
@JsonIgnoreProperties
public class CvMain 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="created_date")
	private String createdDate;

	@JsonProperty(access = Access.READ_ONLY)
	@OneToMany(mappedBy = "cvMain")
	private List<CvSkill> cvSkill;
	
	@OneToMany(mappedBy="cvMain")
	private List<CvEducation> cvEducation;
	
	@OneToMany(mappedBy="cvMain")
	private List<CvExperience> cvExperience;
	
	@OneToMany(mappedBy="cvMain")
	private List<CvLanguage> cvLanguage;
	
	@Column(name="photoUrl")
	private String photo;
	
	public CvMain() {}
	
	public CvMain(int candidateId, String githubLink, String linkedinLink, String coverLetter,
			String createdDate) {
		super();
		this.candidate = new Candidate();
		this.candidate.setId(candidateId);
		this.githubLink = githubLink;
		this.linkedinLink = linkedinLink;
		this.coverLetter = coverLetter;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public String getLinkedinLink() {
		return linkedinLink;
	}

	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<CvSkill> getCvSkill() {
		return cvSkill;
	}

	public void setCvSkill(List<CvSkill> cvSkill) {
		this.cvSkill = cvSkill;
	}

	public List<CvEducation> getCvEducation() {
		return cvEducation;
	}

	public void setCvEducation(List<CvEducation> cvEducation) {
		this.cvEducation = cvEducation;
	}

	public List<CvExperience> getCvExperience() {
		return cvExperience;
	}

	public void setCvExperience(List<CvExperience> cvExperience) {
		this.cvExperience = cvExperience;
	}

	public List<CvLanguage> getCvLanguage() {
		return cvLanguage;
	}

	public void setCvLanguage(List<CvLanguage> cvLanguage) {
		this.cvLanguage = cvLanguage;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
