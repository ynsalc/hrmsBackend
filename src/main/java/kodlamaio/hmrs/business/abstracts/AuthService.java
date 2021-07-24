package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface AuthService 
{
	Result registerForCandidate(Candidate candidate, String passwordRepeat);
	Result registerForEmployer(Employer employer, String passwordRepeat);
}
