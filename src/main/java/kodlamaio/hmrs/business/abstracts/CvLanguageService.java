package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvLanguage;
import kodlamaio.hmrs.entities.dtos.CvLanguageDto;

public interface CvLanguageService 
{
	DataResult<List<CvLanguage>> getAll();
	DataResult<CvLanguage> get(int id);
	Result add(CvLanguage cvLanguage);
	DataResult<List<CvLanguage>> getByCvMainId(int cvMainId);
	DataResult<CvLanguage> get(int id);
	Result add(CvLanguageDto cvLanguageDto);
	Result delete(int id);
}
