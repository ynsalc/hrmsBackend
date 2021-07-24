package kodlamaio.hmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.AuthService;
import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.core.utilities.result.ErrorResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.core.utilities.validation.mail.MailValidationService;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService
{
	private CandidateService candidateService;
	private EmployerService employerService;
	private MailValidationService mailValidationService;
	
	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService,
			MailValidationService mailValidationService) 
	{
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.mailValidationService = mailValidationService;
	}

	@Override
	public Result registerForCandidate(Candidate candidate, String passwordRepeat) 
	{
		if(!checkPasswordRepeat(candidate.getPassword(),passwordRepeat)) 
		{
			return new ErrorResult("Şifreler uyuşmuyor!");
		}
		
		var result = this.candidateService.Add(candidate);
		
		if(result.isSuccess())
		{
			if (validationService(candidate.getEmail())) 
			{
				return new SuccessResult("İş arayan kaydı başarılı.");
			}
		}
		
		return new ErrorResult(result.getMessage());
	}

	@Override
	public Result registerForEmployer(Employer employer, String passwordRepeat) 
	{
		if(!checkPasswordRepeat(employer.getPassword(),passwordRepeat)) 
		{
			return new ErrorResult("Şifreler uyuşmuyor!");
		}
		
		var result = this.employerService.Add(employer);
		
		if(result.isSuccess())
		{
			if (validationService(employer.getEmail())) 
			{
				return new SuccessResult("İş veren kaydı başarılı.");
			}
		}
		
		return new ErrorResult(result.getMessage());
	}
	
	private boolean checkPasswordRepeat(String password, String passwordRepeat) 
	{
		if (!password.equals(passwordRepeat)) {
			return false;
		}
		return true;
	}

	private boolean validationService(String email) 
	{
		String code = this.mailValidationService.codeGenerator(); 
		if (!this.mailValidationService.mailSend(email, code)) { 
			return false;
		}
		return true;
	}

}
