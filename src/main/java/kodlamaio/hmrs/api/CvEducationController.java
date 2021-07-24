package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvEducationService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvEducation;
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
}
