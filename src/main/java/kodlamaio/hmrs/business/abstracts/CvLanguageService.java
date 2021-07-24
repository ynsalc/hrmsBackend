package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvLanguage;

public interface CvLanguageService 
{
	DataResult<List<CvLanguage>> getAll();
	DataResult<CvLanguage> get(int id);
	Result add(CvLanguage cvLanguage);
}
