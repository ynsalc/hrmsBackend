package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.SchoolService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.SchoolDao;
import kodlamaio.hmrs.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService
{
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() 
	{
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Listelendi");
	}

	@Override
	public DataResult<School> get(int id) 
	{
		return new SuccessDataResult<School>(this.schoolDao.findById(id).orElse(null));
	}

	@Override
	public Result add(School school) 
	{
		this.schoolDao.save(school);
		return new SuccessResult("Başarıyla eklendi.");
	}

}
