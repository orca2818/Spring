package ncs.r4a118.login;

import java.util.Objects;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//@SessionAttributes("userInfo")
public class UserControl {

	@Autowired
	private UserDBManage manage;
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String login(Model model) {
		model.addAttribute(new UserInfo());
		return "login/login";
	}


	@RequestMapping("/kanri/login")
	public String login(@Valid UserInfo userInfo, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			UserInfo user = manage.search(userInfo);
			//該当のユーザが存在した場合
			if (!Objects.equals(null, user)) {
				session.setAttribute("userInfo", user.getName());
				return "redirect:http://127.0.0.1:8080/product/select";
			}
			//該当のユーザが存在しない場合
			model.addAttribute("err", "ユーザ名かパスワードが間違っています");
		}
		return "login/login";
	}

	@RequestMapping("/kanri/logout")
	public String logout(SessionStatus status) {
		session.removeAttribute("userInfo");
		//status.setComplete();
		return "login/logout";
	}

}
