package ncs.r4a118;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lec100Cnt {

	@RequestMapping("/lec1")
	public String show() {
		return "/lec1/lec101.html";
	}

	@RequestMapping("/")
	public String login() {
		return "/lec1/kanri_top.html";
	}
}
