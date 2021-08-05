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

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
<<<<<<< HEAD
=======
import kodlamaio.hmrs.entities.dtos.CvLanguageDto;
>>>>>>> a62b5e5 (day 14 finished)

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
<<<<<<< HEAD
	public ResponseEntity<?> add(@RequestBody CvLanguage cvLanguage)
	{
		Result result = this.cvLanguageService.add(cvLanguage);
=======
	public ResponseEntity<?> add(@RequestBody CvLanguageDto cvLanguageDto)
	{
		Result result = this.cvLanguageService.add(cvLanguageDto);
>>>>>>> a62b5e5 (day 14 finished)
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
		Result result = this.cvLanguageService.delete(id);
		if(result.isSuccess())
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@GetMapping("getbycvid")
	public DataResult<List<CvLanguage>> getByCvMainId(@RequestParam int cvMainId)
	{
		return this.cvLanguageService.getByCvMainId(cvMainId);
	}
>>>>>>> a62b5e5 (day 14 finished)
}
