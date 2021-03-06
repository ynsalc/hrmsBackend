package kodlamaio.hmrs.core.utilities.cloudinaryImplements;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService
{
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) 
	{
		this.cloudinary=cloudinary;
	}

	@Override
	public DataResult<Map> save(MultipartFile file) 
	{
		try 
		{
			Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), 
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(cloudinaryUploader);
		}

		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}
