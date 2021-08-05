package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvSkill;
import kodlamaio.hmrs.entities.dtos.CvSkillDto;

public interface CvSkillService 
{
	DataResult<List<CvSkill>> getAll();
	DataResult<CvSkill> get(int id);
	Result add(CvSkill cvSkill);
	DataResult<List<CvSkill>> getByCvMainId(int cvMainId);
	DataResult<CvSkill> get(int id);
	Result add(CvSkillDto cvSkillDto);
	Result delete(int id);
}
