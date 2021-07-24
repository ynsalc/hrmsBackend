package kodlamaio.hmrs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.AuthService;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController 
{
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) 
	{
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerForCandidate")
	public Result registerForCandidate(@RequestBody Candidate candidate, String passwordRepeat) 
	{
		return authService.registerForCandidate(candidate, passwordRepeat);
	}
	
	@PostMapping("/registerForEmployer")
	public Result registerForEmployer(@RequestBody Employer employer, String passwordRepeat) 
	{
		return authService.registerForEmployer(employer, passwordRepeat);
	}
}
