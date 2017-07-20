package cm.ngnkm.securitymessage.data;

import org.springframework.data.repository.CrudRepository;


/**
 * Allows managing {@link User} instances.
 *
 * @author ngnkm
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
}
