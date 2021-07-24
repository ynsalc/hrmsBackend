package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.WorkTimeType;

public interface WorkTimeTypeService 
{
	DataResult<List<WorkTimeType>> getAll();
	Result add(WorkTimeType workTimeType);
}
