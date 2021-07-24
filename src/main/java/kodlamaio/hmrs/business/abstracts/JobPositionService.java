package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;

public interface JobPositionService 
{
	DataResult<List<JobPosition>> getAll();
	Result Add(JobPosition jobPosition);
}
