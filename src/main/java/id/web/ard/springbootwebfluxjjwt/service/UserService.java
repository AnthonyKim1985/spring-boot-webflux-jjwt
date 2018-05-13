/*
 * Ardiansyah | http://ard.web.id
 * 
 */
package id.web.ard.springbootwebfluxjjwt.service;

import id.web.ard.springbootwebfluxjjwt.entity.User;
import id.web.ard.springbootwebfluxjjwt.security.model.Role;
import java.util.Arrays;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author ardiansyah
 */
@Service
public class UserService {
	
	// this is just an example, you can load the user from the database from the repository
	
	//username:passwowrd -> user:user
	private final String userUsername = "user";// password: user
	private final User user = new User(userUsername, "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=", true, Arrays.asList(Role.ROLE_USER));
	
	//username:passwowrd -> admin:admin
	private final String adminUsername = "admin";// password: admin
	private final User admin = new User(adminUsername, "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true, Arrays.asList(Role.ROLE_ADMIN));
	
	
	public Mono<UserDetails> findUserDetailsByUsername(String username) {
		if (username.equals(userUsername)) {
			return Mono.just(user);
		} else if (username.equals(adminUsername)) {
			return Mono.just(admin);
		} else {
			return Mono.empty();
		}
	}
	
	public Mono<User> findByUsername(String username) {
		if (username.equals(userUsername)) {
			return Mono.just(user);
		} else if (username.equals(adminUsername)) {
			return Mono.just(admin);
		} else {
			return Mono.empty();
		}
	}
	
	
	
}
