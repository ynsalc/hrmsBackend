package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.WorkTypeService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hmrs.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService
{
	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) 
	{
		this.workTypeDao = workTypeDao;
	}

	@Override
	public DataResult<List<WorkType>> getAll() 
	{
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(),"İş tipleri listelendi");
	}

	@Override
	public Result add(WorkType workType) 
	{
		this.workTypeDao.save(workType);
		return new SuccessResult("Başarıyla Eklendi.");
	}

}
