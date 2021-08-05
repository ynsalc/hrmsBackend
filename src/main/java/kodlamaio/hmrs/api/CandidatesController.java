package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.CandidateFavoriteJobAdvert;
import kodlamaio.hmrs.entities.dtos.CandidateFavoriteJobAdvertDto;

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
	
	@GetMapping("/getbyfavoritecandidateid")
	public DataResult<List<CandidateFavoriteJobAdvert>> getByCandidate_Id(@RequestParam int candidateId)
	{
		return candidateService.getByCandidate_Id(candidateId);
	}
	
	@PostMapping("/addfavoriteadvert")
	public Result favoriteJobAdvert(CandidateFavoriteJobAdvertDto candidateFavoriteJobAdvertDto)
	{
		return candidateService.favoriteJobAdvert(candidateFavoriteJobAdvertDto);
	}
	
	@DeleteMapping("/removefavoriteadvert")
	public Result removeFavorite(@RequestParam int id)
	{
		return candidateService.removeFavorite(id);
	}
}
