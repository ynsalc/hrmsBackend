package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserService 
{
	DataResult<List<User>> GetAll();
<<<<<<< HEAD
=======
	DataResult<User> getByEmail(String email);
>>>>>>> a62b5e5 (day 14 finished)
	Result Add(User user);
}
