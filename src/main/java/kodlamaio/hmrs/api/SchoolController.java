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

import kodlamaio.hmrs.business.abstracts.SchoolService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolController 
{
	@Autowired
	private SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		DataResult<List<School>> result = this.schoolService.getAll();
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
		DataResult<School> result = this.schoolService.get(id);
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
	public ResponseEntity<?> add(@RequestBody School school)
	{
		Result result = this.schoolService.add(school);
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
