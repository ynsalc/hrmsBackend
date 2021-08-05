package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.CandidateFavoriteJobAdvert;
import kodlamaio.hmrs.entities.dtos.CandidateFavoriteJobAdvertDto;

public interface CandidateService 
{
	DataResult<List<Candidate>> GetAll();
	Result Add(Candidate candidate);
	DataResult<List<CandidateFavoriteJobAdvert>> getByCandidate_Id(int candidateId);
	Result favoriteJobAdvert(CandidateFavoriteJobAdvertDto candidateFavoriteJobAdvertDto);
	Result removeFavorite(int id);
}
