package ncs.r4a118.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
	@Autowired
	UserInfoRepository repository;

	public List<UserInfo> findAll() {
		return repository.findAll();
	}
}
