package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvExperience;
import kodlamaio.hmrs.entities.dtos.CvExperienceAddDto;

public interface CvExperienceService 
{
	DataResult<List<CvExperience>> getAll();
	DataResult<List<CvExperience>> getByCvMainId(int cvMainCv);
	DataResult<CvExperience> get(int id);
	Result add(CvExperienceAddDto cvExperienceAddDto);
	Result delete(int id);
}
