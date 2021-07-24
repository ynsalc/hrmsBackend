package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class Employer extends User
{
	@Column(name="company_name")
	private String CompanyName;
	
	@Column(name="web_adress")
	private String WebAdress;
	
	@Column(name="phone_number")
	private String PhoneNumber;
	
	@Column(name="is_activated")
	private boolean IsActivated;
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvertisement> jobAdvertisement;
	
	public Employer() {}

	public Employer(int id, String email,String password,String companyName, String webAdress, String phoneNumber, boolean isActivated, List<JobAdvertisement> jobAdvertisement) 
	{
		super(id,email,password);
		CompanyName = companyName;
		WebAdress = webAdress;
		PhoneNumber = phoneNumber;
		IsActivated = isActivated;
		this.jobAdvertisement = jobAdvertisement;
	}

	

	public String getCompanyName() 
	{
		return CompanyName;
	}

	public void setCompanyName(String companyName) 
	{
		CompanyName = companyName;
	}

	public String getWebAdress() 
	{
		return WebAdress;
	}

	public void setWebAdress(String webAdress) 
	{
		WebAdress = webAdress;
	}

	public String getPhoneNumber() 
	{
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		PhoneNumber = phoneNumber;
	}

	public boolean isIsActivated() 
	{
		return IsActivated;
	}

	public void setIsActivated(boolean isActivated) 
	{
		IsActivated = isActivated;
	}

	public List<JobAdvertisement> getJobAdvertisement() {
		return jobAdvertisement;
	}

	public void setJobAdvertisement(List<JobAdvertisement> jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}
}
