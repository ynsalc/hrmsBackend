package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvImage;

public interface CvImageService 
{
	DataResult<List<CvImage>> getAll();
	DataResult<CvImage> get(int id);
	Result saveImage(MultipartFile file, int id);
}
