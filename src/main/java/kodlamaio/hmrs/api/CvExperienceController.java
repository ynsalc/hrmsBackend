package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvExperienceService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.dtos.CvExperienceAddDto;

@RestController
@RequestMapping("/api/cvexperience")
@CrossOrigin
public class CvExperienceController 
{
	private CvExperienceService cvExperienceService;
	
	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) 
	{
		super();
		this.cvExperienceService = cvExperienceService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		DataResult<List<CvExperience>> experience = this.cvExperienceService.getAll();
		if(experience.isSuccess())
		{
			return ResponseEntity.ok(experience);
		}
		else 
		{
			return ResponseEntity.badRequest().body(experience);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CvExperienceAddDto cvExperienceAddDto)
	{
		Result result = this.cvExperienceService.add(cvExperienceAddDto);
		if(result.isSuccess())
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id)
	{
		Result result = this.cvExperienceService.delete(id);
		if(result.isSuccess())
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@GetMapping("/getbycvid")
	public DataResult<List<CvExperience>> getByCvMainId(@RequestParam int cvMainId)
	{
		return cvExperienceService.getByCvMainId(cvMainId);
	}
}
