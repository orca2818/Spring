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
	private final String seacrhSql = "select pro_code, pro_name, pro_price, pro_unit, pro_desc, pro_img from products where pro_code=?";
	private final String insertSql = "insert into products(pro_name, pro_price, pro_unit, pro_desc, pro_img) values(?,?,?,?,?)";
	private final String deleteSql = "delete from products where pro_code=?";
	private final String updateSql = "update products set pro_name=?, pro_price=?, pro_unit=?, pro_desc=?, pro_img=? where pro_code=?";

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
	public int insert(Product product) throws DataAccessException {
		Object[] param = {
				product.getName(),
				product.getPrice(),
				product.getUnit(),
				product.getDesc(),
				product.getImg()};
		return getJdbcTemplate().update(insertSql, param);
	}

	@Override
	public Product search(Product product) throws DataAccessException {
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
		return getJdbcTemplate().query(seacrhSql, new Object[] {product.getCode()}, map).get(0);
	}

	@Override
	public int delete(Product product) throws DataAccessException {
		Object[] param = {product.getCode()};
		return getJdbcTemplate().update(deleteSql, param);
	}

	@Override
	public int update(Product product) throws DataAccessException {
		Object[] param = {
				product.getName(),
				product.getPrice(),
				product.getUnit(),
				product.getDesc(),
				product.getImg(),
				product.getCode()};
		return getJdbcTemplate().update(updateSql, param);
	}

}
