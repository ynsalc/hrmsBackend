package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvExperienceService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvExperienceDao;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.dtos.CvExperienceAddDto;

@Service
public class CvExperienceManager implements CvExperienceService
{
	
	private CvExperienceDao cvExperienceDao;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) 
	{
		this.cvExperienceDao = cvExperienceDao;
	}
	
	@Override
	public DataResult<List<CvExperience>> getAll() 
	{
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CvExperience>> getByCvMainId(int cvMainCv)
	{
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getByCvMainId(cvMainCv));
	}

	@Override
	public DataResult<CvExperience> get(int id) 
	{
		return new SuccessDataResult<CvExperience>(this.cvExperienceDao.findById(id).orElse(null));
	}

	@Override
	public Result add(CvExperienceAddDto cvExperienceAddDto)
	{
		CvExperience cvExperience = new CvExperience(cvExperienceAddDto.getResumeId(),cvExperienceAddDto.getCompanyName(),
				cvExperienceAddDto.getPosition(),cvExperienceAddDto.getStartYear(),cvExperienceAddDto.getEndYear());
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Başarıyla Kaydedildi.");
	}
	@Override
	public Result delete(int id) 
	{
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult("Başarıyla silindi.");
	}
}
