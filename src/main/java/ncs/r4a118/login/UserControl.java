package ncs.r4a118.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControl {

	@Autowired
	private UserDBManage manage;

	@RequestMapping("/")
	public String login() {
		return "login/login";
	}

}
