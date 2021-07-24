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
import kodlamaio.hmrs.business.abstracts.CvImageService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvImage;

@RestController
@RequestMapping("/api/cvimages")
@CrossOrigin
public class CvImageController 
{
	private CvImageService cvImageService;
	
	@Autowired
	public CvImageController(CvImageService cvImageService) 
	{
		this.cvImageService = cvImageService;
	}
	
	@GetMapping("/getallimages")
	public ResponseEntity<?> getAll()
	{
		DataResult<List<CvImage>> dataResult = this.cvImageService.getAll();
		
		if(dataResult.isSuccess())
		{
			return ResponseEntity.ok(dataResult);
		}
		else
		{
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	@GetMapping("/getbyimages")
	public ResponseEntity<?> get(int id)
	{
		DataResult<CvImage> dataResult = this.cvImageService.get(id);
		
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
	public ResponseEntity<?> add(@RequestBody MultipartFile multipartFile,@RequestParam int id)
	{
		Result result = this.cvImageService.saveImage(multipartFile, id);
		
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
