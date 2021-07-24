package kodlamaio.hmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
@JsonIgnoreProperties
public class Candidate extends User
{
	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="identity_number")
	private String IdentityNumber;
	
	@Column(name="birth_date")
	private Date BirthDate;
	

	public Candidate() {}
	
	public Candidate(int id, String email, String password,String firstName, String lastName, String identityNumber, Date birthDate) 
	{
		super(id,email,password);
		FirstName = firstName;
		LastName = lastName;
		IdentityNumber = identityNumber;
		BirthDate = birthDate;
	}

	

	public String getFirstName() 
	{
		return FirstName;
	}

	public void setFirstName(String firstName) 
	{
		FirstName = firstName;
	}

	public String getLastName() 
	{
		return LastName;
	}

	public void setLastName(String lastName) 
	{
		LastName = lastName;
	}

	public String getIdentityNumber() 
	{
		return IdentityNumber;
	}

	public void setIdentityNumber(String identityNumber) 
	{
		IdentityNumber = identityNumber;
	}

	public Date getBirthDate() 
	{
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) 
	{
		BirthDate = birthDate;
	}
}
