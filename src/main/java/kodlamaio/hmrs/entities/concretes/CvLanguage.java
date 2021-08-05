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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="cv_language")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvMain"})
public class CvLanguage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = CvMain.class)
	@JoinColumn(name="resume_main_id")
	private CvMain cvMain;
	
	@Column(name="language_name")
	private String languageName;
	
	@Column(name="level")
	private int level;

	public CvLanguage() {}
	
	public CvLanguage(int resumeId, String languageName, int level) {
		super();
		this.cvMain = new CvMain();
		this.cvMain.setId(resumeId);
		this.languageName = languageName;
		this.level = level;
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

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
