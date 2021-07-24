package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.School;

public interface SchoolService 
{
	DataResult<List<School>> getAll();
	DataResult<School> get(int id);
	Result add(School school);
}
