package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;

public interface CandidateService 
{
	DataResult<List<Candidate>> GetAll();
	Result Add(Candidate candidate);
}
