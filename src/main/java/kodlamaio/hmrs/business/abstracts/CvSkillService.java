package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvSkill;
<<<<<<< HEAD
=======
import kodlamaio.hmrs.entities.dtos.CvSkillDto;
>>>>>>> a62b5e5 (day 14 finished)

public interface CvSkillService 
{
	DataResult<List<CvSkill>> getAll();
<<<<<<< HEAD
	DataResult<CvSkill> get(int id);
	Result add(CvSkill cvSkill);
=======
	DataResult<List<CvSkill>> getByCvMainId(int cvMainId);
	DataResult<CvSkill> get(int id);
	Result add(CvSkillDto cvSkillDto);
	Result delete(int id);
>>>>>>> a62b5e5 (day 14 finished)
}
