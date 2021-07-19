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

	public UserInfo find(Integer id) {
		return repository.findById(id).get();
	}

	public UserInfo insert(UserInfo userInfo) {
		return repository.save(userInfo);
	}

	public void delete(Integer id) {
		repository.deleteById(id);;
	}

	public UserInfo update(UserInfo userInfo) {
		return repository.save(userInfo);
	}

}
