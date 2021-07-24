package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService
{
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) 
	{
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() 
	{
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Meslekler Listelendi");
	}

	@Override
	public Result Add(JobPosition jobPosition) 
	{
		jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi.");
	}

}
