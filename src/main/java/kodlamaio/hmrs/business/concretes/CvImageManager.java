package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CvImageService;
import kodlamaio.hmrs.business.abstracts.CvMainService;
import kodlamaio.hmrs.core.utilities.cloudinaryImplements.CloudinaryService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.ErrorResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvImageDao;
import kodlamaio.hmrs.entities.concretes.CvImage;
import kodlamaio.hmrs.entities.concretes.CvMain;

@Service
public class CvImageManager implements CvImageService
{

	private CvImageDao cvImageDao;
	private CloudinaryService cloudinaryService;
	private CvMainService cvMainService;
	
	@Autowired
	public CvImageManager(CvImageDao cvImageDao,CloudinaryService cloudinaryService,CvMainService cvMainService) {
		super();
		this.cvImageDao = cvImageDao;
		this.cloudinaryService = cloudinaryService;
		this.cvMainService = cvMainService;
	}

	@Override
	public DataResult<List<CvImage>> getAll() 
	{
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll(),"Resimler Listelendi.");
	}

	@Override
	public DataResult<CvImage> get(int id) 
	{
		return new SuccessDataResult<CvImage>(this.cvImageDao.getOne(id));
	}

	@Override
	public Result saveImage(MultipartFile file, int id) 
	{
		
			Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
			String imageUrl = uploader.get("url");
			CvMain cvMain = cvMainService.get(id).getData();
			CvMain cvMai = new CvMain();
			CvImage cvImage = new CvImage();
			cvImage.setUrlAdress(imageUrl);
			
			cvImageDao.save(cvImage);
		

        return new SuccessResult("Fotoğraf Ekleme Başarılı");
    
		
		
		
		
		
		/*if(cvMain == null) 
		{
			return new ErrorResult("Fotoğraf eklemek istediğiniz cv mevcut değil");
		}
		if(cvMain.getCvImage() == null) 
		{
			CvImage cvImage = new CvImage();
			cvImage.setUrlAdress(imageUrl);
			cvMain.setCvImage(cvImage);
		}
		else 
		{
			cvMain.getCvImage().setUrlAdress(imageUrl);
		}*/
		
		//this.cvMainService.add(cvMain);
		//return new SuccessResult("Fotoğraf başarıyla eklendi.");
	}

}
