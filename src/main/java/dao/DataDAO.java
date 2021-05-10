package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAO extends JdbcDaoSupport {

	@Autowired
	public DataDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<String> queryPublishers() {
		String sql = "Select name from ccps.Publishers@dw";

		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

	public List<String> queryAdvertisers() {
		String sql = "Select name from ccps.Advertisers@dw";

		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

}