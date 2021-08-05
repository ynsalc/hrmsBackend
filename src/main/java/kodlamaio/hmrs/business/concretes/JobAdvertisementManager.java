package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
>>>>>>> a62b5e5 (day 14 finished)
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
<<<<<<< HEAD
=======
import kodlamaio.hmrs.entities.dtos.JobAdvertisementFilter;
>>>>>>> a62b5e5 (day 14 finished)

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

<<<<<<< HEAD
=======
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(Boolean isActive) 
	{
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActive(isActive),"Aktif olan iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_Id(int employerId) 
	{
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByEmployer_Id(employerId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCity_IdAndWorkType_IdAndJobPosition_Id(int cityId, int workTypeId, int jobPositionId)
	{
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCity_IdAndWorkType_IdAndJobPosition_Id(cityId, workTypeId, jobPositionId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByFilteredAndPaged(int pageNo, int pageSize,
			JobAdvertisementFilter filterOption) 
	{
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getFilteringAndPage(filterOption, pageable).getContent(), this.jobAdvertisementDao.getFilteringAndPage(filterOption, pageable).getTotalElements() + "");
	}


>>>>>>> a62b5e5 (day 14 finished)
	
}
