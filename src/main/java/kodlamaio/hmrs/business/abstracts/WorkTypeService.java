package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.WorkType;

public interface WorkTypeService 
{
	DataResult<List<WorkType>> getAll();
	Result add(WorkType workType);
}
