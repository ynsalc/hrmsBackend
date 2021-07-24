package kodlamaio.hmrs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.WorkTypeService;
import kodlamaio.hmrs.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/worktypes")
@CrossOrigin
public class WorkTypeController 
{
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) 
	{
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.workTypeService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkType workType)
	{
		return ResponseEntity.ok(this.workTypeService.add(workType));
	}
}
