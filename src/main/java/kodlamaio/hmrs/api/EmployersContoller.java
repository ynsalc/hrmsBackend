package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersContoller 
{
	private EmployerService employerService;

	@Autowired
	public EmployersContoller(EmployerService employerService) 
	{
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> GetAll()
	{
		return employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result Add(@RequestBody Employer employer) 
	{
		return employerService.Add(employer);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Employer> get(int id)
	{
		return employerService.get(id);
	}
}
