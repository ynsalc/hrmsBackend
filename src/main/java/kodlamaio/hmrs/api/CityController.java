package kodlamaio.hmrs.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController 
{
	private CityService cityService;
	
	public CityController(CityService cityService)
	{
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> GetAll()
	{
		return cityService.GetAll();
	}
	
	@PostMapping("/add")
	public Result Add(City city) 
	{
		return cityService.Add(city);
	}
}
