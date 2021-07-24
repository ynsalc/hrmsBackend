package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController 
{
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) 
	{
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> GetAll()
	{
		return candidateService.GetAll();
	}
	
	@PostMapping("/add")
	public Result Add(@RequestBody Candidate candidate)
	{
		return candidateService.Add(candidate);
	}
}
