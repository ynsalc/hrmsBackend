package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class JobPosition 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id; 
	
	@Column(name="title")
	private String Name;  
	
	@OneToMany(mappedBy="jobPosition")
	private List<JobAdvertisement> jobAdvertisement;
	
	public JobPosition() {}

	public JobPosition(int id, String name, List<JobAdvertisement> jobAdvertisement) 
	{
		//super();
		Id = id;
		Name = name;
		this.jobAdvertisement = jobAdvertisement;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<JobAdvertisement> getJobAdvertisement() {
		return jobAdvertisement;
	}

	public void setJobAdvertisement(List<JobAdvertisement> jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}
	
	
}
