package ncs.r4a118.login;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import ncs.r4a118.db.DBDao;

@Service
public class UserDBManage extends JdbcDaoSupport implements DBDao<UserInfo> {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<UserInfo> select() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<UserInfo> select(String seachData) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int insert(UserInfo type) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public UserInfo search(UserInfo userInfo) throws DataAccessException {
		String searchSql = "select id, name from users where name=? and passwd=?";

		RowMapper<UserInfo> map = (rs,rowNum) -> {
			UserInfo user = new UserInfo();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			return user;
		};

		Object[] param = {userInfo.getName(),userInfo.getPasswd()};

		try {
			return getJdbcTemplate().query(searchSql, param, map).get(0);
		} catch (Exception e) {}
		return null;
	}

	@Override
	public int delete(UserInfo type) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int update(UserInfo type) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
