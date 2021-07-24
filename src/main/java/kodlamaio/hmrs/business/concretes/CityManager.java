package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CityDao;
import kodlamaio.hmrs.entities.concretes.City;

@Service
public class CityManager implements CityService
{
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) 
	{
		this.cityDao = cityDao;
	}
	
	@Override
	public DataResult<List<City>> GetAll() 
	{
		return new SuccessDataResult<List<City>>(cityDao.findAll(),"Şehirler listelendi");
	}

	@Override
	public Result Add(City city) 
	{
		cityDao.save(city);
		return new SuccessResult("Şehir eklendi.");
	}

}
