package cm.ngnkm.securitymessage.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Represents a user in our system.
 *
 * <p>
 * In a real system use {@link PasswordEncoder} to ensure the password is secured
 * properly. This demonstration does not address this due to time restrictions.
 * </p>
 *
 * @author Rob Winch
 */

@Entity
public class User implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id 
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@NotEmpty(message="First name is required. ")
		private String firstName;
		
		@NotEmpty(message="Last name is required. ")
		private String lastName;
		
		
		@Email(message="Please provide a valid format email address. ")
		@NotEmpty(message="email is required. ")
		@Column(unique=true, nullable=false)
		private String email;
		
		
		@NotEmpty(message="password id required. ")
		private String password;
		

		public User() {
			super();
			
		}
		
		
		
		public User(String firstName, String lastName, String email, String password) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
		}



		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
}
