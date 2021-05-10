package dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import entity.DisputesIssCard;
import entity.DisputesUser;

@Repository
public class CommonDAO extends JdbcDaoSupport {

	@Autowired
	public CommonDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public String maHoaSoThe(String cardno) {
		if(cardno.length()>=16) {
			String sql = "select ccps.ecd2( " + cardno + ", '') from dual";
			return getJdbcTemplate().queryForObject(sql, String.class);
		}
		else return null;
	}

	public String checkCardBrand(String cardno) {
		String sql = "select trim(b.FX_IR121_CONTCLESS_SERV_CDE) from ccps.IR025@im a, ccps.IR121@im b"
				+ " where PX_IR025_PAN = '111' and trim(a.FX_IR025_CRD_PGM) = trim(b.PX_IR121_CRD_PGM)";
		sql = sql.replaceAll("111", cardno);

		String cardBrand = null;
		try {
			cardBrand = String.valueOf(getJdbcTemplate().queryForObject(sql, String.class));
		} catch (Exception e) {
			// cardBrand = null
		}
		return cardBrand;
	}

	
}