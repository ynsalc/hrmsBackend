package kodlamaio.hmrs.entities.dtos;

import java.util.List;

public class JobAdvertisementFilter 
{
	private List<Integer> cityId;
	private List<Integer> jobPositionId;
	private List<Integer> workTypeId;
	
	public JobAdvertisementFilter() {}
	
	public JobAdvertisementFilter(List<Integer> cityId, List<Integer> jobPositionId, List<Integer> workTypeId) 
	{
		super();
		this.cityId = cityId;
		this.jobPositionId = jobPositionId;
		this.workTypeId = workTypeId;
	}

	public List<Integer> getCityId() 
	{
		return cityId;
	}
	
	public void setCityId(List<Integer> cityId) 
	{
		this.cityId = cityId;
	}
	
	public List<Integer> getJobPositionId() 
	{
		return jobPositionId;
	}
	
	public void setJobPositionId(List<Integer> jobPositionId) 
	{
		this.jobPositionId = jobPositionId;
	}
	
	public List<Integer> getWorkTypeId() 
	{
		return workTypeId;
	}
	
	public void setWorkTypeId(List<Integer> workTypeId) 
	{
		this.workTypeId = workTypeId;
	}
}
