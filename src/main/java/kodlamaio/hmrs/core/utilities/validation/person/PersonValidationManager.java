package kodlamaio.hmrs.core.utilities.validation.person;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.entities.concretes.User;

public class PersonValidationManager implements PersonValidationService
{

	@Override
	public boolean validate(User user) 
	{
		return true;
	}

}
