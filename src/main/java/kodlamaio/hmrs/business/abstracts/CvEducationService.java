package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;

import java.util.List;
import kodlamaio.hmrs.entities.concretes.CvEducation;
import kodlamaio.hmrs.entities.dtos.CvEducationAddDto;

public interface CvEducationService 
{
	DataResult<List<CvEducation>> getAll();
	DataResult<List<CvEducation>> getByCvMainId(int cvMainId);
	DataResult<CvEducation> get(int id);
	Result add(CvEducationAddDto cvEducationAddDto);
<<<<<<< HEAD
=======
	Result delete(int id);
>>>>>>> a62b5e5 (day 14 finished)
}
