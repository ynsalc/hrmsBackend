package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="job_advertisements")
public class JobAdvertisement 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="job_title_id")
	private JobPosition jobPosition;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quota")
	private int quota;
	
	@Column(name="appeal_expiration_date")
	private LocalDateTime appealExpirationDate;
	
	@Column(name="is_active", columnDefinition = "boolean default true")
	private boolean isActive;
	
	@Column(name="created_date")
	private Date createDate;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@ManyToOne(targetEntity = WorkType.class)
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	@ManyToOne(targetEntity = WorkTimeType.class)
	@JoinColumn(name ="work_time_id" )
	private WorkTimeType workTimeType;

	public JobAdvertisement() {}
	
	public JobAdvertisement(int cityId, int jobTitleId, int employerId, String jobDefinition,
			int quota,LocalDateTime deadLineForAppeal, double minSalary,double maxSalary,
			int workTypeId, int workTimeTypeId) {
		super();
		this.city = new City();
		this.jobPosition = new JobPosition();
		this.employer = new Employer();
		this.description = jobDefinition;
		this.quota = quota;
		this.appealExpirationDate = deadLineForAppeal;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.city.setId(cityId);
		this.jobPosition.setId(jobTitleId);
		this.employer.setId(employerId);
		this.workType = new WorkType();
		this.workType.setId(workTypeId);
		this.workTimeType = new WorkTimeType();
		this.workTimeType.setId(workTimeTypeId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public JobPosition getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public LocalDateTime getAppealExpirationDate() {
		return appealExpirationDate;
	}

	public void setAppealExpirationDate(LocalDateTime appealExpirationDate) {
		this.appealExpirationDate = appealExpirationDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public WorkTimeType getWorkTimeType() {
		return workTimeType;
	}

	public void setWorkTimeType(WorkTimeType workTimeType) {
		this.workTimeType = workTimeType;
	}
	
	
}
