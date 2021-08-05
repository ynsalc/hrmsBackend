package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> a62b5e5 (day 14 finished)
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> a62b5e5 (day 14 finished)
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvEducationService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvEducation;
<<<<<<< HEAD
=======
import kodlamaio.hmrs.entities.concretes.CvExperience;
>>>>>>> a62b5e5 (day 14 finished)
import kodlamaio.hmrs.entities.dtos.CvEducationAddDto;

@RestController
@RequestMapping("/api/cveducation")
@CrossOrigin
public class CvEducationController 
{
	private CvEducationService cvEducationService;

	@Autowired
	public CvEducationController(CvEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		DataResult<List<CvEducation>> dataResult = this.cvEducationService.getAll();
		if(dataResult.isSuccess()) 
		{
			return ResponseEntity.ok(dataResult);
		}
		else 
		{
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CvEducationAddDto cvEducationAddDto)
	{
		Result result = this.cvEducationService.add(cvEducationAddDto);
		if(result.isSuccess())
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
<<<<<<< HEAD
=======
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id)
	{
		Result result = this.cvEducationService.delete(id);
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
	public DataResult<List<CvEducation>> getByCvMainId(@RequestParam int cvMainId)
	{
		return cvEducationService.getByCvMainId(cvMainId);
	}
>>>>>>> a62b5e5 (day 14 finished)
}
