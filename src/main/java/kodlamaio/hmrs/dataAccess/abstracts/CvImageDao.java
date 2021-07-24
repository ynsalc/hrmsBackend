package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage, Integer>
{

}
