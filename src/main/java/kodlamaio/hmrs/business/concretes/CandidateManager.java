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
<<<<<<< HEAD
import kodlamaio.hmrs.entities.concretes.Candidate;
=======
import kodlamaio.hmrs.dataAccess.abstracts.CandidateFavoriteJobAdvertDao;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.CandidateFavoriteJobAdvert;
import kodlamaio.hmrs.entities.dtos.CandidateFavoriteJobAdvertDto;
>>>>>>> a62b5e5 (day 14 finished)

@Service
public class CandidateManager implements CandidateService
{
	private CandidateDao candidateDao;
	private PersonValidationService personValidationService;
	private ModelMapper modelMapper;
	private UserService userService;
<<<<<<< HEAD
=======
	private CandidateFavoriteJobAdvertDao candidateFavoriteJobAdvertDao;
>>>>>>> a62b5e5 (day 14 finished)
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			PersonValidationService personValidationService,
<<<<<<< HEAD
			ModelMapper modelMapper,UserService userService) 
=======
			ModelMapper modelMapper,UserService userService,CandidateFavoriteJobAdvertDao candidateFavoriteJobAdvertDao) 
>>>>>>> a62b5e5 (day 14 finished)
	{
		super();
		this.candidateDao=candidateDao;
		this.personValidationService=personValidationService;
		this.modelMapper=modelMapper;
		this.userService=userService;
<<<<<<< HEAD
=======
		this.candidateFavoriteJobAdvertDao=candidateFavoriteJobAdvertDao;
>>>>>>> a62b5e5 (day 14 finished)
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
<<<<<<< HEAD
=======

	@Override
	public DataResult<List<CandidateFavoriteJobAdvert>> getByCandidate_Id(int candidateId) 
	{
		return new SuccessDataResult<List<CandidateFavoriteJobAdvert>>(this.candidateFavoriteJobAdvertDao.findByCandidate_Id(candidateId),"Favoriler Listelendi");
	}

	@Override
	public Result favoriteJobAdvert(CandidateFavoriteJobAdvertDto candidateFavoriteJobAdvertDto) 
	{
		boolean isThereSameFavorite = !this.candidateFavoriteJobAdvertDao.findByCandidate_IdAndJobAdvertisement_Id(candidateFavoriteJobAdvertDto.getCandidateId(), candidateFavoriteJobAdvertDto.getJobAdvertId()).isEmpty();
		
		if(isThereSameFavorite)
			return new ErrorResult("Favorilerinizde zaten mevcut..!");
		
		CandidateFavoriteJobAdvert favoriteJobAdvert = new CandidateFavoriteJobAdvert(candidateFavoriteJobAdvertDto.getId(),candidateFavoriteJobAdvertDto.getCandidateId(),candidateFavoriteJobAdvertDto.getJobAdvertId());
		this.candidateFavoriteJobAdvertDao.save(favoriteJobAdvert);
		return new SuccessResult("Favorilere Eklendi");
	}

	@Override
	public Result removeFavorite(int id) 
	{
		if(!this.candidateFavoriteJobAdvertDao.existsById(id))
		{
			return new ErrorResult("Böyle bir favori ilan yok");
		}
		this.candidateFavoriteJobAdvertDao.deleteById(id);
		return new SuccessResult("Favori İlan Silindi");
	}
>>>>>>> a62b5e5 (day 14 finished)
	
}
