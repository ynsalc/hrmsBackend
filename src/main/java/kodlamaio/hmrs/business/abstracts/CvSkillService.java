package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvSkill;

public interface CvSkillService 
{
	DataResult<List<CvSkill>> getAll();
	DataResult<CvSkill> get(int id);
	Result add(CvSkill cvSkill);
}
