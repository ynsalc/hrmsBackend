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
@Table(name="worktime_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class WorkTimeType 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="worktime_name")
	private String workTimeName;
	
	public WorkTimeType() {}

	public WorkTimeType(int id, String workTimeName) {
		super();
		this.id = id;
		this.workTimeName = workTimeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkTimeName() {
		return workTimeName;
	}

	public void setWorkTimeName(String workTimeName) {
		this.workTimeName = workTimeName;
	}
}
