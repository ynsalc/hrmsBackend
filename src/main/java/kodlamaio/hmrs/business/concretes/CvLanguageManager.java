package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.hmrs.entities.concretes.CvLanguage;

@Service
public class CvLanguageManager implements CvLanguageService
{
	private CvLanguageDao cvLanguageDao;

	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() 
	{
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll(),"Listelendi.");
	}

	@Override
	public DataResult<CvLanguage> get(int id) 
	{
		return new SuccessDataResult<CvLanguage>(this.cvLanguageDao.findById(id).orElse(null));
	}

	@Override
	public Result add(CvLanguage cvLanguage) 
	{
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Başarıyla Eklendi.");
	}

}
