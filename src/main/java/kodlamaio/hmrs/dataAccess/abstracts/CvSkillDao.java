package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvSkill;

public interface CvSkillDao extends JpaRepository<CvSkill, Integer>
{
	
}
