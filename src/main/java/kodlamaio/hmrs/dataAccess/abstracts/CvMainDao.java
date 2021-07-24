package kodlamaio.hmrs.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvMain;

public interface CvMainDao extends JpaRepository<CvMain, Integer>
{
	List<CvMain> getByCandidate_Id(int candidateId);
}
