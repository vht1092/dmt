package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import entity.DisputesIssCard;
import entity.DisputesUser;

@Repository
public class LoginDAO extends JdbcDaoSupport {

	@Autowired
	public LoginDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	// public String blockSqlInjection(String str) {
	// String data = null;
	// if (str != null && str.length() > 0) {
	// str = str.replace("\\", "\\\\");
	// str = str.replace("'", "\\'");
	// str = str.replace("\0", "\\0");
	// str = str.replace("\n", "\\n");
	// str = str.replace("\r", "\\r");
	// str = str.replace("\"", "\\\"");
	// str = str.replace("\\x1a", "\\Z");
	// data = str;
	// }
	// return data;
	// }

	public DisputesUser get_DetailUser(String username) throws SQLException {
		DisputesUser user = new DisputesUser();
		String sql = "Select * from ccps.disputes_user_v2 where USER_USERNAME = ? AND ROWNUM = 1";

		Connection connect = getConnection();
		
		ResultSet rs;
		try {
			PreparedStatement preStmt = connect.prepareStatement(sql);
			preStmt.setString(1, username.toLowerCase());
			rs = preStmt.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setFullname(rs.getString("USER_FULLNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setUserFirstLogin(rs.getInt("USER_FIRST_LOGIN"));
				user.setUserFirstTimeLogin(rs.getString("USER_FIRST_TIME_LOGIN"));
				user.setStatus(rs.getString("USER_STATUS"));
				user.setUserLoginFail(rs.getInt("USER_LOGIN_FAIL"));
				user.setUserRole(rs.getString("USER_ROLE"));
			}
			
			preStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public List<DisputesUser> get_DetailUser_TypeList(String username) throws SQLException {
		List<DisputesUser> listUser = new ArrayList<DisputesUser>();
		DisputesUser user = new DisputesUser();
		String sql = "Select * from ccps.disputes_user_v2 where USER_USERNAME = ?";

		Connection connect = getConnection();
		
		ResultSet rs;
		try {
			PreparedStatement preStmt = connect.prepareStatement(sql);
			preStmt.setString(1, username.toLowerCase());
			rs = preStmt.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setFullname(rs.getString("USER_FULLNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setUserFirstLogin(rs.getInt("USER_FIRST_LOGIN"));
				user.setUserFirstTimeLogin(rs.getString("USER_FIRST_TIME_LOGIN"));
				user.setStatus(rs.getString("USER_STATUS"));
				user.setUserLoginFail(rs.getInt("USER_LOGIN_FAIL"));
				user.setUserRole(rs.getString("USER_ROLE"));
			}
			
			preStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUser;
	}

	public DisputesUser findUserLogin(String username) throws SQLException {
		DisputesUser user = new DisputesUser();
		String sql = "Select * from ccps.disputes_user_v2 where USER_USERNAME = ? AND ROWNUM = 1";

		Connection connect = getConnection();
		
		ResultSet rs;
		try {
			PreparedStatement preStmt = connect.prepareStatement(sql);
			preStmt.setString(1, username.toLowerCase());
			rs = preStmt.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setFullname(rs.getString("USER_FULLNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setUserFirstLogin(rs.getInt("USER_FIRST_LOGIN"));
				user.setUserFirstTimeLogin(rs.getString("USER_FIRST_TIME_LOGIN"));
				user.setStatus(rs.getString("USER_STATUS"));
				user.setUserLoginFail(rs.getInt("USER_LOGIN_FAIL"));
				user.setUserRole(rs.getString("USER_ROLE"));
			}
			
			preStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public List<DisputesUser> listAllUser() {
		List<DisputesUser> listUser = new ArrayList<DisputesUser>();
		
		String sql = "Select * from ccps.disputes_user_v2";

		Connection connect = getConnection();
		
		ResultSet rs;
		try {
			PreparedStatement preStmt = connect.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while(rs.next()) {
				DisputesUser user = new DisputesUser();
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setFullname(rs.getString("USER_FULLNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setUserFirstLogin(rs.getInt("USER_FIRST_LOGIN"));
				user.setUserFirstTimeLogin(rs.getString("USER_FIRST_TIME_LOGIN"));
				user.setStatus(rs.getString("USER_STATUS"));
				user.setUserLoginFail(rs.getInt("USER_LOGIN_FAIL"));
				user.setUserRole(rs.getString("USER_ROLE"));
				listUser.add(user);
			}
			
			preStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUser;
	}

	public void updatePasswordUserLogin(long input_systemTime, String input_username, String input_password) {
		// Cap nhat du lieu qua Bang disputes_user_history_v2
		String sqlHistory = "INSERT INTO disputes_user_history_v2 SELECT * FROM disputes_user_v2 WHERE user_username = 'input_username'";
		sqlHistory = sqlHistory.replaceAll("input_username", input_username);
		getJdbcTemplate().update(sqlHistory);

		// Cap nhat new_password cho bang disputes_user_v2
		String sql = "UPDATE ccps.disputes_user_v2 SET USER_PASSWORD = 'input_password', USER_FIRST_LOGIN = 1, USER_FIRST_TIME_LOGIN = 'input_systemTime', USER_LOGIN_FAIL = '0', USER_STATUS = '0' WHERE USER_USERNAME = 'input_username'";
		sql = sql.replaceAll("input_username", input_username);
		sql = sql.replaceAll("input_password", input_password);
		sql = sql.replaceAll("input_systemTime", String.valueOf(input_systemTime));
		getJdbcTemplate().update(sql);
		return;
	}

	// Cap nhat thoi gian dang nhap
	public void updateTimeLastLogin(long input_systemTime, String input_username) {
		// Cap nhat new_password cho bang disputes_user_v2
		String sql = "UPDATE ccps.disputes_user_v2 SET USER_LAST_TIME_LOGIN = 'input_systemTime' WHERE USER_USERNAME = 'input_username'";
		sql = sql.replaceAll("input_username", input_username);
		sql = sql.replaceAll("input_systemTime", String.valueOf(input_systemTime));
		getJdbcTemplate().update(sql);
		return;
	}

	// Cap nhat so lan dang nhap sai, neu dang nhap sai 3 lan se bi khoa user
	public void updateLoginFail(String input_username) throws SQLException {
		DisputesUser user = new DisputesUser();
		user = get_DetailUser(input_username);
		int soLanDangNhapSai = user.getUserLoginFail() + 1;

		// Cap nhat bang disputes_user_v2
		String sql = null;
		// Neu dang nhap sai den lan thu 3 se bi khoa user USER_STATUS = '1'
		if (soLanDangNhapSai > 3) {
			sql = "UPDATE ccps.disputes_user_v2 SET USER_STATUS = '1' WHERE USER_USERNAME = 'input_username'";
		} else {
			sql = "UPDATE ccps.disputes_user_v2 SET USER_LOGIN_FAIL = 'soLanDangNhapSai' WHERE USER_USERNAME = 'input_username'";
			sql = sql.replaceAll("soLanDangNhapSai", String.valueOf(soLanDangNhapSai));
		}
		sql = sql.replaceAll("input_username", input_username);
		getJdbcTemplate().update(sql);
		return;
	}
}