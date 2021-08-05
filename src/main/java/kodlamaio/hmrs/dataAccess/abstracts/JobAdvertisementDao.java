package kodlamaio.hmrs.dataAccess.abstracts;


<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
=======
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementFilter;
>>>>>>> a62b5e5 (day 14 finished)

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>
{
	JobAdvertisement getById(int id);
<<<<<<< HEAD
=======
	List<JobAdvertisement> getByIsActive(Boolean isActive);
	List<JobAdvertisement> getByEmployer_Id(int employerId);
	List<JobAdvertisement> getByCity_IdAndWorkType_IdAndJobPosition_Id(int cityId, int workTypeId, int jobPositionId);
	
	@Query("Select j from JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
			+ "and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
			+ "and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))")
	public Page<JobAdvertisement> getFilteringAndPage(@Param("filter") JobAdvertisementFilter filters, Pageable pageable);
>>>>>>> a62b5e5 (day 14 finished)
}
