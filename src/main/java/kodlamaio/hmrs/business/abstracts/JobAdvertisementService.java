package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementFilter;

public interface JobAdvertisementService 
{
	DataResult<List<JobAdvertisement>> GetAll();
	Result Add(JobAdvertisement jobAdversitement);
	Result Delete(JobAdvertisement jobAdversitement);
	DataResult<JobAdvertisement> get(int id);
	DataResult<List<JobAdvertisement>> getByIsActive(Boolean isActive);
	DataResult<List<JobAdvertisement>> getByEmployer_Id(int employerId);
	DataResult<List<JobAdvertisement>> getByCity_IdAndWorkType_IdAndJobPosition_Id(int cityId, int workTypeId, int jobPositionId);
	DataResult<List<JobAdvertisement>> getAllByFilteredAndPaged(int pageNo, int pageSize, JobAdvertisementFilter filterOption);
}
