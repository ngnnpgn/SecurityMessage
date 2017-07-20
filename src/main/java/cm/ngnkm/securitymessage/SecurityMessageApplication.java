package cm.ngnkm.securitymessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cm.ngnkm.securitymessage.data.User;
import cm.ngnkm.securitymessage.data.UserRepository;

@SpringBootApplication
public class SecurityMessageApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args){
		SpringApplication.run(SecurityMessageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.save(new User("Franck", "Ngankam", "ngankam@yahoo.fr", "ngankam"));
		
		List<User> users = (List<User>) userRepository.findAll();
		
		users.forEach(u->System.out.println(u.getFirstName()));
		
	}
}
