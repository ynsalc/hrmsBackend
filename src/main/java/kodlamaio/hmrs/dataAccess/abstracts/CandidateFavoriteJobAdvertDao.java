package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CandidateFavoriteJobAdvert;
import kodlamaio.hmrs.entities.dtos.CandidateFavoriteJobAdvertDto;

public interface CandidateFavoriteJobAdvertDao extends JpaRepository<CandidateFavoriteJobAdvert, Integer>
{
	List<CandidateFavoriteJobAdvert> findByCandidate_Id(int candidateId);
	List<CandidateFavoriteJobAdvert> findByCandidate_IdAndJobAdvertisement_Id(int candidateId, int jobAdvertId);
}
