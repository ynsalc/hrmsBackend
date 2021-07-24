package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>
{

}
