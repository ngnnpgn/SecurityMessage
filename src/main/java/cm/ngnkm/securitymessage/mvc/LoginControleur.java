package cm.ngnkm.securitymessage.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControleur {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
