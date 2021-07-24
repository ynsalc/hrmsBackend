package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer>
{
	List<CvExperience> getByCvMainId(int cvMainId);
}
