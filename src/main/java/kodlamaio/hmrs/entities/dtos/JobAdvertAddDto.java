package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDateTime;

public class JobAdvertAddDto 
{
	private int cityId;
	private int jobTitleId;
	private int employerId;
	private String jobDefinition;
	private double minSalary;
	private double maxSalary;
	private int quota;
	private LocalDateTime deadLineForAppeal;
	private int workTypeId;
	private int workTimeTypeId;
	
	public JobAdvertAddDto() {
		super();
	}

	public JobAdvertAddDto(int cityId, int jobTitleId, int employerId, String jobDefinition, double minSalary,
			double maxSalary, int quota, LocalDateTime deadLineForAppeal,int workTypeId, int workTimeTypeId) {
		super();
		this.cityId = cityId;
		this.jobTitleId = jobTitleId;
		this.employerId = employerId;
		this.jobDefinition = jobDefinition;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.quota = quota;
		this.deadLineForAppeal = deadLineForAppeal;
		this.workTypeId = workTypeId;
		this.workTimeTypeId = workTimeTypeId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(int jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public String getJobDefinition() {
		return jobDefinition;
	}

	public void setJobDefinition(String jobDefinition) {
		this.jobDefinition = jobDefinition;
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

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public LocalDateTime getDeadLineForAppeal() {
		return deadLineForAppeal;
	}

	public void setDeadLineForAppeal(LocalDateTime deadLineForAppeal) {
		this.deadLineForAppeal = deadLineForAppeal;
	}

	public int getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}

	public int getWorkTimeTypeId() {
		return workTimeTypeId;
	}

	public void setWorkTimeTypeId(int workTimeTypeId) {
		this.workTimeTypeId = workTimeTypeId;
	}
	
	
}
