package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.ErrorResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobAdvertAddDto;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementFilter;

@RestController
@RequestMapping("/api/jobadvertisement")
@CrossOrigin
public class JobAdvertisementController 
{
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) 
	{
		super();
		this.jobAdvertisementService=jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> GetAll()
	{
		return jobAdvertisementService.GetAll();
	}
	
	@PostMapping("/add")
	public Result Add(@RequestBody JobAdvertAddDto jobAdvertAddDto)
	{
		JobAdvertisement jobAdvert = new JobAdvertisement(jobAdvertAddDto.getCityId(),
				jobAdvertAddDto.getJobTitleId(),jobAdvertAddDto.getEmployerId(),jobAdvertAddDto.getJobDefinition(),
				jobAdvertAddDto.getQuota(),jobAdvertAddDto.getDeadLineForAppeal(),
				jobAdvertAddDto.getMinSalary(),jobAdvertAddDto.getMaxSalary(),jobAdvertAddDto.getWorkTypeId(),
				jobAdvertAddDto.getWorkTimeTypeId());
		Result result = jobAdvertisementService.Add(jobAdvert);
		if(result.isSuccess())
		{
			return new SuccessResult("İş ilanı Eklendi.");
		}
		else 
		{
			return new ErrorResult("İş ilanı eklenemedi.");
		}
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisement> get(@RequestParam int id)
	{
		return jobAdvertisementService.get(id);
	}
	
	@PostMapping("/delete")
	public Result Delete(@RequestBody JobAdvertisement jobAdvertisement) 
	{
		return jobAdvertisementService.Delete(jobAdvertisement);
	}
	
	@GetMapping("/getbyisactive")
	public DataResult<List<JobAdvertisement>> getByIsActive(@RequestParam Boolean isActive)
	{
		return jobAdvertisementService.getByIsActive(isActive);
	}
	
	@GetMapping("/getbyemployerid")
	public DataResult<List<JobAdvertisement>> getByEmployer_Id(@RequestParam int employerId)
	{
		return jobAdvertisementService.getByEmployer_Id(employerId);
	}
	
	@GetMapping("/filter")
	public DataResult<List<JobAdvertisement>> getByCity_IdAndWorkType_IdAndJobPosition_Id(@RequestParam int cityId, @RequestParam int workTypeId, @RequestParam int jobPositionId)
	{
		return jobAdvertisementService.getByCity_IdAndWorkType_IdAndJobPosition_Id(cityId, workTypeId, jobPositionId);
	}
	
	@PostMapping("/getAllByFilteredAndPaged")
	public DataResult<List<JobAdvertisement>> getAllByFilteredAndPaged(@RequestParam int pageNo, @RequestParam int pageSize, @RequestBody JobAdvertisementFilter filterOption) {
		return this.jobAdvertisementService.getAllByFilteredAndPaged(pageNo, pageSize, filterOption);
	}
}