package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService
{
	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> GetAll() 
	{
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"İş ilanları listelendi.");
	}

	@Override
	public Result Add(JobAdvertisement jobAdversitement) 
	{
		jobAdvertisementDao.save(jobAdversitement);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public DataResult<JobAdvertisement> get(int id) 
	{
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}

	@Override
	public Result Delete(JobAdvertisement jobAdversitement) 
	{
		jobAdvertisementDao.delete(jobAdversitement);
		return new SuccessResult("Silme işlemi başarılı");
	}

	
}
