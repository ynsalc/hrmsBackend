package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserService 
{
	DataResult<List<User>> GetAll();
	DataResult<User> getByEmail(String email);
	Result Add(User user);
}
