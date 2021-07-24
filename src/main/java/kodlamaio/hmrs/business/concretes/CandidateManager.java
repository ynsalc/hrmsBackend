package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.ErrorResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.core.utilities.validation.person.PersonValidationService;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateDao;
import kodlamaio.hmrs.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService
{
	private CandidateDao candidateDao;
	private PersonValidationService personValidationService;
	private ModelMapper modelMapper;
	private UserService userService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			PersonValidationService personValidationService,
			ModelMapper modelMapper,UserService userService) 
	{
		super();
		this.candidateDao=candidateDao;
		this.personValidationService=personValidationService;
		this.modelMapper=modelMapper;
		this.userService=userService;
	}

	@Override
	public DataResult<List<Candidate>> GetAll() 
	{
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"İş Arayanlar Listelendi");
	}

	@Override
	public Result Add(Candidate candidate) 
	{
		if (candidate.getFirstName() != null && candidate.getLastName() != null 
				&& candidate.getEmail()!= null && candidate.getPassword() != null && candidate.getBirthDate() != null)
		{
			if(this.checkIfEmailAddressExists(candidate.getEmail()))
			{
				return new ErrorResult("Bu mail adresiyle bir hesap kayıt olmuş");
			}
			else 
			{
				if(personValidationService.validate(candidate)) 
				{
					Candidate can = modelMapper.map(candidate, Candidate.class);
					candidateDao.save(can);
					return new SuccessResult("İş Arayan Eklendi");
				}
			}
			
		}
		return new ErrorResult("İş Arayan Eklenemedi");
	}
	
	private boolean checkIfEmailAddressExists(String emailAddress) 
	{
		boolean isEmailAddressExists = this.userService.GetAll().getData().stream()
				.filter(u -> u.getEmail().equals(emailAddress))
				.findFirst().isPresent();
		return isEmailAddressExists;
	}
	
}
