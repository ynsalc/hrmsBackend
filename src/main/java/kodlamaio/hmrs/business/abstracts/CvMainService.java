package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.CvMain;
import kodlamaio.hmrs.entities.dtos.CandidateCvAddDto;

public interface CvMainService 
{
	DataResult<List<CvMain>> getAll();
	DataResult<List<CvMain>> getByCandidate_Id(int candidateId);
	DataResult<CvMain> get(int id);
	Result add(CandidateCvAddDto candidateCvAddDto);
	Result add(CvMain cvMain);
	Result uploadPhoto(int cvId, MultipartFile file);
<<<<<<< HEAD
=======
	Result update(String githubLink, String linkedinLink, String coverLetter, int cvMainId);
>>>>>>> a62b5e5 (day 14 finished)
}
