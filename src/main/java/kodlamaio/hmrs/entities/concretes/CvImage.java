package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cv_image")
public class CvImage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne()
	@JoinColumn(name="resume_main_id")
	private CvMain cvMain;
	
	@Column(name="url_adress")
	private String urlAdress;

	public CvImage() {}
	
	public CvImage(String urlAdress,int resumeId) {
		super();
		this.urlAdress = urlAdress;
		this.cvMain = new CvMain();
		this.cvMain.setId(resumeId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlAdress() {
		return urlAdress;
	}

	public void setUrlAdress(String urlAdress) {
		this.urlAdress = urlAdress;
	}

	public CvMain getCvMain() {
		return cvMain;
	}

	public void setCvMain(CvMain cvMain) {
		this.cvMain = cvMain;
	}
	
}
