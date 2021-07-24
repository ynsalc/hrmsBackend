package kodlamaio.hmrs.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.ErrorResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService
{
	private EmployerDao employerDao;
	private UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService) 
	{
		super();
		this.employerDao = employerDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Employer>> getAll()
	{
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"İşverenler Listelendi"); 
	}

	@Override
	public Result Add(Employer employer) 
	{
		if(checkIfEmailAddressExists(employer.getEmail()))
		{
			return new ErrorResult("Bu mail adresi kullanılıyor.");
		}
		else if(!checkIfEqualEmailAndDomain(employer.getEmail(),employer.getWebAdress()))
		{
			return new ErrorResult("Web sitesi ile aynı domaine sahip e-posta olduğundan emin olunuz");
		}
		employerDao.save(employer);
		return new SuccessResult("İşveren Eklendi");
		
	}

	private boolean checkIfEmailAddressExists(String emailAddress) 
	{
		boolean isEmailAddressExists = this.userService.GetAll().getData().stream()
				.filter(u -> u.getEmail().equals(emailAddress))
				.findFirst().isPresent();
		return isEmailAddressExists;
	}
	
	private boolean checkIfEqualEmailAndDomain(String email, String website) {

		String[] webAdressKeywords = { "www", "http://www", "https://www" };

		String[] emailDomain = email.split("@", 2);

		String domain = "";
		String[] websiteDomain = website.split("\\.", 2);
		if (Arrays.asList(webAdressKeywords).contains(websiteDomain[0])) {
			domain = websiteDomain[1];
		} else {
			domain = website;
		}

		if (!emailDomain[1].equals(domain)) {
			System.out.println("Domain hatası");
			return false;
		}
		return true;
	}

	@Override
	public DataResult<Employer> get(int id) 
	{
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}
}
