package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
<<<<<<< HEAD
=======
import kodlamaio.hmrs.entities.dtos.CvLanguageDto;
>>>>>>> a62b5e5 (day 14 finished)

public interface CvLanguageService 
{
	DataResult<List<CvLanguage>> getAll();
<<<<<<< HEAD
	DataResult<CvLanguage> get(int id);
	Result add(CvLanguage cvLanguage);
=======
	DataResult<List<CvLanguage>> getByCvMainId(int cvMainId);
	DataResult<CvLanguage> get(int id);
	Result add(CvLanguageDto cvLanguageDto);
	Result delete(int id);
>>>>>>> a62b5e5 (day 14 finished)
}
