package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService 
{
	DataResult<List<JobAdvertisement>> GetAll();
	Result Add(JobAdvertisement jobAdversitement);
	Result Delete(JobAdvertisement jobAdversitement);
	DataResult<JobAdvertisement> get(int id);
}
