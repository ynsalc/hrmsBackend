package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvEducationService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvEducationDao;
import kodlamaio.hmrs.dataAccess.abstracts.CvMainDao;
import kodlamaio.hmrs.entities.concretes.CvEducation;
import kodlamaio.hmrs.entities.dtos.CvEducationAddDto;

@Service
public class CvEducationManager implements CvEducationService 
{

	private CvEducationDao cvEducationDao;
	
	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) 
	{
		this.cvEducationDao = cvEducationDao;
	}
	
	@Override
	public DataResult<List<CvEducation>> getAll() 
	{
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findAll(),"Eğitim Listelendi");
	}

	@Override
	public DataResult<List<CvEducation>> getByCvMainId(int cvMainId) 
	{
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getByCvMainId(cvMainId));
	}

	@Override
	public DataResult<CvEducation> get(int id) 
	{
		return new SuccessDataResult<CvEducation>(this.cvEducationDao.findById(id).orElse(null)); 
	}

	@Override
	public Result add(CvEducationAddDto cvEducationAddDto) 
	{
		CvEducation cvEducation = new CvEducation(cvEducationAddDto.getResumeId(),cvEducationAddDto.getSchoolId(),
				cvEducationAddDto.getDepartment(),cvEducationAddDto.getStartYear(),cvEducationAddDto.getEndYear());
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Başarıyla Eklendi.");
	}
	@Override
	public Result delete(int id) 
	{
		this.cvEducationDao.deleteById(id);
		return new SuccessResult("Başarıyla Silindi");
	}
}
