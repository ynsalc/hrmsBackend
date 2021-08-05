package kodlamaio.hmrs.dataAccess.abstracts;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> a62b5e5 (day 14 finished)
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvLanguage;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>
{
<<<<<<< HEAD

=======
	List<CvLanguage> getByCvMainId(int cvMainId);
>>>>>>> a62b5e5 (day 14 finished)
}
