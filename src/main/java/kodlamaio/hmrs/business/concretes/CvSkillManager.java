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
<<<<<<< HEAD
=======
import kodlamaio.hmrs.entities.dtos.CvSkillDto;
>>>>>>> a62b5e5 (day 14 finished)

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
<<<<<<< HEAD
	public Result add(CvSkill cvSkill) 
	{
=======
	public Result add(CvSkillDto cvSkillDto) 
	{
		CvSkill cvSkill = new CvSkill(cvSkillDto.getResumeId(),cvSkillDto.getSkillName());
>>>>>>> a62b5e5 (day 14 finished)
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Başarıyla Eklendi.");
	}

<<<<<<< HEAD
=======
	@Override
	public DataResult<List<CvSkill>> getByCvMainId(int cvMainId) 
	{
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.getByCvMainId(cvMainId));
	}

	@Override
	public Result delete(int id) 
	{
		this.cvSkillDao.deleteById(id);
		return new SuccessResult("Başarıyla Silindi");
	}

>>>>>>> a62b5e5 (day 14 finished)
}
