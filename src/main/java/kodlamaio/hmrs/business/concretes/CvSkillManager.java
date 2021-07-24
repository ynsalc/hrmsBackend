package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvSkillService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvSkillDao;
import kodlamaio.hmrs.entities.concretes.CvSkill;

@Service
public class CvSkillManager implements CvSkillService 
{

	private CvSkillDao cvSkillDao;
	
	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) 
	{
		this.cvSkillDao = cvSkillDao;
	}
	
	@Override
	public DataResult<List<CvSkill>> getAll() 
	{
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findAll(),"Listeleme başarılı.");
	}

	@Override
	public DataResult<CvSkill> get(int id) 
	{
		return new SuccessDataResult<CvSkill>(this.cvSkillDao.findById(id).orElse(null));
	}

	@Override
	public Result add(CvSkill cvSkill) 
	{
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Başarıyla Eklendi.");
	}

}
