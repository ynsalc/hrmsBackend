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

import kodlamaio.hmrs.business.abstracts.CvSkillService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvSkill;
import kodlamaio.hmrs.entities.dtos.CvSkillDto;

@RestController
@RequestMapping("/api/cvskills")
@CrossOrigin
public class CvSkillController 
{
	private CvSkillService cvSkillService;
	
	@Autowired
	public CvSkillController(CvSkillService cvSkillService) {
		super();
		this.cvSkillService = cvSkillService;
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		DataResult<List<CvSkill>> result = this.cvSkillService.getAll();
		if(result.isSuccess())
		{
			return ResponseEntity.ok(result);
		}
		else 
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> get(int id)
	{
		DataResult<CvSkill> result = this.cvSkillService.get(id);
		if(result.isSuccess())
		{
			return ResponseEntity.ok(result);
		}
		else 
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CvSkillDto cvSkillDto)
	{
		Result result = this.cvSkillService.add(cvSkillDto);
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
		Result result = this.cvSkillService.delete(id);
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
	public DataResult<List<CvSkill>> getByCvMainId(@RequestParam int cvMainId)
	{
		return this.cvSkillService.getByCvMainId(cvMainId);
	}
}
