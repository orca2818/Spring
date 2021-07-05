package ncs.r4a118.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class UserInfoController {

	@Autowired
	private UserInfoService service;

	@GetMapping("/user")
	private List<UserInfo> findAll() {
		return service.findAll();
	}
}
