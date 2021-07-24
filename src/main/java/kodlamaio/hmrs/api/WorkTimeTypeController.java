package kodlamaio.hmrs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.WorkTimeTypeService;
import kodlamaio.hmrs.entities.concretes.WorkTimeType;

@RestController
@RequestMapping("/api/worktimetypes")
@CrossOrigin
public class WorkTimeTypeController 
{
	private WorkTimeTypeService workTimeTypeService;
	
	@Autowired
	public WorkTimeTypeController(WorkTimeTypeService workTimeTypeService) 
	{
		this.workTimeTypeService = workTimeTypeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.workTimeTypeService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkTimeType workTimeType)
	{
		return ResponseEntity.ok(this.workTimeTypeService.add(workTimeType));
	}
}
