package ncs.r4a118.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/rest")
public class UserInfoController {

	@Autowired
	private UserInfoService service;

	@RequestMapping("/view")
	private ModelAndView view(Model model) {
		var view = new ModelAndView();
		view.setViewName("/rest/user_input");
		model.addAttribute(new UserInfo());
		return view;
	}

	@RequestMapping("/view2")
	private ModelAndView updateView(Model model) {
		var view = new ModelAndView();
		view.setViewName("/rest/user_update");
		model.addAttribute("userList", service.findAll());
		model.addAttribute(new UserInfo());
		model.addAttribute("selectedUserInfo", service.findAll().get(0));
		System.out.println(service.findAll());
		return view;
	}

	@GetMapping("/updateView")
	private ModelAndView updateView(UserInfo userInfo, Model model) {
		var view = new ModelAndView();
		view.setViewName("/rest/user_update");
		model.addAttribute("userList", service.findAll());
		model.addAttribute(new UserInfo());
		try {
			model.addAttribute("selectedUserInfo", service.find(userInfo.getId()));
		} catch (Exception e) {
			model.addAttribute("selectedUserInfo", service.findAll().get(0));
		}
		System.out.println(service.find(userInfo.getId()));
		return view;
	}

	@PutMapping(value = "/user2", params = "update")
	private List<UserInfo> update2(UserInfo userInfo) {
		userInfo.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		service.update(userInfo);
		System.out.println(userInfo);
		return service.findAll();
	}

	@DeleteMapping(value = "/user2", params = "delete")
	private List<UserInfo> delete2(UserInfo userInfo) {
		service.delete(userInfo.getId());
		return service.findAll();
	}


	@GetMapping("/user")
	private List<UserInfo> findAll() {
		return service.findAll();
	}

	@PostMapping("/user")
	private List<UserInfo> insert(UserInfo userInfo) {
		//UserInfo userInfo = new UserInfo();
		//userInfo.setName("tanaka");
		//userInfo.setPasswd("tanaka");
		//userInfo.setRegistDate("2021-07-09 00:00:00");
		userInfo.setRegistDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		service.insert(userInfo);
		return service.findAll();
	}

	@PutMapping("/user")
	private List<UserInfo> update(UserInfo userInfo) {
		//UserInfo userInfo = new UserInfo();
		//userInfo.setId(4);
		//userInfo.setName("yamamoto");
		//userInfo.setPasswd("yamamoto");
		//userInfo.setUpdateDate("2021-07-09 10:00:00");
		userInfo.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		service.update(userInfo);
		return service.findAll();
	}

	@DeleteMapping("/user/{id}")
	private void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

	@DeleteMapping("/user")
	private List<UserInfo> delete(UserInfo userInfo) {
		service.delete(userInfo.getId());
		return findAll();
	}

}
