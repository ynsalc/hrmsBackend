package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.WorkTimeTypeService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.WorkTimeTypeDao;
import kodlamaio.hmrs.entities.concretes.WorkTimeType;

@Service
public class WorkTimeTypeManager implements WorkTimeTypeService
{
	private WorkTimeTypeDao workTimeTypeDao;
	
	@Autowired
	private WorkTimeTypeManager(WorkTimeTypeDao workTimeTypeDao) 
	{
		this.workTimeTypeDao = workTimeTypeDao;
	}

	@Override
	public DataResult<List<WorkTimeType>> getAll() 
	{
		return new SuccessDataResult<List<WorkTimeType>>(this.workTimeTypeDao.findAll(),"İş Çalışma Şekilleri listelendi.");
	}

	@Override
	public Result add(WorkTimeType workTimeType) 
	{
		this.workTimeTypeDao.save(workTimeType);
		return new SuccessResult("Başarıyla Eklendi.");
	}

}
