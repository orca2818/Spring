package ncs.r4a118.shop;

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
public class ProductDBManage extends JdbcDaoSupport implements DBDao<Product> {

	//sql
	private final String selectSql = "select pro_code, pro_name, pro_price, pro_unit, pro_desc, pro_img from products";

	@Autowired
	private DataSource dataSource;

	public ProductDBManage() {}

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Product> select() throws DataAccessException {
		RowMapper<Product> map = (rs,rowNum) -> {
			Product item = new Product();
			item.setCode(rs.getInt("pro_code"));
			item.setName(rs.getString("pro_name"));
			item.setPrice(rs.getInt("pro_price"));
			item.setUnit(rs.getString("pro_unit"));
			item.setDesc(rs.getString("pro_desc"));
			item.setImg(rs.getString("pro_img"));
			return item;
		};
		return getJdbcTemplate().query(selectSql, map);
	}

	@Override
	public List<Product> select(String seachData) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int insert(Product type) throws DataAccessException {
		return 0;
	}

	@Override
	public Product search(Product type) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int delete(Product type) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int update(Product type) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
