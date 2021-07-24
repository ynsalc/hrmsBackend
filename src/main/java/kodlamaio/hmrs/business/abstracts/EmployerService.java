package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerService 
{
	DataResult<List<Employer>> getAll();
	Result Add(Employer employer);
	DataResult<Employer> get(int id);
}
