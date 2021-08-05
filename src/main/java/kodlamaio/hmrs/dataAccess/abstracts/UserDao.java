package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>
{
<<<<<<< HEAD

=======
	User findByEmail(String email);
>>>>>>> a62b5e5 (day 14 finished)
}
