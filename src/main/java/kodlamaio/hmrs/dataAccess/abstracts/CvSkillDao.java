package kodlamaio.hmrs.dataAccess.abstracts;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> a62b5e5 (day 14 finished)
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvSkill;

public interface CvSkillDao extends JpaRepository<CvSkill, Integer>
{
<<<<<<< HEAD
	
=======
	List<CvSkill> getByCvMainId(int cvMainId);
>>>>>>> a62b5e5 (day 14 finished)
}
