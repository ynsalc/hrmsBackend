package kodlamaio.hmrs.core.utilities.validation.person;

import kodlamaio.hmrs.entities.concretes.User;

public interface PersonValidationService 
{
	boolean validate(User user);
}
