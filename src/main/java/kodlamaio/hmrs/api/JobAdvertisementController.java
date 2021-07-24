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
}