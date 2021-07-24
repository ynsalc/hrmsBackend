package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CvMainService;
import kodlamaio.hmrs.core.utilities.cloudinaryImplements.CloudinaryService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvMainDao;
import kodlamaio.hmrs.entities.concretes.CvMain;
import kodlamaio.hmrs.entities.dtos.CandidateCvAddDto;

@Service
public class CvMainManager implements CvMainService
{
	@Autowired
	private CvMainDao cvMainDao;
	private CloudinaryService cloudinaryService;
	
	public CvMainManager(CvMainDao cvMainDao,CloudinaryService cloudinaryService) 
	{
		this.cvMainDao = cvMainDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<CvMain>> getAll() 
	{
		return new SuccessDataResult<List<CvMain>>(this.cvMainDao.findAll(),"Cv'ler Listelendi");
	}

	@Override
	public DataResult<List<CvMain>> getByCandidate_Id(int candidateId) 
	{
		return new SuccessDataResult<List<CvMain>>(this.cvMainDao.getByCandidate_Id(candidateId),"Adayın Cv bilgileri getirildi.");
	}

	@Override
	public DataResult<CvMain> get(int id) 
	{
		return new SuccessDataResult<CvMain>(this.cvMainDao.findById(id).orElse(null));
	}

	@Override
	public Result add(CandidateCvAddDto candidateCvAddDto) 
	{
		CvMain cvMain = new CvMain(candidateCvAddDto.getCandidateId(),candidateCvAddDto.getGithubAddress(),
				candidateCvAddDto.getLinkedinAddress(),candidateCvAddDto.getCoverLetter(),candidateCvAddDto.getCreateDate());
		this.cvMainDao.save(cvMain);
		return new SuccessResult("Başarıyla Eklendi.");
	}

	@Override
	public Result add(CvMain cvMain) 
	{
		this.cvMainDao.save(cvMain);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public Result uploadPhoto(int cvId, MultipartFile file) 
	{
		CvMain cvMain = this.get(cvId).getData();
		Map<String, String> result = (Map<String, String>)this.cloudinaryService.save(file).getData();
		String url = result.get("url");
		cvMain.setPhoto(url);
		this.cvMainDao.save(cvMain);
		return new SuccessResult("Resim eklendi.");
	}
}
