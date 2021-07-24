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

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvLanguage;

@RestController
@RequestMapping("/api/cvlanguage")
@CrossOrigin
public class CvLanguageController 
{
	private CvLanguageService cvLanguageService;
	
	@Autowired
	public CvLanguageController(CvLanguageService cvLanguageService)
	{
		this.cvLanguageService=cvLanguageService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		DataResult<List<CvLanguage>> result = this.cvLanguageService.getAll();
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
		DataResult<CvLanguage> result = this.cvLanguageService.get(id);
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
	public ResponseEntity<?> add(@RequestBody CvLanguage cvLanguage)
	{
		Result result = this.cvLanguageService.add(cvLanguage);
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
