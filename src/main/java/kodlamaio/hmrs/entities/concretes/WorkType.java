package kodlamaio.hmrs.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="work_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class WorkType 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="worktype_name")
	private String workTypeName;
	

	public WorkType() {}
	
	public WorkType(int id, String workTypeName) {
		super();
		this.id = id;
		this.workTypeName = workTypeName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getWorkTypeName() {
		return workTypeName;
	}


	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}
}
