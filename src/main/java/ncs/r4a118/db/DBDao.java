package ncs.r4a118.db;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface DBDao<T> {
	public List<T> select() throws DataAccessException;
	public List<T> select(String seachData) throws DataAccessException;
	public int insert(T type) throws DataAccessException;
	public T search(T type) throws DataAccessException;
	public int delete(T type) throws DataAccessException;
	public int update(T type) throws DataAccessException;
}
