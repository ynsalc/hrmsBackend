package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class UserManager implements UserService
{
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> GetAll() 
	{
		return new SuccessDataResult<List<User>>(userDao.findAll(),"Kullanıcılar listelendi");
	}

	@Override
	public Result Add(User user) 
	{
		userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}

<<<<<<< HEAD
=======
	@Override
	public DataResult<User> getByEmail(String email) 
	{
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"E-mail adresine göre kullanıcı listelendi.");
	}

>>>>>>> a62b5e5 (day 14 finished)
}
