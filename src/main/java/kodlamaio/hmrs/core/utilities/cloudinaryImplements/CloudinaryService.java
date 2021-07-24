package kodlamaio.hmrs.core.utilities.cloudinaryImplements;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.result.DataResult;

public interface CloudinaryService 
{
	DataResult<Map> save(MultipartFile file);
}
