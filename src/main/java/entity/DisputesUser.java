package entity;

import java.io.Serializable;

public class DisputesUser implements Serializable {

	private String username;
	private String password;
	private String fullname;
	private int userFirstLogin; // 0: userFirstLogin
	private int userLoginFail;
	private String status;
	private String userFirstTimeLogin;
	private String userLastTimeLogin;
	private String userRole;

	public void DisputesUsers(String username, String password, String fullname, int userFirstLogin) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.userFirstLogin = userFirstLogin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void DisputesUsers() {
	}

	public void DisputesUsers(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getUserFirstLogin() {
		return userFirstLogin;
	}

	public void setUserFirstLogin(int userFirstLogin) {
		this.userFirstLogin = userFirstLogin;
	}

	public int getUserLoginFail() {
		return userLoginFail;
	}

	public void setUserLoginFail(int userLoginFail) {
		this.userLoginFail = userLoginFail;
	}

	public String getUserLastTimeLogin() {
		return userLastTimeLogin;
	}

	public void setUserLastTimeLogin(String userLastTimeLogin) {
		this.userLastTimeLogin = userLastTimeLogin;
	}

	public String getUserFirstTimeLogin() {
		return userFirstTimeLogin;
	}

	public void setUserFirstTimeLogin(String userFirstTimeLogin) {
		this.userFirstTimeLogin = userFirstTimeLogin;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
