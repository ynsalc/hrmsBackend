package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.WorkTimeType;

public interface WorkTimeTypeDao extends JpaRepository<WorkTimeType, Integer>
{

}
