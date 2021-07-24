package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CvMainService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvMain;
import kodlamaio.hmrs.entities.dtos.CandidateCvAddDto;

@RestController
@RequestMapping("/api/cvmain")
@CrossOrigin
public class CvMainController 
{
	private CvMainService cvMainService;

	@Autowired
	public CvMainController(CvMainService cvMainService) {
		super();
		this.cvMainService = cvMainService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		DataResult<List<CvMain>> dataResult = this.cvMainService.getAll();
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
	public ResponseEntity<?> add(@RequestBody CandidateCvAddDto candidateCvAddDto)
	{
		Result result = this.cvMainService.add(candidateCvAddDto);
		if(result.isSuccess()) 
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@PostMapping("/uploadPhoto")
	public Result uploadPhoto(@RequestParam int cvId, @RequestParam("file") MultipartFile photoFile) 
	{
		return this.cvMainService.uploadPhoto(cvId, photoFile);
	}
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidate_Id(@RequestParam int candidateId)
	{
		DataResult<List<CvMain>> result = this.cvMainService.getByCandidate_Id(candidateId);
		if(result.isSuccess())
		{
			return ResponseEntity.ok(result);
		}
		else 
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id)
	{
		DataResult<CvMain> result = this.cvMainService.get(id);
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
