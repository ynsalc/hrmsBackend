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
import kodlamaio.hmrs.entities.dtos.CvLanguageDto;

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
	public Result add(CvLanguageDto cvLanguageDto) 
	{
		CvLanguage cvLanguage = new CvLanguage(cvLanguageDto.getResumeId(),cvLanguageDto.getLanguageName(),cvLanguageDto.getLevel());
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Başarıyla Eklendi.");
	}
	@Override
	public Result delete(int id) 
	{
		this.cvLanguageDao.deleteById(id);
		return new SuccessResult("Başarıyla Silindi.");
	}

	@Override
	public DataResult<List<CvLanguage>> getByCvMainId(int cvMainId) 
	{
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getByCvMainId(cvMainId));
	}
}
