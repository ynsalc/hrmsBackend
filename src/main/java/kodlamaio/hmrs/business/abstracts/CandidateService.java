package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
<<<<<<< HEAD
=======
import kodlamaio.hmrs.entities.concretes.CandidateFavoriteJobAdvert;
import kodlamaio.hmrs.entities.dtos.CandidateFavoriteJobAdvertDto;
>>>>>>> a62b5e5 (day 14 finished)

public interface CandidateService 
{
	DataResult<List<Candidate>> GetAll();
	Result Add(Candidate candidate);
<<<<<<< HEAD
=======
	DataResult<List<CandidateFavoriteJobAdvert>> getByCandidate_Id(int candidateId);
	Result favoriteJobAdvert(CandidateFavoriteJobAdvertDto candidateFavoriteJobAdvertDto);
	Result removeFavorite(int id);
>>>>>>> a62b5e5 (day 14 finished)
}
